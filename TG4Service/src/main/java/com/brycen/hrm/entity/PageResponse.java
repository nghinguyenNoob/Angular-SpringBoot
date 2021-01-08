package com.brycen.hrm.entity;

import java.util.List;

public class PageResponse {

	private List<Poll> polls;

	private int totalPages;

	private int pageNumbers;

	private int pageSize;

	public PageResponse() {
		super();
	}

	/**
	 * @param polls
	 * @param totalPages
	 * @param pageNumbers
	 * @param pageSize
	 */
	public PageResponse(List<Poll> polls, int totalPages, int pageNumbers, int pageSize) {
		super();
		this.polls = polls;
		this.totalPages = totalPages;
		this.pageNumbers = pageNumbers;
		this.pageSize = pageSize;
	}

	/**
	 * @return the polls
	 */
	public List<Poll> getPolls() {
		return polls;
	}

	/**
	 * @param polls the polls to set
	 */
	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the pageNumbers
	 */
	public int getPageNumbers() {
		return pageNumbers;
	}

	/**
	 * @param pageNumbers the pageNumbers to set
	 */
	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
