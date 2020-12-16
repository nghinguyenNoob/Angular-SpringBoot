import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

import { EmployeeSkill } from '../model/employee-skill';
import { SkillService } from '../service/skill.service';

@Component({
  selector: 'app-employee-skill',
  templateUrl: './employee-skill.component.html',
  styleUrls: ['./employee-skill.component.css']
})
export class EmployeeSkillComponent implements OnInit {

  constructor(private skillService: SkillService, private formbuilder: FormBuilder) {
    this.formGroupSkill = this.formbuilder.group({
      numberOfSkill: [0],
      skills: new FormArray([])
    });
  }
  isClickButtonUpdate = false;
  listEmployeeSkills: EmployeeSkill[];
  listEmployeeSkillsNew: Array<EmployeeSkill> = [];
  formGroupSkill: FormGroup;
  lenListEmployeeSkillDB: number;
  employeeId: number;
  ngOnInit() {
    this.skillService.getEmployeeSkillList(1).subscribe(data => {
      this.listEmployeeSkills = data;
      this.lenListEmployeeSkillDB = this.listEmployeeSkills.length;
      this.employeeId = this.listEmployeeSkills[0].employeeId;
      this.formGroupSkill = this.formbuilder.group({
        numberOfSkill: [this.listEmployeeSkills.length],
        skills: new FormArray([])
      });
      this.addSkillToArr(this.listEmployeeSkills, false);
    });
    this.isClickButtonUpdate = false;
  }

  get f() {
    return this.formGroupSkill.controls;
  }
  get t() {
    return this.f.skills as FormArray;
  }
  get numberOfSkill() {
    return this.f.numberOfSkill.value;
  }

  get val() {
    return this.formGroupSkill.value;
  }

  clickButtonUpdate() {
    this.isClickButtonUpdate = true;
  }

  clickButtonAdd() {
    this.isClickButtonUpdate = true;
    // Cần làm mới data
    this.listEmployeeSkills.splice(0, this.lenListEmployeeSkillDB);
    if (this.listEmployeeSkills.length < this.numberOfSkill) {
      // Cần làm mới data
      this.listEmployeeSkillsNew.splice(0, this.listEmployeeSkillsNew.length);
      for (let i = 0; i < this.numberOfSkill - this.lenListEmployeeSkillDB; i++) {
        const skill = new EmployeeSkill();
        skill.employeeId = this.employeeId;
        skill.skillId = 1;
        skill.skillName = this.val.skills[i].skillName;
        skill.skillTypeId = 1;
        skill.skillTypeName = this.val.skills[i].skillTypeName;
        this.listEmployeeSkillsNew.push(skill);
      }
      for (let i = this.numberOfSkill - this.lenListEmployeeSkillDB; i < this.numberOfSkill; i++) {
        const skill = new EmployeeSkill();
        skill.employeeId = this.employeeId;
        skill.skillId = 1;
        skill.skillName = this.val.skills[i].skillName;
        skill.skillTypeId = 1;
        skill.skillTypeName = this.val.skills[i].skillTypeName;
        this.listEmployeeSkills.push(skill);
      }
    }
    while (this.t.length) {
      this.t.removeAt(0);
    }
    this.t.push(this.formbuilder.group({
      employeeId: [this.listEmployeeSkills[0].employeeId],
      skillId: [''],
      skillName: [''],
      skillTypeId: [''],
      skillTypeName: [''],
      isNew: true
    }));
    this.addSkillToArr(this.listEmployeeSkillsNew, true);
    this.addSkillToArr(this.listEmployeeSkills, false);
    this.f.numberOfSkill.setValue(this.numberOfSkill + 1);
  }

  clickButtonCancel() {
    this.isClickButtonUpdate = true;
    this.skillService.getEmployeeSkillList(1).subscribe(data => { // change param to employee id
      this.listEmployeeSkills = data;
      this.lenListEmployeeSkillDB = this.listEmployeeSkills.length;
      this.employeeId = this.listEmployeeSkills[0].employeeId;
      this.formGroupSkill = this.formbuilder.group({
        numberOfSkill: [this.listEmployeeSkills.length],
        skills: new FormArray([])
      });
      this.addSkillToArr(this.listEmployeeSkills, false);
    });
  }

  clickButtonSave() {
    this.isClickButtonUpdate = true;
  }

  submit() {
    this.skillService.getSkillList();
  }

  addSkillToArr(listEmployeeSkills: EmployeeSkill[], isNew: boolean) {
    for (const skill of listEmployeeSkills) {
      this.t.push(this.formbuilder.group({
        employeeId: [skill.employeeId],
        skillId: [skill.skillId],
        skillName: [skill.skillName],
        skillTypeId: [skill.skillTypeId],
        skillTypeName: [skill.skillTypeName],
        isNew: [isNew]
      }));
    }
  }
}
