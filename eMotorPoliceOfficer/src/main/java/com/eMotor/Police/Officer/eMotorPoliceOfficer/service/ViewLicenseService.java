package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.util.Map;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface ViewLicenseService {

	public  Map<String, Object> searchDrivingLicense(String licenseNo, String nic);
	
	public  DriverPenalty findPenaltyByNo(String penaltyNo);
	
}
