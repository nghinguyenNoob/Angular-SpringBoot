import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }

  createEmployee(id: number, employee: any): Observable<any> {
    return this.http.post(`${this.baseUrl}` + `save-employee/${id}`, employee);
  }

  getEmployeeList(): Observable<any> { // not use
    return this.http.get(`${this.baseUrl}` + 'employee-list');
  }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `get-employeebyid/${id}`);
  }

  getMaxIdEmployee(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'max-idemployee');
  }

  getEmployeeBySearch(searchText: string): Observable<any> {// not use
    return this.http.get(`${this.baseUrl}` + `get-employeebysearch/${searchText}`);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `delete-employee/${id}`);
  }

  updateEmployee(id: number, employee: any): Observable<any> {
    return this.http.post(`${this.baseUrl}` + `update-employee/${id}`, employee);
  }

  getEmployeePagination(request): Observable<any> {
    const params = request;
    return this.http.get(`${this.baseUrl}` + 'pageable', { params });

  }

}
