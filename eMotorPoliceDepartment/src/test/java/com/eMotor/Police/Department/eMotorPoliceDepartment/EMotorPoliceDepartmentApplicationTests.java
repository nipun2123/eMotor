package com.eMotor.Police.Department.eMotorPoliceDepartment;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Police.Department.eMotorPoliceDepartment.controller.PoliceMaintainController;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PenaltyRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceOfficerRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceStationRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.ProvinceRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PoliceOfficerServiceIml;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PoliceStationServiceIml;

@SpringBootTest
class EMotorPoliceDepartmentApplicationTests {
	
	@Autowired
	PoliceStationRepository policeStationRepository;
	
	@Autowired
	PoliceOfficerRepository policeOfficerRepository;
	
	@Autowired
	PenaltyRepository penaltyRepository;
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	@Autowired
	PoliceStationServiceIml policeStationService;
	
	@Autowired
	PoliceMaintainController controller;

	@Test
	void contextLoads() {
		
	}
	
//	@Test
//	public void addPoliceStation() {
//		PoliceStation policeStationCommon = new PoliceStation();
//		policeStationCommon.setGeneral("0112119118");
//		policeStationCommon.setOic("Mahasen Bandara");
//		policeStationCommon.setOicMobile("0778881665");
//		policeStationCommon.setOicOffice("0115454555");
//		policeStationCommon.setPoliceStation("Police Station-Kahathuduwa");
//		policeStationCommon.setProvinceName("Western");
//		policeStationCommon.setOldPoliceStation("");
//		
//		PoliceStation response = policeStationService.save(policeStationCommon);
//		Assert.assertEquals("Police Station-Kahathuduwa", response.getPoliceStation());
//	}
	
	@Autowired
	PoliceOfficerServiceIml officerService;
	
	@Test
	public void savePoliceOfficer() {
		PoliceOfficer officer = new PoliceOfficer();
		officer.setfName("Dayan");
		officer.setlName("Herath");
		officer.setOfficerNo("AV114");
		officer.setNic("760512454V");
		officer.setTel("0778889945");
		officer.setPoliceStationName("Biyagama");
		officer.setAvailabilityTxt("active");
		officer.setOldPoliceOfficerNic("");
		
		PoliceOfficer response = officerService.save(officer);
		Assert.assertEquals("760512454V", response.getOfficerNo());
	}

}
