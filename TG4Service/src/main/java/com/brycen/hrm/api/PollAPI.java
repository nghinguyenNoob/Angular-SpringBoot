package com.brycen.hrm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.entity.OptionPoll;
import com.brycen.hrm.entity.OptionPollDetail;
import com.brycen.hrm.entity.PageResponse;
import com.brycen.hrm.entity.Poll;
import com.brycen.hrm.entity.PollResponse;
import com.brycen.hrm.entity.TopVoteResponse;
import com.brycen.hrm.repository.PollPageRepository;
import com.brycen.hrm.service.OptionPollDetailService;
import com.brycen.hrm.service.OptionPollService;
import com.brycen.hrm.service.PollService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PollAPI {

	@Autowired
	PollService pollService;
	
	@Autowired
	PollPageRepository pollPagesRepository;

	@Autowired
	OptionPollService optionPollService;

	@Autowired
	OptionPollDetailService optionPollDetailService;

	@GetMapping("poll-list")
	public ResponseEntity<List<Poll>> getListPoll() {
		try {
			return new ResponseEntity<>(pollService.getListPoll(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("pollresponse-list")
	public ResponseEntity<List<PollResponse>> getListPollResponse(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "text", defaultValue = "") String text) {
		try {
			return new ResponseEntity<>(pollService.getListPollResponse(), HttpStatus.OK);

		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("optionpoll-list")
	public ResponseEntity<List<OptionPoll>> getListOptionPoll() {
		try {
			return new ResponseEntity<>(optionPollService.getListOptionPoll(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("optionpolldetail-list")
	public ResponseEntity<List<OptionPollDetail>> getListOptionPollDetail() {
		try {
			return new ResponseEntity<>(optionPollDetailService.getListOptionPollDetail(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("topvotes-list")
	public ResponseEntity<List<TopVoteResponse>> getListTopVote() {
		try {
			return new ResponseEntity<>(optionPollService.getListTopVote(), HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("poll-delete/{id}")
	public ResponseEntity<Boolean> deletePoll(@PathVariable("id") int id) {
		try {
			pollService.deletePoll(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("pageable")
	public ResponseEntity<PageResponse> list(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "text", defaultValue = "") String text) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("pollId").ascending());
		PageResponse pageResponse;
		if (text.equals("")) {
			Page<Poll> pageResult = pollPagesRepository.findAll(pageRequest);
			pageResponse = new PageResponse(pageResult.getContent(), pageResult.getTotalElements(), pageResult.getNumber(),
					pageResult.getSize());
		} else {
			Page<Poll> pageResult = pollPagesRepository.getPollByTextSearch(text, pageRequest);
			pageResponse =  new PageResponse(pageResult.getContent(), pageResult.getTotalElements(), pageResult.getNumber(),
					pageResult.getSize());
		}
		return new ResponseEntity<>(pageResponse, HttpStatus.OK);
	}

}
