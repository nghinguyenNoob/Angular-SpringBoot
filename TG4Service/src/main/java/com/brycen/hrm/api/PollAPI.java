package com.brycen.hrm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.entity.OptionPollDetail;
import com.brycen.hrm.entity.Poll;
import com.brycen.hrm.service.OptionPollService;
import com.brycen.hrm.service.PollService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PollAPI {

	@Autowired
	PollService pollService;

	@Autowired
	OptionPollService optionPollService;
	
	@Autowired
	OptionPollDetail optionPollDetailService;
	
	@GetMapping("poll-list")
	public ResponseEntity<List<Poll>> getListPoll() {
		try {
			return new ResponseEntity<>(pollService.getListPoll(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("optionpoll-list")
	public ResponseEntity<List<Poll>> getListOptionPoll() {
		try {
			return new ResponseEntity<>(pollService.getListPoll(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("optionpolldetail-list")
	public ResponseEntity<List<Poll>> getListOptionPollDetail() {
		try {
			return new ResponseEntity<>(pollService.getListPoll(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
