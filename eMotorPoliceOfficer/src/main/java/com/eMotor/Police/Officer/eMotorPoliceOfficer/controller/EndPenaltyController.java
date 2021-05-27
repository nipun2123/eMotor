package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;


import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.OfferPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.EndPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.OfferPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewLicenseService;


@Controller
@RequestMapping("/end/penalty")
public class EndPenaltyController {

	
	@Autowired
	EndPenaltyService endPenaltyService;

	@Autowired
	ViewLicenseService viewLicenseService;
	
	@GetMapping("/search/license/en")
	public String findPenaltyByLicenseEnglish(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, Model theModel, Principal principal) {
		
	
		if(licenseNo.equals("0")  ) {
			return "redirect:/end/penalty";
		}
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) endPenaltyService.findPenaltiesByLicenseNo(licenseNo,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalty", driverPenaltyList);
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		return "end_penalty";
	}

	@GetMapping("/search/license/sn")
	public String findPenaltyByLicenseSinhala(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, Model theModel, Principal principal) {
		
	
		if(licenseNo.equals("0")  ) {
			return "redirect:/end/penalty";
		}
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) endPenaltyService.findPenaltiesByLicenseNo(licenseNo,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalty", driverPenaltyList);
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);

		
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		return "end_penalty";
	}

	
	@GetMapping("/search/license/tm")
	public String findPenaltyByLicenseTamil(@RequestParam(value = "licenseNo",defaultValue="0")String licenseNo, Model theModel, Principal principal) {
		
	
		if(licenseNo.equals("0")  ) {
			return "redirect:/end/penalty";
		}
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) endPenaltyService.findPenaltiesByLicenseNo(licenseNo,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalty", driverPenaltyList);
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		return "end_penalty";
	}
	
	
	
	@GetMapping("/search/penalty/en")
	public String findPenaltyByPenaltyEnglish(@RequestParam(value = "penaltyNo",defaultValue="0")String penaltyNo, Model theModel, Principal principal) {
		
	
		if(penaltyNo.equals("0")  ) {
			return "redirect:/end/penalty";
		}
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) endPenaltyService.findPenaltyByNo(penaltyNo,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalty", driverPenaltyList);
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		return "end_penalty";
	}
	
	
	@GetMapping("/search/penalty/sn")
	public String findPenaltyByPenaltySinhala(@RequestParam(value = "penaltyNo",defaultValue="0")String penaltyNo, Model theModel, Principal principal) {
		
	
		if(penaltyNo.equals("0")  ) {
			return "redirect:/end/penalty";
		}
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) endPenaltyService.findPenaltyByNo(penaltyNo,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalty", driverPenaltyList);
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		return "end_penalty";
	}
	
	@GetMapping("/search/penalty/tm")
	public String findPenaltyByPenaltyTamil(@RequestParam(value = "penaltyNo",defaultValue="0")String penaltyNo, Model theModel, Principal principal) {
		
	
		if(penaltyNo.equals("0")  ) {
			return "redirect:/end/penalty";
		}
		
		List<DriverPenalty> driverPenaltyList = (List<DriverPenalty>) endPenaltyService.findPenaltyByNo(penaltyNo,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalty", driverPenaltyList);
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		return "end_penalty";
	}
	
	
	@RequestMapping
	public String showViewLicenses(Model theModel) {
		
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("ln","en");
		
		
		return "end_penalty";
	}
	
	
	
	@PostMapping("/warn")
	public String endWarnPenalty(@ModelAttribute("endPenaltyBean") EndPenaltyBean theEndPenaltyBean, Model theModel, Principal principal) {
		
	
	   CompletedRecord	completedRecord = endPenaltyService.endWarnPenalty(theEndPenaltyBean,principal.getName());
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("ln","en");
		
		
		return "redirect:/end/penalty";
	}
	
	@PostMapping("/spot")
	public String endSpotPenalty(@ModelAttribute("endPenaltyBean") EndPenaltyBean theEndPenaltyBean, Model theModel, Principal principal) {
		
	
	   CompletedRecord	completedRecord = endPenaltyService.endSpotPenalty(theEndPenaltyBean,principal.getName());
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("ln","en");
		
		
		return "redirect:/end/penalty";
	}
	
	@PostMapping("/court")
	public String endCourtPenalty(@ModelAttribute("endPenaltyBean") EndPenaltyBean theEndPenaltyBean, Model theModel, Principal principal) {
		
	
	   CompletedRecord	completedRecord = endPenaltyService.endCourtPenalty(theEndPenaltyBean,principal.getName());
		
		EndPenaltyBean endPenaltyBean = new EndPenaltyBean();
		
		theModel.addAttribute("endPenaltyBean", endPenaltyBean);
		
		theModel.addAttribute("ln","en");
		
		
		return "redirect:/end/penalty";
	}

	
	
	@GetMapping("/view/en")
	public String findPenaltyByNoEnglish(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyEnglish());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_end";
	}
	
	@GetMapping("/view/sn")
	public String findPenaltyByNoSinhala(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltySinhala());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_end";
	}
	
	@GetMapping("/view/tm")
	public String findPenaltyByNoTamil(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyTamil());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_end";
	}
	
}