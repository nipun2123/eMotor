package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;


import java.security.Principal;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.EndPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewEndedPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewLicenseService;


@Controller
@RequestMapping("/view/endedpenalty")
public class ViewEndedPenaltyController {

	
	@Autowired
	EndPenaltyService endPenaltyService;

	@Autowired
	ViewLicenseService viewLicenseService;
	
	@Autowired
	ViewEndedPenaltyService viewEndedPenaltyService;
	

	@RequestMapping("/all/en")
	public String showViewEndedPenaltyAllEnglish(Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationAll(principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("all","checked");
		
		
		return "view_ended_penalty";
	}
	
	
	@RequestMapping("/all/sn")
	public String showViewEndedPenaltyAllSinhala(Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationAll(principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
		
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		
		theModel.addAttribute("all","checked");
		
		return "view_ended_penalty";
	}
	
	
	@RequestMapping("/all/tm")
	public String showViewEndedPenaltyAllTamil(Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationAll(principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
		
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		
		theModel.addAttribute("all","checked");
		
		return "view_ended_penalty";
	}
	
	
	
	
	@RequestMapping("/today/en")
	public String showViewEndedPenaltyTodayEnglish(Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationToday(principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("today","checked");
		
		return "view_ended_penalty";
	}
	
	
	@RequestMapping("/today/sn")
	public String showViewEndedPenaltyTodaySinhala(Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationToday(principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("today","checked");
		
		return "view_ended_penalty";
	}
	
	
	@RequestMapping("/today/tm")
	public String showViewEndedPenaltyTodayTamil(Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationToday(principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("today","checked");
		
		return "view_ended_penalty";
	}
	
	@RequestMapping("/between/en")
	public String showViewEndedPenaltyBetweenEnglish(@RequestParam("from")Date from,@RequestParam("to")Date to, Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationBetween(from, to,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("from", from);
		theModel.addAttribute("to", to);
		
		return "view_ended_penalty";
	}
	
	@RequestMapping("/between/sn")
	public String showViewEndedPenaltyBetweenSinhala(@RequestParam("from")Date from,@RequestParam("to")Date to, Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationBetween(from, to,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("from", from);
		theModel.addAttribute("to", to);
		
		return "view_ended_penalty";
	}
	
	@RequestMapping("/between/tm")
	public String showViewEndedPenaltyBetweenTamil(@RequestParam("from")Date from,@RequestParam("to")Date to, Model theModel, Principal principal) {
		
		
		List<DriverPenalty> driverPenaltyList = viewEndedPenaltyService.findEndedPenaltiesByStationBetween(from, to,principal.getName());
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("from", from);
		theModel.addAttribute("to", to);
	
		return "view_ended_penalty";
	}
	
	
	
	@GetMapping("/view/en")
	public String findPenaltyByNoEnglish(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyEnglish());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_end_view";
	}
	
	@GetMapping("/view/sn")
	public String findPenaltyByNoSinhala(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltySinhala());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_end_view";
	}
	
	@GetMapping("/view/tm")
	public String findPenaltyByNoTamil(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyTamil());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_end_view";
	}


	
}