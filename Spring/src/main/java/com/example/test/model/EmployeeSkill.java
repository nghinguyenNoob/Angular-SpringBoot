package com.example.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skill")
@IdClass(EmployeeSkillId.class)
public class EmployeeSkill implements Serializable {

	/**
	 * id
	 */
	private static final long serialVersionUID = 3311627467311120822L;

	@Id
	@Column(name = "employee_id")
	private int employeeId;

	@Id
	@Column(name = "skill_id")
	private int skillId;

	@Column(name = "skill_name")
	private String skillName;

	@Column(name = "skill_type_id")
	private int skillTypeId;

	@Column(name = "skill_type_name")
	private String skillTypeName;

	/**
	 * 
	 */
	public EmployeeSkill() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeId
	 * @param skillId
	 * @param skillName
	 * @param skillTypeId
	 * @param skillTypeName
	 */
	public EmployeeSkill(int employeeId, int skillId, String skillName, int skillTypeId, String skillTypeName) {
		super();
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the skillId
	 */
	public int getSkillId() {
		return skillId;
	}

	/**
	 * @param skillId the skillId to set
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/**
	 * @return the skillTypeId
	 */
	public int getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * @param skillTypeId the skillTypeId to set
	 */
	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	/**
	 * @return the skillTypeName
	 */
	public String getSkillTypeName() {
		return skillTypeName;
	}

	/**
	 * @param skillTypeName the skillTypeName to set
	 */
	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

}
