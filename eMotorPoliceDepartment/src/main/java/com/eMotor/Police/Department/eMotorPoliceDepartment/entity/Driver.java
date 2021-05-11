package com.eMotor.Police.Department.eMotorPoliceDepartment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="driver")
public class Driver implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="iddriver", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDriver;
	
	@Column(name="licenseno", nullable = false, length=10)
	private String licenseNo;
	
	@Column(name="nic", nullable = false, length=12)
	private String nic;
	
	@Column(name="status", nullable = false)
	private boolean status;

	
	public Driver() {
	
	}
	
	public Driver(int idDriver, String licenseNo, String nic, boolean status) {
		
		this.idDriver = idDriver;
		this.licenseNo = licenseNo;
		this.nic = nic;
		this.status = status;
	}

	public int getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Driver [idDriver=" + idDriver + ", licenseNo=" + licenseNo + ", nic=" + nic + ", status=" + status
				+ "]";
	}
	
	
	
	
}
