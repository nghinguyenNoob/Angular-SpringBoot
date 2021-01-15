package com.brycen.hrm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.entity.OptionPoll;
import com.brycen.hrm.entity.TopVoteResponse;
import com.brycen.hrm.repository.OptionPollRepository;
import com.brycen.hrm.service.OptionPollService;

@Service
public class OptionPollServiceImpl implements OptionPollService {

	@Autowired
	private OptionPollRepository optionPollRepository;

	@Override
	public List<OptionPoll> getListOptionPoll() {
		return optionPollRepository.findAll();
	}

	@Override
	public List<TopVoteResponse> getListTopVote() {
		return optionPollRepository.getListTopVote();
	}

	@Override
	public OptionPoll saveOptionPoll(OptionPoll optionPoll) {
		return optionPollRepository.save(optionPoll);
	}

}
