package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.OfferPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Penalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.OfferPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewLicenseService;


@Controller
@RequestMapping("/view/license")
public class ViewLicenseController {


	@Autowired
	ViewLicenseService viewLicenseService;
	
	@Autowired
	private OfferPenaltyService offerPenaltyService;
	
	
	@GetMapping("/search/en")
	public String findDrivingLicenseEnglish(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, @RequestParam(value = "nic", defaultValue="0")String nic, Model theModel) {
		
	
		if(licenseNo.equals("0") || nic.equals("0") ) {
			return "redirect:/view/license";
		}
		
		Map<String, Object> searchedLicense =  viewLicenseService.searchDrivingLicense(licenseNo, nic);
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) searchedLicense.get("driverPenalties");
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("searchedLicense", searchedLicense);
		
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		
		theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		return "view_licenses";
	}
	
	@GetMapping("/search/sn")
	public String findDrivingLicenseSinhala(@RequestParam(value= "licenseNo",defaultValue="0")String licenseNo, @RequestParam(value = "nic",defaultValue="0")String nic, Model theModel) {
		
		if(licenseNo.equals("0") || nic.equals("0") ) {
			return "redirect:/view/license";
		}
		
		Map<String, Object> searchedLicense =  viewLicenseService.searchDrivingLicense(licenseNo, nic);
		
		
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) searchedLicense.get("driverPenalties");
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		 theModel.addAttribute("searchedLicense", searchedLicense);
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		
		theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		return "view_licenses";
	}
	
	
	@GetMapping("/search/tm")
	public String findDrivingLicenseTamil(@RequestParam(value= "licenseNo",defaultValue="0")String licenseNo, @RequestParam(value = "nic",defaultValue="0")String nic, Model theModel) {
		
		if(licenseNo.equals("0") || nic.equals("0") ) {
			return "redirect:/view/license";
		}
		
		Map<String, Object> searchedLicense =  viewLicenseService.searchDrivingLicense(licenseNo, nic);
		
		
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) searchedLicense.get("driverPenalties");
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		 
		 theModel.addAttribute("searchedLicense", searchedLicense);
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		
		theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		return "view_licenses";
	}
	
	
	@RequestMapping
	public String showViewLicenses(Model theModel) {
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		
		theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		
		theModel.addAttribute("ln","en");
		
		return "view_licenses";
	}
	
	
	@GetMapping("/search/penalty/en")
	public String findPenaltyByNoEnglish(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyEnglish());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		
		return "view_penalty_license";
	}
	
	@GetMapping("/search/penalty/sn")
	public String findPenaltyByNoSinhala(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltySinhala());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_license";
	}
	
	@GetMapping("/search/penalty/tm")
	public String findPenaltyByNoTamil(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyTamil());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		
		return "view_penalty_license";
	}
	
	
	@GetMapping("/search/offer/penalty/en")
	public String showOfferPenaltyEnglish(@RequestParam(value= "licenseNo")String licenseNo, @RequestParam(value = "nic")String nic, Model theModel) {
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		 theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		 
		return "offer_penalty";
	}
	
	
	@GetMapping("/search/offer/penalty/sn")
	public String showOfferPenaltySinhala(@RequestParam(value= "licenseNo")String licenseNo, @RequestParam(value = "nic")String nic, Model theModel) {
		
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		 theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		 
		return "offer_penalty";
	}
	
	
	@GetMapping("/search/offer/penalty/tm")
	public String showOfferPenaltyTamil(@RequestParam(value= "licenseNo")String licenseNo, @RequestParam(value = "nic")String nic, Model theModel) {
	
		OfferPenaltyBean offerPenaltyBean = new OfferPenaltyBean();
		 theModel.addAttribute("offerPenaltyBean", offerPenaltyBean);
		 
		return "offer_penalty";
	}
	

	
	@PostMapping("/search/offer/penalty")
	public String offerPenalty(@ModelAttribute("offerPenaltyBean") OfferPenaltyBean theOfferPenaltyBean) {
		offerPenaltyService.offerPenalty(theOfferPenaltyBean);
		
		return "redirect:/view/license/search/en";
	}
	
}