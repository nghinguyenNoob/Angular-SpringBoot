import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private router: Router, private employeeservice: EmployeeService, private fb: FormBuilder) { }

  employee: Employee = new Employee();
  maxIdEmployee: number;
  submitted = false;
  employeesaveform: FormGroup;
  mobNumberPattern = '^(09|03|04|05|06|07|08)+([0-9]{8})$';
  ngOnInit() {
    this.submitted = false;
    this.employeeservice.getMaxIdEmployee().subscribe(data => {
      this.maxIdEmployee = data;
      console.log('this.maxIdEmployee', this.maxIdEmployee);
    });
    this.employeesaveform = this.fb.group({
      name: ['', Validators.required],
      phone: ['', Validators.required],
      address: ['', Validators.required],
      gender: [''],
      birthday: [''],
      mail: ['']
    });
  }

  saveEmployee(saveEmployee) {
    this.employee.id = this.maxIdEmployee + 1;
    this.employee.name = this.EmployeeName.value;
    this.employee.gender = this.EmployeeGender.value;
    this.employee.phone = this.EmployeePhone.value;
    this.employee.address = this.EmployeeAddress.value;
    this.employee.mail = this.EmployeeMail.value;
    this.employee.birthday = this.EmployeeBirthday.value;
    this.submitted = true;
    this.save();
  }

  save() {
    this.employeeservice.createEmployee(this.employee.id, this.employee).subscribe(data => {
      console.log(data);
      this.router.navigate(['ListEmployee']);
      this.employee = new Employee();
    },
      error => {
        console.log(error)
        this.router.navigate(['ListEmployee']);
        this.employee = new Employee();
      });
  }

  get EmployeeName() {
    return this.employeesaveform.get('name');
  }

  get EmployeePhone() {
    return this.employeesaveform.get('phone');
  }

  get EmployeeAddress() {
    return this.employeesaveform.get('address');
  }

  get EmployeeGender() {
    return this.employeesaveform.get('gender');
  }

  get EmployeeBirthday() {
    return this.employeesaveform.get('birthday');
  }

  get EmployeeMail() {
    return this.employeesaveform.get('mail');
  }

  get employeesaveFormControl() {
    return this.employeesaveform.controls;
  }

  backListView() {
    this.router.navigate(['ListEmployee']);
  }

}
