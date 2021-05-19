package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;


import java.sql.Date;
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
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewEndedPenaltyService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewLicenseService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.ViewStationPenaltyService;


@Controller
@RequestMapping("/view/station/penalty")
public class ViewStationPenaltyController {

//	
//	@Autowired
//	EndPenaltyService endPenaltyService;
//
	@Autowired
	ViewLicenseService viewLicenseService;
//	
	@Autowired
	ViewStationPenaltyService viewStationPenaltyService;
	

	@RequestMapping("/all/en")
	public String showViewStationPenaltyAllEnglish(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationAll();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("all","checked");
		
		
		return "view_station_penalty";
	}
	
	@RequestMapping("/all/sn")
	public String showViewStationPenaltyAllSinhala(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationAll();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("all","checked");
		
		
		return "view_station_penalty";
	}
	
	@RequestMapping("/all/tm")
	public String showViewStationPenaltyAllTamil(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationAll();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("all","checked");
		
		
		return "view_station_penalty";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/pending/en")
	public String showViewStationPenaltyPendingEnglish(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationPending();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("pending","checked");
		
		
		return "view_station_penalty";
	}
	
	@RequestMapping("/pending/sn")
	public String showViewStationPenaltyPendingSinhala(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationPending();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("pending","checked");
		
		
		return "view_station_penalty";
	}
	
	@RequestMapping("/pending/tm")
	public String showViewStationPenaltyPendingTamil(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationPending();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("pending","checked");
		
		
		return "view_station_penalty";
	}
	
	
	
	
	
	
	
	

	
	
	@RequestMapping("/ended/en")
	public String showViewStationPenaltyEndedEnglish(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationEnded();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("ended","checked");
		
		
		return "view_station_penalty";
	}
	
	
	@RequestMapping("/ended/sn")
	public String showViewStationPenaltyEndedSinhala(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationEnded();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("ended","checked");
		
		
		return "view_station_penalty";
	}
	
	@RequestMapping("/ended/tm")
	public String showViewStationPenaltyEndedTamil(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationEnded();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("ended","checked");
		
		
		return "view_station_penalty";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/expired/en")
	public String showViewStationPenaltyExpiredEnglish(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationExpired();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("expired","checked");
		
		
		return "view_station_penalty";
	}
	
	
	@RequestMapping("/expired/sn")
	public String showViewStationPenaltyExpiredSinhala(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationExpired();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("expired","checked");
		
		
		return "view_station_penalty";
	}
	
	
	@RequestMapping("/expired/tm")
	public String showViewStationPenaltyExpiredTamil(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationExpired();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("expired","checked");
		
		
		return "view_station_penalty";
	}
	
	
	
	
	
	
	
	@RequestMapping("/my/en")
	public String showViewStationPenaltyMyEnglish(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationMy();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyEnglish());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("en","checked");
		theModel.addAttribute("ln","en");
		
		theModel.addAttribute("my","checked");
		
		
		return "view_station_penalty";
	}
	
	
	@RequestMapping("/my/sn")
	public String showViewStationPenaltyMySinhala(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationMy();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltySinhala());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("sn","checked");
		theModel.addAttribute("ln","sn");
		
		theModel.addAttribute("my","checked");
		
		
		return "view_station_penalty";
	}
	
	@RequestMapping("/my/tm")
	public String showViewStationPenaltyMyTamil(Model theModel) {
		
		
		List<DriverPenalty> driverPenaltyList = viewStationPenaltyService.findPenaltiesByStationMy();
		
		 for(DriverPenalty driverPenalty : driverPenaltyList) {
			 
			 driverPenalty.getPenalty().setPenaltyCommon( driverPenalty.getPenalty().getPenaltyTamil());
			 
		 }
		
		theModel.addAttribute("penalties", driverPenaltyList);
			 
		theModel.addAttribute("tm","checked");
		theModel.addAttribute("ln","tm");
		
		theModel.addAttribute("my","checked");
		
		
		return "view_station_penalty";
	}

	
	@GetMapping("/view/en")
	public String findPenaltyByNoEnglish(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyEnglish());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_station_view";
	}
	
	@GetMapping("/view/sn")
	public String findPenaltyByNoSinhala(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltySinhala());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_station_view";
	}
	
	@GetMapping("/view/tm")
	public String findPenaltyByNoTamil(@RequestParam("penaltyNo") String penaltyNo, Model theModel) {
		
		DriverPenalty theDriverPenalty =  viewLicenseService.findPenaltyByNo(penaltyNo);
		theDriverPenalty.getPenalty().setPenaltyCommon( theDriverPenalty.getPenalty().getPenaltyTamil());
		theModel.addAttribute("driverPenalty", theDriverPenalty);
		
		return "view_penalty_station_view";
	}


	
}