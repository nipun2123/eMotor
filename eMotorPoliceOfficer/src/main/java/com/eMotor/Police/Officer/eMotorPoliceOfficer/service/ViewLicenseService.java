package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.util.Map;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.PoliceOfficer;

public interface ViewLicenseService {

	public  Map<String, Object> searchDrivingLicense(String licenseNo, String nic);
	
	public  DriverPenalty findPenaltyByNo(String penaltyNo);
	
	public PoliceOfficer findByUsername(String username);
	
}
