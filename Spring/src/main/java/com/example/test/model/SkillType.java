package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skilltype")
public class SkillType {

	@Id
	@Column(name = "skill_type_id")
	private int skillTypeId;

	@Column(name = "skill_type_name")
	private String skillTypeName;

	/**
	 * Constructor not parameter
	 */
	public SkillType() {
		super();
	}

	/**
	 * @param skillTypeId
	 * @param skillTypeName
	 */
	public SkillType(int skillTypeId, String skillTypeName) {
		super();
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
	}

	/**
	 * @return the skillTypeId
	 */
	public int getSkill_type_id() {
		return skillTypeId;
	}

	/**
	 * @param skillTypeId the skillTypeId to set
	 */
	public void setSkill_type_id(int skillTypeId) {
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
