package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.entity.OptionPollDetail;

@Repository
public interface OptionPollDetailRepository extends JpaRepository<OptionPollDetail, Integer>{

}
