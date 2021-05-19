package com.eMotor.Driver.eMotorDriver.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eMotor.Driver.eMotorDriver.entity.Penalty;
import com.eMotor.Driver.eMotorDriver.service.PenaltyService;


@Controller
@RequestMapping("/penalty/details")
public class PenaltyController {

	@Autowired
	PenaltyService penaltyService;
	
	@RequestMapping("/en")
	public String showPenaltyDetailsEnglish(Model theModel) {
		
		List<Penalty> thePenalties = penaltyService.findAll();
		 
		 for(int i = 0; i<thePenalties.size(); i++) {
			 thePenalties.get(i).setPenaltyCommon(thePenalties.get(i).getPenaltyEnglish());
		 }
			theModel.addAttribute("penalties",thePenalties);
		
	
		
		theModel.addAttribute("en","checked");
		
		return "all_penalties";
	}
	
	@RequestMapping("/sn")
	public String showPenaltyDetailsSinhala(Model theModel) {
		
		List<Penalty> thePenalties = penaltyService.findAll();
		 
		 for(int i = 0; i<thePenalties.size(); i++) {
			 thePenalties.get(i).setPenaltyCommon(thePenalties.get(i).getPenaltySinhala());
		 }
			theModel.addAttribute("penalties",thePenalties);
		
	
		
		theModel.addAttribute("sn","checked");
		
		return "all_penalties";
	}
	
	@RequestMapping("/tm")
	public String showPenaltyDetailsTamil(Model theModel) {
		
		List<Penalty> thePenalties = penaltyService.findAll();
		 
		 for(int i = 0; i<thePenalties.size(); i++) {
			 thePenalties.get(i).setPenaltyCommon(thePenalties.get(i).getPenaltyTamil());
		 }
			theModel.addAttribute("penalties",thePenalties);
		
	
		
		theModel.addAttribute("tm","checked");
		
		return "all_penalties";
	}
}
