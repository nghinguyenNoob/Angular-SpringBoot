package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class NhanVien {

	@Id
	private String maNhanVien;

	private String tenNhanVien;

	private String sdt;

	private String diachi;

	public NhanVien() {
		super();
	}

	/**
	 * @param maNhanVien
	 * @param tenNhanVien
	 * @param sdt
	 * @param diachi
	 */
	public NhanVien(String maNhanVien, String tenNhanVien, String sdt, String diachi) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.sdt = sdt;
		this.diachi = diachi;
	}

	/**
	 * @return the maNhanVien
	 */
	public String getMaNhanVien() {
		return maNhanVien;
	}

	/**
	 * @param maNhanVien the maNhanVien to set
	 */
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	/**
	 * @return the tenNhanVien
	 */
	public String getTenNhanVien() {
		return tenNhanVien;
	}

	/**
	 * @param tenNhanVien the tenNhanVien to set
	 */
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
