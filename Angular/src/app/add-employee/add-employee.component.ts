import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
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

  employees: Observable<Employee[]>;
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
      sdt: ['', Validators.required],
      diachi: ['', Validators.required]
    });
  }

  saveEmployee(saveEmployee) {
    this.employee.id = this.maxIdEmployee + 1;
    this.employee.name = this.EmployeeName.value;
    this.employee.sdt = this.EmployeeSdt.value;
    this.employee.diachi = this.EmployeeDiachi.value;
    this.submitted = true;
    this.save();
  }

  save() {
    this.employeeservice.createEmployee(this.employee.id, this.employee).subscribe(data => console.log(data), error => console.log(error));
    this.employee = new Employee();
    this.router.navigate(['ListEmployee']);

  }

  get EmployeeName() {
    return this.employeesaveform.get('name');
  }

  get EmployeeSdt() {
    return this.employeesaveform.get('sdt');
  }

  get EmployeeDiachi() {
    return this.employeesaveform.get('diachi');
  }

  get employeesaveFormControl() {
    return this.employeesaveform.controls;
  }

  backListView() {
    this.router.navigate(['ListEmployee']);
  }

  // addEmployeeForm() {
  //   this.submitted = false;
  //   this.employeesaveform.reset();
  // }

}
