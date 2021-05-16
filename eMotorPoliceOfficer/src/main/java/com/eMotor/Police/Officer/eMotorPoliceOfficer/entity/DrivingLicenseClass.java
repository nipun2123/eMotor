package com.eMotor.Police.Officer.eMotorPoliceOfficer.entity;

import java.sql.Date;

public class DrivingLicenseClass {

	private String vehicleClass;
	
	private Date classValidFrom;
	
	private Date classValidTo;

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public Date getClassValidFrom() {
		return classValidFrom;
	}

	public void setClassValidFrom(Date classValidFrom) {
		this.classValidFrom = classValidFrom;
	}

	public Date getClassValidTo() {
		return classValidTo;
	}

	public void setClassValidTo(Date classValidTo) {
		this.classValidTo = classValidTo;
	}
}
