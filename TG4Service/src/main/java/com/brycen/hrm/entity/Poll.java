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
@Table(name = "poll")
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poll_id")
	private int pollId;

	@Column(name = "question")
	private String question;

	@Column(name = "expiration")
	private String expiration;

	@Column(name = "allow_muptiple")
	private int allowMultiple;

	@Column(name = "create_date")
	private String createDate;

//	@Column(name = "create_by")
//	private int createBy;
	// Check create_by and update_by
	@ManyToOne
	@JoinColumn(name = "create_by")
	private Employee employee;

	@Column(name = "update_date")
	private String updateDate;

	@Column(name = "update_by")
	private int updateBy;

	@Column(name = "is_delete")
	private int isDelete;

	@Column(name = "status")
	private String status;

	/**
	 * Constructor not parameter
	 */
	public Poll() {
		super();
	}

	/**
	 * @param pollId
	 * @param question
	 * @param expiration
	 * @param allowMultiple
	 * @param createDate
	 * @param employee
	 * @param updateDate
	 * @param updateBy
	 * @param isDelete
	 * @param status
	 */
	public Poll(int pollId, String question, String expiration, int allowMultiple, String createDate, Employee employee,
			String updateDate, int updateBy, int isDelete, String status) {
		super();
		this.pollId = pollId;
		this.question = question;
		this.expiration = expiration;
		this.allowMultiple = allowMultiple;
		this.createDate = createDate;
		this.employee = employee;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.isDelete = isDelete;
		this.status = status;
	}

	/**
	 * @return the pollId
	 */
	public int getPollId() {
		return pollId;
	}

	/**
	 * @param pollId the pollId to set
	 */
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the expiration
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * @return the allowMultiple
	 */
	public int getAllowMultiple() {
		return allowMultiple;
	}

	/**
	 * @param allowMultiple the allowMultiple to set
	 */
	public void setAllowMultiple(int allowMultiple) {
		this.allowMultiple = allowMultiple;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the updateBy
	 */
	public int getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return the isDelete
	 */
	public int getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
