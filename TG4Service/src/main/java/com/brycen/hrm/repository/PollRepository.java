package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.entity.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {

//	@Query(value = "select new com.brycen.hrm.entity.PollResponse("
//			+ "p.pollId,p.question,p.expiration,p.status,p.employee.employee_id, p.employee.first_name, p.employee.last_name)"
//			+ "from Poll p left join p.employee e ")
//	public List<PollResponse> getListPollResponse();
//	
	

}
