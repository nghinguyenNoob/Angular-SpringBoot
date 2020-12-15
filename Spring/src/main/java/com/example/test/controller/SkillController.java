package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test.model.EmployeeSkill;
import com.example.test.model.Skill;
import com.example.test.model.SkillType;
import com.example.test.repository.EmployeeSkillRepository;
import com.example.test.repository.SkillRepository;
import com.example.test.repository.SkillTypeRespository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/skill/")
public class SkillController {

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private SkillTypeRespository skillTypeRespository;

	@Autowired
	private EmployeeSkillRepository employeeSkillRepository;

	@GetMapping("employeeskill-list/{id}")
	public ResponseEntity<List<EmployeeSkill>> getListEmployeeSkill(@PathVariable("id") int employeeId) {
		try {
			List<EmployeeSkill> listEmployeeSkill = employeeSkillRepository.findByEmployeeId(employeeId);
			return new ResponseEntity<>(listEmployeeSkill, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("skill-list")
	public ResponseEntity<List<Skill>> getListSkill() {
		try {
			List<Skill> listSkill = skillRepository.findAll();
			return new ResponseEntity<>(listSkill, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("skilltype-list")
	public ResponseEntity<List<SkillType>> getListSkillType() {
		try {
			List<SkillType> listSkillType = skillTypeRespository.findAll();
			return new ResponseEntity<>(listSkillType, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
}
