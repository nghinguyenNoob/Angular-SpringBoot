import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(
    private router: Router,
    private employeeservice: EmployeeService,
    private fb: FormBuilder) {
    this.employeeupdateform = this.fb.group({
      name: ['', Validators.required],
      phone: ['', Validators.required],
      address: ['', Validators.required],
      gender: [''],
      birthday: [''],
      mail: ['']
    });
  }

  submitted = false;
  idemployee: any;
  employeeupdateform: FormGroup;
  nrSelect: any;
  mobNumberPattern = '^(09|03|04|05|06|07|08)+([0-9]{8})$';
  ngOnInit() {
    window.onbeforeunload = function (event) {
      this.router.navigate(['ListEmployee']);
    }
    this.submitted = false;
    this.idemployee = window.history.state.id;
    this.employeeservice.getEmployeeById(this.idemployee).subscribe(data => {
      this.employeeupdateform = this.fb.group({
        name: [data.name, Validators.required],
        phone: [data.phone, Validators.required],
        address: [data.address, Validators.required],
        gender: [data.gender],
        birthday: [data.birthday],
        mail: [data.mail]
      });
      this.nrSelect = data.gender;
    });
  }

  updateEmployee(employee: Employee) {
    this.employeeservice.updateEmployee(employee.id, employee).subscribe(data => {
      console.log(data);
      this.router.navigate(['ListEmployee']);
    });
  }

  backListView() {
    this.router.navigate(['ListEmployee']);
  }

  get EmployeeName() {
    return this.employeeupdateform.get('name');
  }

  get EmployeePhone() {
    return this.employeeupdateform.get('phone');
  }

  get EmployeeAddress() {
    return this.employeeupdateform.get('address');
  }

  get EmployeeGender() {
    return this.employeeupdateform.get('gender');
  }

  get EmployeeBirthday() {
    return this.employeeupdateform.get('birthday');
  }

  get EmployeeMail() {
    return this.employeeupdateform.get('mail');
  }

  get employeeupdateFormControl() {
    return this.employeeupdateform.controls;
  }

}
