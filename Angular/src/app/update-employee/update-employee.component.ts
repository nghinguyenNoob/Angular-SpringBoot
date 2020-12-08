import { Component, OnInit } from '@angular/core';
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
    private employeeservice: EmployeeService) { }

  submitted = false;
  idemployee: any;
  employee: Employee = new Employee();
  mobNumberPattern = '^(09|03|04|05|06|07|08)+([0-9]{8})$';
  ngOnInit() {
    this.submitted = false;
    this.idemployee = window.history.state.id;
    this.employeeservice.getEmployeeById(this.idemployee).subscribe(data => {
      console.log(data);
      this.employee = data;
    });
  }

  updateEmployee(employee: Employee) {
    this.employeeservice.updateEmployee(employee.id, employee).subscribe(data => {
      console.log(data);
    });
    this.router.navigate(['ListEmployee']);
  }

  backListView() {
    this.router.navigate(['ListEmployee']);
  }


}
