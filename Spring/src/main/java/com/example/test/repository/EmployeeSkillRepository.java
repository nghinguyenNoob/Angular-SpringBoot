package com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.test.model.EmployeeSkill;
import com.example.test.model.EmployeeSkillId;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, EmployeeSkillId >{

	@Query("SELECT es FROM EmployeeSkill es WHERE es.employeeId = ?1")
	public List<EmployeeSkill> findByEmployeeId(int employeeId);

}
