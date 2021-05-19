package com.eMotor.Driver.eMotorDriver.entity;

import java.sql.Date;
import java.util.List;

public class DrivingLicense {

	private String licenseNo;
	
	private String licenseType;
	
	private Date issueDate;
	
	private Date expireDate;
	
	private String nic;
	
	private String name;
	
	private String address;
	
	private Date dob;
	
	private String bloodGroup;
	
	private List<DrivingLicenseClass> drivingLicenseClasses;
	
//	private List<DriverPenalty> driverPenalties;
//
//	public List<DriverPenalty> getDriverPenalties() {
//		return driverPenalties;
//	}

//	public void setDriverPenalties(List<DriverPenalty> driverPenalties) {
//		this.driverPenalties = driverPenalties;
//	}

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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<DrivingLicenseClass> getDrivingLicenseClasses() {
		return drivingLicenseClasses;
	}

	public void setDrivingLicenseClasses(List<DrivingLicenseClass> drivingLicenseClasses) {
		this.drivingLicenseClasses = drivingLicenseClasses;
	}
	
	
}
