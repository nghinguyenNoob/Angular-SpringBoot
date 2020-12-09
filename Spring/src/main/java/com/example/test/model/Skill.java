package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {

	@Id
	@Column(name = "skill_id")
	private int skillId;

	@Column(name = "skill_name", length = 30)
	private String skillName;

	@ManyToOne()
	@JoinColumn(name = "skill_type_id", nullable = false)
	private SkillType skillTypeId;
	
	/**
	 * Constructor not parameter
	 */
	public Skill() {
		super();
	}

	/**
	 * @param skillId
	 * @param skillName
	 * @param skillTypeId
	 */
	public Skill(int skillId, String skillName, SkillType skillTypeId) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillTypeId = skillTypeId;
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
	public SkillType getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * @param skillTypeId the skillTypeId to set
	 */
	public void setSkillTypeId(SkillType skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

}
