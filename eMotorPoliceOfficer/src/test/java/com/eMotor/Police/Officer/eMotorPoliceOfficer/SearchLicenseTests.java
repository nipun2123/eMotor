package com.eMotor.Police.Officer.eMotorPoliceOfficer;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DrivingLicense;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewLicenseService;

@SpringBootTest
class SearchLicenseTests {

	@Autowired
	ViewLicenseService viewLicenseService;
	
	
	@Test
	void searchDrivingLicenseTest() {
		HashMap<String, Object> response = (HashMap<String, Object>) viewLicenseService.searchDrivingLicense("B3838805", "200011202938");
		
		DrivingLicense driver = (DrivingLicense) response.get("license");
		
		Assert.assertEquals("B3838805", driver.getLicenseNo());
	}

	@Test
	void findPenaltyByNoTest() {
		DriverPenalty response =  viewLicenseService.findPenaltyByNo("B38388051");
		
		Assert.assertNotNull(response);
	}
	
	
	
}
