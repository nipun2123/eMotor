package com.eMotor.Police.Department.eMotorPoliceDepartment;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PoliceOfficerService;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PoliceStationService;

@SpringBootTest
class PoliceMaintainTests {
	
	
	@Autowired
	PoliceStationService policeStationService;
	
	@Autowired
	PoliceOfficerService policeOfficerService;
	
	@Test
	public void addPoliceStationTest() {
		PoliceStation policeStationCommon = new PoliceStation();
		policeStationCommon.setGeneral("0112119118");
		policeStationCommon.setOic("Mahasen Bandara");
		policeStationCommon.setOicMobile("0778881665");
		policeStationCommon.setOicOffice("0115454555");
		policeStationCommon.setPoliceStation("Piliyandala police station");
		policeStationCommon.setProvinceName("Western");
		policeStationCommon.setOldPoliceStation("");
		
		PoliceStation response = policeStationService.save(policeStationCommon);
		Assert.assertEquals("Piliyandala police station", response.getPoliceStation());
	}
	
	
	@Test
	public void updatePoliceStationTest() {
		PoliceStation policeStationCommon = new PoliceStation();
		policeStationCommon.setGeneral("0112119118");
		policeStationCommon.setOic("Prabath Wanigasekara");
		policeStationCommon.setOicMobile("0778881665");
		policeStationCommon.setOicOffice("0115454555");
		policeStationCommon.setPoliceStation("Piliyandala police station");
		policeStationCommon.setProvinceName("Western");
		policeStationCommon.setOldPoliceStation("Piliyandala police station");
		
		PoliceStation response = policeStationService.save(policeStationCommon);
		Assert.assertEquals("Prabath Wanigasekara", response.getOic());
	}
	
	
	
	@Test
	public void addPoliceOfferTest() {
		PoliceOfficer policeOfficer = new PoliceOfficer();
		policeOfficer.setNic("872168745V");
		policeOfficer.setOfficerNo("59062");
		policeOfficer.setfName("Upul");
		policeOfficer.setlName("Ranawira");
		policeOfficer.setTel("0715869855");
		policeOfficer.setPoliceStationName("Piliyandala police station");
		policeOfficer.setAvailabilityTxt("Active");
		policeOfficer.setOldPoliceOfficerNic("");
		
		PoliceOfficer response = policeOfficerService.save(policeOfficer);
		Assert.assertEquals("59062", response.getOfficerNo());
	}
	
	
	@Test
	public void updatePoliceOfferTest() {
		PoliceOfficer policeOfficer = new PoliceOfficer();
		policeOfficer.setNic("872168745V");
		policeOfficer.setOfficerNo("59073");
		policeOfficer.setfName("Upul");
		policeOfficer.setlName("Ranawira");
		policeOfficer.setTel("0715869855");
		policeOfficer.setPoliceStationName("Piliyandala police station");
		policeOfficer.setAvailabilityTxt("Active");
		policeOfficer.setOldPoliceOfficerNic("872168745V");
		policeOfficer.setOldPoliceOfficerNo("59062");
		
		PoliceOfficer response = policeOfficerService.save(policeOfficer);
		Assert.assertEquals("59073", response.getOfficerNo());
	}
	
	
	

}
