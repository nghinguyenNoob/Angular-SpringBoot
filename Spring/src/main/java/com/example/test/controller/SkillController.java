package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test.model.Skill;
import com.example.test.model.SkillType;
import com.example.test.repository.SkillRepository;
import com.example.test.repository.SkillTypeRespository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/skill/")
public class SkillController {

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private SkillTypeRespository skillTypeRepository;

	@GetMapping("skilltype-list")
	public ResponseEntity<List<SkillType>> getListSkillType() {
		List<SkillType> listSkill = skillTypeRepository.findAll();
		return new ResponseEntity<>(listSkill, HttpStatus.OK);
	}

	@GetMapping("skill-list")
	public ResponseEntity<List<Skill>> getListSkill() {
		List<Skill> listSkill = skillRepository.getAllSkill();
		return new ResponseEntity<>(listSkill, HttpStatus.OK);
	}
}
