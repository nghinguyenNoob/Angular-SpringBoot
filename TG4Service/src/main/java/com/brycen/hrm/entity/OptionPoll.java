package com.brycen.hrm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OptionPoll {

	@Id
	private int option_id;

	private int poll_id;

	private String option_name;

	private String create_date;

	private int create_by;

	private String update_date;

	private int update_by;

	private int is_delete;

	public OptionPoll() {
		super();
	}

	/**
	 * @param option_id
	 * @param poll_id
	 * @param option_name
	 * @param create_date
	 * @param create_by
	 * @param update_date
	 * @param update_by
	 * @param is_delete
	 */
	public OptionPoll(int option_id, int poll_id, String option_name, String create_date, int create_by,
			String update_date, int update_by, int is_delete) {
		super();
		this.option_id = option_id;
		this.poll_id = poll_id;
		this.option_name = option_name;
		this.create_date = create_date;
		this.create_by = create_by;
		this.update_date = update_date;
		this.update_by = update_by;
		this.is_delete = is_delete;
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
	 * @return the option_name
	 */
	public String getOption_name() {
		return option_name;
	}

	/**
	 * @param option_name the option_name to set
	 */
	public void setOption_name(String option_name) {
		this.option_name = option_name;
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

}
