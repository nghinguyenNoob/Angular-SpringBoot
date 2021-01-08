package com.brycen.hrm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.entity.Poll;

@Repository
public interface PollPageRepository  extends PagingAndSortingRepository<Poll, Integer> {
	
}
