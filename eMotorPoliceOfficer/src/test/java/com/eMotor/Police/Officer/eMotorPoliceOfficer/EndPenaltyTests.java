package com.eMotor.Police.Officer.eMotorPoliceOfficer;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.EndPenaltyService;

@SpringBootTest
class EndPenaltyTests {

	@Autowired
	private EndPenaltyService endPenaltyService;
	
	
	@Test
	void endCourtPenaltyTest() {
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		endPenaltyBean.setPenaltyNo("B38388055");
		endPenaltyBean.setPayFine(true);
		endPenaltyBean.setPaidAmount("100000");
		
		CompletedRecord response = endPenaltyService.endCourtPenalty(endPenaltyBean,"975232760V");
		
		Assert.assertNotNull(response);
	}

	
	@Test
	void endSpotPenaltyTest() {
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		endPenaltyBean.setPenaltyNo("B38388052");
		endPenaltyBean.setPaidAmount("5000");
		
		CompletedRecord response = endPenaltyService.endSpotPenalty(endPenaltyBean,"975232760V");
		
		Assert.assertNotNull(response);
	}
	
	@Test
	void endWarnPenaltyTest() {
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		endPenaltyBean.setPenaltyNo("B38388053");
		
		CompletedRecord response = endPenaltyService.endWarnPenalty(endPenaltyBean,"975232760V");
		
		Assert.assertNotNull(response);
	}
	
		
	
}
