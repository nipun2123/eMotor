package com.eMotor.Police.Officer.eMotorPoliceOfficer;


import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewEndedPenaltyService;

@SpringBootTest
class ViewEndedPenaltyTests {

	@Autowired
	private ViewEndedPenaltyService viewEndedPenaltyService;
	
	
	@Test
	void findEndedPenaltiesTodayBetween() {
		
		List<DriverPenalty> response = viewEndedPenaltyService.findEndedPenaltiesByStationBetween(Date.valueOf("2021-05-01"),Date.valueOf("2021-05-31"),"975232760V");
		
		Assert.assertNotNull(response);
	}

	
	@Test
	void findEndedPenaltiesTodayTest() {
		
		List<DriverPenalty> response = viewEndedPenaltyService.findEndedPenaltiesByStationToday("975232760V");
		
		Assert.assertNotNull(response);
	}

	
	
	
	@Test
	void findEndedPenaltiesAllTest() {
		
		List<DriverPenalty> response = viewEndedPenaltyService.findEndedPenaltiesByStationAll("975232760V");
		
		Assert.assertNotNull(response);
	}
		
	
}
