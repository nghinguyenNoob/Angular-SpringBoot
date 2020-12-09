package com.example.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skilltype")
public class SkillType {

	@Id
	@Column(name = "skill_type_id")
	private int skill_type_id;

	@Column(name = "skill_type_name")
	private String skillTypeName;

	@OneToMany(mappedBy = "skillTypeId", cascade = CascadeType.ALL)
	private List<Skill> skills;

	/**
	 * Constructor not parameter
	 */
	public SkillType() {
		super();
	}

	/**
	 * @param skill_type_id
	 * @param skillTypeName
	 */
	public SkillType(int skill_type_id, String skillTypeName) {
		super();
		this.skill_type_id = skill_type_id;
		this.skillTypeName = skillTypeName;
	}

	/**
	 * @return the skill_type_id
	 */
	public int getSkill_type_id() {
		return skill_type_id;
	}

	/**
	 * @param skill_type_id the skill_type_id to set
	 */
	public void setSkill_type_id(int skill_type_id) {
		this.skill_type_id = skill_type_id;
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

	/**
	 * @return the skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}
