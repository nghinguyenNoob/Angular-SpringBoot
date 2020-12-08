package com.example.test.model;

import java.util.List;

public class ResponseEmployee {

	private List<Employee> Employees;

	private int totalPages;

	private int pageNumbers;

	private int pageSize;

	/**
	 * @param employees
	 * @param totalPages
	 * @param pageNumbers
	 * @param pageSize
	 */
	public ResponseEmployee(List<Employee> employees, int totalPages, int pageNumbers, int pageSize) {
		super();
		Employees = employees;
		this.totalPages = totalPages;
		this.pageNumbers = pageNumbers;
		this.pageSize = pageSize;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return Employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		Employees = employees;
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
