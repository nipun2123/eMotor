package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.EndPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewLicenseService;


@RestController
@RequestMapping("/penalty")
public class PenaltyRestController {

	
	@Autowired
	EndPenaltyService endPenaltyService;

	@Autowired
	ViewLicenseService viewLicenseService;
	
	@GetMapping("/find")
	public DriverPenalty findPenaltyByNo(@RequestParam("penaltyNo") String penaltyNo) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		
		return theDriverPenalty;
	}
	
	
	
}