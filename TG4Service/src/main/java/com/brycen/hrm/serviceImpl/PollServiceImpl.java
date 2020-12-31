package com.brycen.hrm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.entity.Poll;
import com.brycen.hrm.repository.PollRepository;
import com.brycen.hrm.service.PollService;

@Service
public class PollServiceImpl implements PollService {

	@Autowired
	PollRepository pollRepository;

	@Override
	public List<Poll> getListPoll() {
		return pollRepository.findAll();
	}

}
