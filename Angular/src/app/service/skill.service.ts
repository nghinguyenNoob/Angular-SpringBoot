import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private baseUrl = 'http://localhost:8080/api/skill/';
  constructor(private http: HttpClient) { }

  getSkillList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'skill-list');
  }

  getSkillTypeList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'skilltype-list');
  }

  getEmployeeSkillList(employeeId: number): Observable<any> {
    console.log(`${this.baseUrl}` + `employeeskill-list/${employeeId}`);
    return this.http.get(`${this.baseUrl}` + `employeeskill-list/${employeeId}`);
  }
}
