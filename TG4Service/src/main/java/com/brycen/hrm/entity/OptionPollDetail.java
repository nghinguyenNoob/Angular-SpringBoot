package com.brycen.hrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="option_poll_detail")
public class OptionPollDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poll_detail_id")
	private int pollDetailId;

	@ManyToOne
	@JoinColumn(name = "option_id")
	private OptionPoll optionPoll;

	@Column(name = "vote_date")
	private String voteDate;

	@Column(name = "vote_by")
	private int voteBy;

	public OptionPollDetail() {
		super();
	}

	/**
	 * @param pollDetailId
	 * @param optionPoll
	 * @param voteDate
	 * @param voteBy
	 */
	public OptionPollDetail(int pollDetailId, OptionPoll optionPoll, String voteDate, int voteBy) {
		super();
		this.pollDetailId = pollDetailId;
		this.optionPoll = optionPoll;
		this.voteDate = voteDate;
		this.voteBy = voteBy;
	}

	/**
	 * @return the pollDetailId
	 */
	public int getPollDetailId() {
		return pollDetailId;
	}

	/**
	 * @param pollDetailId the pollDetailId to set
	 */
	public void setPollDetailId(int pollDetailId) {
		this.pollDetailId = pollDetailId;
	}

	/**
	 * @return the optionPoll
	 */
	public OptionPoll getOptionPoll() {
		return optionPoll;
	}

	/**
	 * @param optionPoll the optionPoll to set
	 */
	public void setOptionPoll(OptionPoll optionPoll) {
		this.optionPoll = optionPoll;
	}

	/**
	 * @return the voteDate
	 */
	public String getVoteDate() {
		return voteDate;
	}

	/**
	 * @param voteDate the voteDate to set
	 */
	public void setVoteDate(String voteDate) {
		this.voteDate = voteDate;
	}

	/**
	 * @return the voteBy
	 */
	public int getVoteBy() {
		return voteBy;
	}

	/**
	 * @param voteBy the voteBy to set
	 */
	public void setVoteBy(int voteBy) {
		this.voteBy = voteBy;
	}

}
