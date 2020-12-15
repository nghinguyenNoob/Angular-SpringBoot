import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { ResponseEmployee } from '../model/responseeployee';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor(private router: Router, private employeeservice: EmployeeService) { }

  employees: Employee[];
  pageIndexes: Array<number>;
  pageNumbers = 0;
  pageSize = 5;
  totalPages = 0;
  deleteMessage = false;
  dataIsEmpty = true;
  textSearch = '';
  ngOnInit() {
    this.getPage(this.pageNumbers, this.pageSize, this.textSearch);
  }

  getPage(pageNumber: number, pageSize: number, textSearch: string) {
    this.employeeservice.getEmployeePagination({ page: pageNumber, size: pageSize, text: textSearch })
      .subscribe((response: ResponseEmployee) => {
        this.employees = response.employees;
        if (this.employees.length !== 0) {
          this.dataIsEmpty = false;
        } else {
          if (response.totalPages !== 0) {
            this.dataIsEmpty = false;
            this.employeeservice.getEmployeePagination({page: 0, size: 5, text: ''})
              .subscribe((data: ResponseEmployee) => {
                this.employees = data.employees;
                this.totalPages = data.totalPages;
                this.pageNumbers = data.pageNumbers;
                this.pageIndexes = Array(this.totalPages).fill(0).map((x, i) => i);
              });
          } else {
            this.dataIsEmpty = true;
          }
        }
        this.totalPages = response.totalPages;
        this.pageNumbers = response.pageNumbers;
        this.pageIndexes = Array(this.totalPages).fill(0).map((x, i) => i);
      });
  }

  getPaginationWithIndex(index: number) {
    this.getPage(index, this.pageSize, this.textSearch);
  }

  getPreviousPage() {
    if (this.pageNumbers > 0) {
      this.getPage(this.pageNumbers - 1, this.pageSize, this.textSearch);
    }
  }

  getNextPage() {
    if (this.pageNumbers < this.totalPages - 1) {
      this.getPage(this.pageNumbers + 1, this.pageSize, this.textSearch);
    }
  }

  deleteEmployee(employee: Employee) {
    console.log('Delete employee' + employee);
    this.employeeservice.deleteEmployee(employee.id).subscribe(data => {
      this.deleteMessage = true;
      this.getPage(this.pageNumbers, this.pageSize, '');
    });
  }

  updateEmployee(employee: Employee) {
    this.router.navigate(['UpdateEmployee'], { state: { id: employee.id } });

  }

  searchEmployee(textSearch: any) {
    this.getPage(0, 5, textSearch);
  }

}
