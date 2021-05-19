package com.eMotor.Driver.eMotorDriver.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;
import com.eMotor.Driver.eMotorDriver.service.SearchLicenseService;


@Controller
@RequestMapping("/search/license")
public class SearchLicenseController {

	@Autowired
	SearchLicenseService searchLicenseService;
	
	@RequestMapping
	public String showViewLicenses() {
		
		return "search_license";
	}
	
	@GetMapping("/en")
	public String findDrivingLicenseEnglish(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, @RequestParam(value = "nic", defaultValue="0")String nic, Model theModel) {
		
	
		if(licenseNo.equals("0") || nic.equals("0") ) {
			return "redirect:/search/license";
		}
		
		Map<String, Object> searchedLicense =  searchLicenseService.searchDrivingLicense(licenseNo, nic);
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) searchedLicense.get("driverPenalties");
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("searchedLicense", searchedLicense);
		
		
		
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		return "view_licenses";
	}
	
	
	@GetMapping("/sn")
	public String findDrivingLicenseSinhala(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, @RequestParam(value = "nic", defaultValue="0")String nic, Model theModel) {
		
	
		if(licenseNo.equals("0") || nic.equals("0") ) {
			return "redirect:/search/license";
		}
		
		Map<String, Object> searchedLicense =  searchLicenseService.searchDrivingLicense(licenseNo, nic);
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) searchedLicense.get("driverPenalties");
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("searchedLicense", searchedLicense);
		
		
		
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		return "view_licenses";
	}
	
	@GetMapping("/tm")
	public String findDrivingLicenseTamil(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, @RequestParam(value = "nic", defaultValue="0")String nic, Model theModel) {
		
	
		if(licenseNo.equals("0") || nic.equals("0") ) {
			return "redirect:/search/license";
		}
		
		Map<String, Object> searchedLicense =  searchLicenseService.searchDrivingLicense(licenseNo, nic);
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) searchedLicense.get("driverPenalties");
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("searchedLicense", searchedLicense);
		
		
		
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		return "view_licenses";
	}
	
	@GetMapping("/penalty/en")
	public String findPenaltyByNoEnglish(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  searchLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyEnglish());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		
		return "view_penalty";
	}
	
	@GetMapping("/penalty/sn")
	public String findPenaltyByNoSinhala(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  searchLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltySinhala());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		
		return "view_penalty";
	}
	
	@GetMapping("/penalty/tm")
	public String findPenaltyByNoTamil(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  searchLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyTamil());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		
		return "view_penalty";
	}
	
	
}
