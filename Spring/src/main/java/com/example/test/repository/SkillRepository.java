package com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.test.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	@Query("SELECT e FROM Skill e LEFT JOIN e.skillTypeId f on e.skillTypeId = f.skill_type_id")
	public List<Skill> getAllSkill();
}
