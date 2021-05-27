package com.eMotor.Police.Officer.eMotorPoliceOfficer;


import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewStationPenaltyService;

@SpringBootTest
class ViewStationPenaltyTests {

	@Autowired
	private ViewStationPenaltyService viewStationPenaltyService;
	
	
	@Test
	void findStationPenaltiesExpired() {
		
		List<DriverPenalty> response = viewStationPenaltyService.findPenaltiesByStationExpired("975232760V");
		
		Assert.assertNotNull(response);
	}
	
	
	@Test
	void findStationPenaltiesEnded() {
		
		List<DriverPenalty> response = viewStationPenaltyService.findPenaltiesByStationEnded("975232760V");
		
		Assert.assertNotNull(response);
	}
	
	
	@Test
	void findStationPenaltiesPending() {
		
		List<DriverPenalty> response = viewStationPenaltyService.findPenaltiesByStationPending("975232760V");
		
		Assert.assertNotNull(response);
	}
	

	@Test
	void findStationPenaltiesLoggedUser() {
		
		List<DriverPenalty> response = viewStationPenaltyService.findPenaltiesByStationMy("975232760V");
		
		Assert.assertNotNull(response);
	}
	
	
	
	@Test
	void findStationPenaltiesAll() {
		
		List<DriverPenalty> response = viewStationPenaltyService.findPenaltiesByStationAll("975232760V");
		
		Assert.assertNotNull(response);
	}

}
