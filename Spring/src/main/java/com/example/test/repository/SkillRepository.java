package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
}
