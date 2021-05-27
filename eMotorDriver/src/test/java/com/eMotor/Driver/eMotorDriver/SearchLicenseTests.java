package com.eMotor.Driver.eMotorDriver;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;
import com.eMotor.Driver.eMotorDriver.entity.DrivingLicense;
import com.eMotor.Driver.eMotorDriver.service.SearchLicenseService;

@SpringBootTest
class SearchLicenseTests {

	@Autowired
	SearchLicenseService searchLicenseService;
	
	
	@Test
	void searchDrivingLicenseTest() {
		HashMap<String, Object> response = (HashMap<String, Object>) searchLicenseService.searchDrivingLicense("B3838805", "200011202938");
		
		DrivingLicense driver = (DrivingLicense) response.get("license");
		
		Assert.assertEquals("B3838805", driver.getLicenseNo());
	}
	
	@Test
	void findPenaltyByNoTest() {
		DriverPenalty response =  searchLicenseService.findPenaltyByNo("B38388053");
		
		Assert.assertNotNull(response);
	}

	
}
