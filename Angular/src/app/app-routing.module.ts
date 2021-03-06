import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeSkillComponent } from './employee-skill/employee-skill.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  { path: 'ListEmployee', component: EmployeeListComponent },
  { path: 'AddEmployee', component: AddEmployeeComponent },
  { path: 'UpdateEmployee/:id', component: UpdateEmployeeComponent },
  { path: 'SkillEmployee', component: EmployeeSkillComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
