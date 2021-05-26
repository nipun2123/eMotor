package com.eMotor.Police.Department.eMotorPoliceDepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PenaltyService;


@RestController
@RequestMapping("/department")
public class PenaltyMaintainRest {

	@Autowired
	private PenaltyService penaltyService;

	 
	 @GetMapping("/penalty/maintain")
	 public Penalty findById(@RequestParam("id") String id) {
		 
	 return penaltyService.findById(Integer.parseInt(id));
	 }
	
}
