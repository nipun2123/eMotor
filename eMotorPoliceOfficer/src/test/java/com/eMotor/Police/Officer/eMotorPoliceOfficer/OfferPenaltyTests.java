package com.eMotor.Police.Officer.eMotorPoliceOfficer;

import java.sql.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.OfferPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.OfferPenaltyService;

@SpringBootTest
class OfferPenaltyTests {

	@Autowired
	private OfferPenaltyService offerPenaltyService;
	
	
	@Test
	void offerPenaltyTest() {
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		offerPenaltyBean.setCourt("Mahara court");
		offerPenaltyBean.setCourtDate(Date.valueOf("2021-06-27"));
		offerPenaltyBean.setPlace("Kaduwela");
		offerPenaltyBean.setVehicleNo("XS-3575");
		offerPenaltyBean.setType("Court");
		offerPenaltyBean.setLicenseNo("B3838805");
		offerPenaltyBean.setNic("200011202938");
		offerPenaltyBean.setPenaltyId(5);
		offerPenaltyBean.setUsername("975232760V");
		
		DriverPenalty response = offerPenaltyService.offerPenalty(offerPenaltyBean);
		
		Assert.assertEquals("XS-3575", response.getVehicleNo());
	}

	
	
}
