import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

import { EmployeeSkill } from '../model/employee-skill';
import { Skill } from '../model/skill';
import { SkillService } from '../service/skill.service';

@Component({
  selector: 'app-employee-skill',
  templateUrl: './employee-skill.component.html',
  styleUrls: ['./employee-skill.component.css']
})
export class EmployeeSkillComponent implements OnInit {

  constructor(private skillService: SkillService, private formbuilder: FormBuilder) {
    this.formGroupSkill = this.formbuilder.group({
      numberOfSkill: [],
      skills: new FormArray([])
    });
  }
  isClickButtonUpdate = false;
  listEmployeeSkills: EmployeeSkill[];

  formGroupSkill: FormGroup;
  numberOfSkill = 3;
  ngOnInit() {
    this.skillService.getEmployeeSkillList(1).subscribe(data => {
      console.log(data);
      this.listEmployeeSkills = data;
      console.log(this.listEmployeeSkills);
      this.formGroupSkill = this.formbuilder.group({
        numberOfSkill: [],
        skills: new FormArray([])
      });
      for (const skill of this.listEmployeeSkills) {
        this.t.push(this.formbuilder.group({
          skillName: [skill.skillName],
          skillTypeName: [skill.skillTypeName]
        }));
      }
    });
    this.isClickButtonUpdate = false;
  }

  get f() {
    return this.formGroupSkill.controls;
  }
  get t() {
    return this.f.skills as FormArray;
  }
  clickButtonUpdate() {
    this.isClickButtonUpdate = true;
  }

  clickButtonAdd() {
    this.isClickButtonUpdate = true;
    this.t.push(this.formbuilder.group({
      skillName: [''],
      skillTypeName: ['']
    }));
  }

  clickButtonSave() {
    this.isClickButtonUpdate = true;
    alert('Success:\n\n' + JSON.stringify(this.formGroupSkill.value, null, 4));
  }

  submit() {
    this.skillService.getSkillList();
  }

}
