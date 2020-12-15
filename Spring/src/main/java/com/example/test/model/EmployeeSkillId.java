package com.example.test.model;

import java.io.Serializable;

public class EmployeeSkillId implements Serializable {

	/**
	 * Id
	 */
	private static final long serialVersionUID = 1494602664415286980L;

	private int employeeId;

	private int skillId;

	/**
	 * 
	 */
	public EmployeeSkillId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeId
	 * @param skillId
	 */
	public EmployeeSkillId(int employeeId, int skillId) {
		super();
		this.employeeId = employeeId;
		this.skillId = skillId;
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

}
