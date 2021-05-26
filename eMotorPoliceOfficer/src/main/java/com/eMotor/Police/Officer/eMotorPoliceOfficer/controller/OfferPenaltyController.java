package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.OfferPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Penalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.OfferPenaltyService;

@RestController
@RequestMapping("/license")
public class OfferPenaltyController {

	
	@Autowired
	private OfferPenaltyService offerPenaltyService;
	

	@PostMapping("/offer/penalty")
	public DriverPenalty offerPenalty(@RequestBody OfferPenaltyBean theOfferPenaltyBean) {
		return offerPenaltyService.offerPenalty(theOfferPenaltyBean);
	}
	
	@GetMapping("/penalty/search")
	public List<Penalty> findPenaltiesByType(@RequestParam("type")String type) {
		return offerPenaltyService.findPenaltiesByType(type);
	}
}
