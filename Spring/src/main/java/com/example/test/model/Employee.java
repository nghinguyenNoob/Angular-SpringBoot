package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "idemployee")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "sdt")
	private String sdt;

	@Column(name = "diachi")
	private String diachi;

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param sdt
	 * @param diachi
	 */
	public Employee(Employee em) {
		super();
		this.id = em.getId();
		this.name = em.getName();
		this.sdt = em.getSdt();
		this.diachi = em.getDiachi();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}

	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}

	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

}
