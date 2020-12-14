import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { of } from 'rxjs';

import { Skill } from '../skill';
import { SkillService } from '../skill.service';

@Component({
  selector: 'app-employee-skill',
  templateUrl: './employee-skill.component.html',
  styleUrls: ['./employee-skill.component.css']
})
export class EmployeeSkillComponent implements OnInit {

  constructor(private skillService: SkillService, private formbuilder: FormBuilder) { }
  isClickButtonUpdate = false;
  listSkills: any;
  // listSkills: Array<Skill> = [
  //   { id: 1, name: 'MySQL', typeSkill: 'Database' },
  //   { id: 2, name: 'Java', typeSkill: 'Programing Language' },
  //   { id: 3, name: 'Angular2+', typeSkill: 'Framework' }
  // ];
  formGroupSkill: FormGroup;
  numberOfSkill = 3;
  ngOnInit() {
    this.skillService.getSkillList().subscribe(data => {
      this.listSkills = data;
      this.formGroupSkill = this.formbuilder.group({
        numberOfSkill: [],
        skills: new FormArray([])
      });
      for (const skill of this.listSkills) {
        this.t.push(this.formbuilder.group({
          name: [skill.name],
          typeSkill: [skill.typeSkill]
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
      name: [''],
      typeSkill: ['']
    }));
  }

  clickButtonSave() {
    this.isClickButtonUpdate = true;
  }

  submit() {
    this.skillService.getSkillList();
  }

}
