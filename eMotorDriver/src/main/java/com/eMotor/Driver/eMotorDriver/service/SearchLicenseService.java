package com.eMotor.Driver.eMotorDriver.service;

import java.util.Map;

import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;


public interface SearchLicenseService {

	public  Map<String, Object> searchDrivingLicense(String licenseNo, String nic);
	
	public  DriverPenalty findPenaltyByNo(String penaltyNo);
}
