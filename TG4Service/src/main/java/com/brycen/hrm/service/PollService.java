package com.brycen.hrm.service;

import java.util.List;

import com.brycen.hrm.entity.Poll;
import com.brycen.hrm.entity.PollResponse;

public interface PollService {

	List<Poll> getListPoll();
	
	List<PollResponse> getListPollResponse();
	
	void deletePoll(int id);
}
