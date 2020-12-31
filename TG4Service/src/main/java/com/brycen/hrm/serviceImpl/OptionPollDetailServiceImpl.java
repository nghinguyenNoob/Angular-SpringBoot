package com.brycen.hrm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brycen.hrm.entity.OptionPollDetail;
import com.brycen.hrm.repository.OptionPollDetailRepository;
import com.brycen.hrm.service.OptionPollDetailService;

public class OptionPollDetailServiceImpl implements OptionPollDetailService {

	@Autowired
	private OptionPollDetailRepository optionPollDetailRepository;
	
	@Override
	public List<OptionPollDetail> getListOptionPollDetail() {
		return optionPollDetailRepository.findAll();
	}

}
