package com.brycen.hrm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OptionPollDetail {

	@Id
	private int poll_detail_id;
	
	private int option_id;
	
	private String vote_date;
	
	private int vote_by;

	public OptionPollDetail() {
		super();
	}

	/**
	 * @param poll_detail_id
	 * @param option_id
	 * @param vote_date
	 * @param vote_by
	 */
	public OptionPollDetail(int poll_detail_id, int option_id, String vote_date, int vote_by) {
		super();
		this.poll_detail_id = poll_detail_id;
		this.option_id = option_id;
		this.vote_date = vote_date;
		this.vote_by = vote_by;
	}

	/**
	 * @return the poll_detail_id
	 */
	public int getPoll_detail_id() {
		return poll_detail_id;
	}

	/**
	 * @param poll_detail_id the poll_detail_id to set
	 */
	public void setPoll_detail_id(int poll_detail_id) {
		this.poll_detail_id = poll_detail_id;
	}

	/**
	 * @return the option_id
	 */
	public int getOption_id() {
		return option_id;
	}

	/**
	 * @param option_id the option_id to set
	 */
	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}

	/**
	 * @return the vote_date
	 */
	public String getVote_date() {
		return vote_date;
	}

	/**
	 * @param vote_date the vote_date to set
	 */
	public void setVote_date(String vote_date) {
		this.vote_date = vote_date;
	}

	/**
	 * @return the vote_by
	 */
	public int getVote_by() {
		return vote_by;
	}

	/**
	 * @param vote_by the vote_by to set
	 */
	public void setVote_by(int vote_by) {
		this.vote_by = vote_by;
	}
	
}
