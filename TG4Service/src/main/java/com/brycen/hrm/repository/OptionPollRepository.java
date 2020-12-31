package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.entity.OptionPoll;

@Repository
public interface OptionPollRepository extends JpaRepository<OptionPoll, Integer> {

}
