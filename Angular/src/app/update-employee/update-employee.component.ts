import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
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
    private activaterouter: ActivatedRoute,
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

  employeeupdateform: FormGroup;
  employee: Employee = new Employee();
  submitted = false;
  idemployee: any;
  nrSelect: any;
  sub: any;
  mobNumberPattern = '^(09|03|04|05|06|07|08)+([0-9]{8})$';
  ngOnInit() {
    this.submitted = false;
    //this.idemployee = window.history.state.id;
    this.sub = this.activaterouter.paramMap.subscribe(params => {
      this.idemployee = params.get('id');
    });
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

  updateEmployee(updateEmployee) {
    this.employee.id = this.idemployee;
    this.employee.name = this.EmployeeName.value;
    this.employee.gender = this.EmployeeGender.value;
    this.employee.phone = this.EmployeePhone.value;
    this.employee.address = this.EmployeeAddress.value;
    this.employee.mail = this.EmployeeMail.value;
    this.employee.birthday = this.EmployeeBirthday.value;
    this.submitted = true;
    this.update();
  }

  update() {
    this.employeeservice.updateEmployee(this.employee.id, this.employee).subscribe(data => {
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
