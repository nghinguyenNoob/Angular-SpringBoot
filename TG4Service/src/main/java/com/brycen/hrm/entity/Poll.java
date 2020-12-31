package com.brycen.hrm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Poll {

	@Id
	private int poll_id;

	private String question;

	private String expiration;

	private int allow_muptiple;

	private String create_date;

	private int create_by;

	private String update_date;

	private int update_by;

	private int is_delete;
	
	private String status;
	

	/**
	 * Constructor not parameter
	 */
	public Poll() {
		super();
	}


	/**
	 * @param poll_id
	 * @param question
	 * @param expiration
	 * @param allow_muptiple
	 * @param create_date
	 * @param create_by
	 * @param update_date
	 * @param update_by
	 * @param is_delete
	 * @param status
	 */
	public Poll(int poll_id, String question, String expiration, int allow_muptiple, String create_date, int create_by,
			String update_date, int update_by, int is_delete, String status) {
		super();
		this.poll_id = poll_id;
		this.question = question;
		this.expiration = expiration;
		this.allow_muptiple = allow_muptiple;
		this.create_date = create_date;
		this.create_by = create_by;
		this.update_date = update_date;
		this.update_by = update_by;
		this.is_delete = is_delete;
		this.status = status;
	}


	/**
	 * @return the poll_id
	 */
	public int getPoll_id() {
		return poll_id;
	}


	/**
	 * @param poll_id the poll_id to set
	 */
	public void setPoll_id(int poll_id) {
		this.poll_id = poll_id;
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
	 * @return the allow_muptiple
	 */
	public int getAllow_muptiple() {
		return allow_muptiple;
	}


	/**
	 * @param allow_muptiple the allow_muptiple to set
	 */
	public void setAllow_muptiple(int allow_muptiple) {
		this.allow_muptiple = allow_muptiple;
	}


	/**
	 * @return the create_date
	 */
	public String getCreate_date() {
		return create_date;
	}


	/**
	 * @param create_date the create_date to set
	 */
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}


	/**
	 * @return the create_by
	 */
	public int getCreate_by() {
		return create_by;
	}


	/**
	 * @param create_by the create_by to set
	 */
	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}


	/**
	 * @return the update_date
	 */
	public String getUpdate_date() {
		return update_date;
	}


	/**
	 * @param update_date the update_date to set
	 */
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}


	/**
	 * @return the update_by
	 */
	public int getUpdate_by() {
		return update_by;
	}


	/**
	 * @param update_by the update_by to set
	 */
	public void setUpdate_by(int update_by) {
		this.update_by = update_by;
	}


	/**
	 * @return the is_delete
	 */
	public int getIs_delete() {
		return is_delete;
	}


	/**
	 * @param is_delete the is_delete to set
	 */
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
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
