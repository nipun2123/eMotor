package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.DrivingLicense;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.service.DrivingLicenseService;


@RestController
@RequestMapping("/license")
public class DrivingLicenseController {

	@Autowired
	DrivingLicenseService drivingLicenseService;
	
	@GetMapping("/search/license")
	public DrivingLicense findDrivingLicense(@RequestParam("licenseno")String licenseNo, @RequestParam("nic")String nic) {
		
		return drivingLicenseService.findDrivingLicense(licenseNo, nic);
	}
	
	//Change database
	//Run
	//Add data
	//Test get code
}
