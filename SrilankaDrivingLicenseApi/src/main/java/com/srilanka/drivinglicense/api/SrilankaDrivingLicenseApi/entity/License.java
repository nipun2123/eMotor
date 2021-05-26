package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="license")
public class License {

	@Id
	@Column(name="idlicense", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLicense;
	
	@Column(name="licenseno", nullable = false, length=10)
	private String licenseNo;
	
	@Column(name="licensetype", nullable = false, length=10)
	private String licenseType;
	
	@Column(name="issuedate", nullable = false)
	private Date issueDate;
	
	@Column(name="expiredate")
	private Date expireDate;
	
	@Column(name="nic", nullable = false, length=12)
	private String nic;
	
	@Column(name="name", nullable = false, length=45)
	private String name;
	
	@Column(name="address", nullable = false, length=250)
	private String address;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="bloodGroup", length=2)
	private String bloodgroup;

	
	public License() {
	
	}
	
	public License(int idLicense, String licenseNo, String licenseType, Date issueDate, Date expireDate, String nic,
			String name, String address, Date dob, String bloodgroup) {
	
		this.idLicense = idLicense;
		this.licenseNo = licenseNo;
		this.licenseType = licenseType;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
		this.nic = nic;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.bloodgroup = bloodgroup;
	}

	public int getIdLicense() {
		return idLicense;
	}

	public void setIdLicense(int idLicense) {
		this.idLicense = idLicense;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	@Override
	public String toString() {
		return "License [idLicense=" + idLicense + ", licenseNo=" + licenseNo + ", type=" + licenseType + ", issueDate="
				+ issueDate + ", expireDate=" + expireDate + ", nic=" + nic + ", name=" + name + ", address=" + address
				+ ", dob=" + dob + ", bloodgroup=" + bloodgroup + "]";
	}
	
	
	
}
