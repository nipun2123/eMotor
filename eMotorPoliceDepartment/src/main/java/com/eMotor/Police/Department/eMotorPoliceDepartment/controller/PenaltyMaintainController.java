package com.eMotor.Police.Department.eMotorPoliceDepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PenaltyDateSettings;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PenaltyService;


@Controller
@RequestMapping("/department")
public class PenaltyMaintainController {

	@Autowired
	private PenaltyService penaltyService;
	
	
	
	 @RequestMapping("/penalty/maintain/en")
	 public String showPenaltyMaintainEnglish(Model theModel) {
		 
	 List<Penalty> thePenalties = penaltyService.findAll();
	 
	 for(int i = 0; i<thePenalties.size(); i++) {
		 thePenalties.get(i).setPenaltyCommon(thePenalties.get(i).getPenaltyEnglish());
	 }
		theModel.addAttribute("penalties",thePenalties);
	
	Penalty thePenalty = new Penalty();
	theModel.addAttribute("penalty",thePenalty);
	
	PenaltyDateSettings savedPenaltySettings = penaltyService.findSettings();
	theModel.addAttribute("savedPenaltySettings",savedPenaltySettings);
	
	PenaltyDateSettings thePenaltyDateSettingsRepository = new PenaltyDateSettings();
	theModel.addAttribute("penaltySettings",thePenaltyDateSettingsRepository);
	
	theModel.addAttribute("en","checked");
	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+savedPenaltySettings);
	 return "penalty_maintain";
	 }
	 
	 
	 
	 @RequestMapping("/penalty/maintain/sn")
	 public String showPenaltyMaintainSinhala(Model theModel) {
		 
	 List<Penalty> thePenalties = penaltyService.findAll();
	 
	 for(int i = 0; i<thePenalties.size(); i++) {
		 thePenalties.get(i).setPenaltyCommon(thePenalties.get(i).getPenaltySinhala());
	 }
	 
		theModel.addAttribute("penalties",thePenalties);
	
	Penalty thePenalty = new Penalty();
	theModel.addAttribute("penalty",thePenalty);
	
	PenaltyDateSettings savedPenaltySettings = penaltyService.findSettings();
	theModel.addAttribute("savedPenaltySettings",savedPenaltySettings);
	
	PenaltyDateSettings thePenaltyDateSettingsRepository = new PenaltyDateSettings();
	theModel.addAttribute("penaltySettings",thePenaltyDateSettingsRepository);
	
	
	theModel.addAttribute("sn","checked");
	
	 return "penalty_maintain";
	 }
	 
	 
	 @RequestMapping("/penalty/maintain/tm")
	 public String showPenaltyMaintainTamil(Model theModel) {
		 
	 List<Penalty> thePenalties = penaltyService.findAll();
	 
	 for(int i = 0; i<thePenalties.size(); i++) {
		 thePenalties.get(i).setPenaltyCommon(thePenalties.get(i).getPenaltyTamil());
	 }
	 
		theModel.addAttribute("penalties",thePenalties);
	
	Penalty thePenalty = new Penalty();
	theModel.addAttribute("penalty",thePenalty);
	
	PenaltyDateSettings savedPenaltySettings = penaltyService.findSettings();
	theModel.addAttribute("savedPenaltySettings",savedPenaltySettings);
	
	PenaltyDateSettings thePenaltyDateSettingsRepository = new PenaltyDateSettings();
	theModel.addAttribute("penaltySettings",thePenaltyDateSettingsRepository);
	
	theModel.addAttribute("tm","checked");
	
	 return "penalty_maintain";
	 }
	 
	 
	 
	 
	 
	 
	 
	 @PostMapping("/penalty/spot/save")
		public String saveSpotPenalty(@ModelAttribute("penalty") Penalty thePenalty){
			
			
			Penalty newPenalty =  penaltyService.saveSpot(thePenalty);
			
			if(newPenalty == null) {
				throw new RuntimeException("The penalty not registred- "+ thePenalty.getPenaltyEnglish());
			}
			
			return "redirect:/department/penalty/maintain/en";
			
		}
	 
	 
	 @PostMapping("/penalty/court/save")
		public String saveCourtPenalty(@ModelAttribute("penalty") Penalty thePenalty){
			
			
			Penalty newPenalty =  penaltyService.saveCourt(thePenalty);
			
			if(newPenalty == null) {
				throw new RuntimeException("The penalty not registred- "+ thePenalty.getPenaltyEnglish());
			}
			
			return "redirect:/department/penalty/maintain/en";
			
		}
	 
	 
	 @PostMapping("/penalty/warn/save")
		public String saveWarnPenalty(@ModelAttribute("penalty") Penalty thePenalty){
			
			
			Penalty newPenalty =  penaltyService.saveWarn(thePenalty);
			
			if(newPenalty == null) {
				throw new RuntimeException("The penalty not registred- "+ thePenalty.getPenaltyEnglish());
			}
			
			return "redirect:/department/penalty/maintain/en";
			
		}
	 
	 
	 
	 
	 
	 
	 @GetMapping("/penalty/delete")
	 public String penaltyDelete(@RequestParam("idPenalty") String idPenalty) {
		 
	 Penalty thePenalty =  penaltyService.delete(Integer.parseInt(idPenalty));
	 
	 if(thePenalty == null) {
			throw new RuntimeException("The penalty not deleted- "+ idPenalty);
		}
		 
			 return "redirect:/department/penalty/maintain/en";
			 

	 }
	 
	 @PostMapping("/penalty/settings/save")
		public String savePenaltySettings(@ModelAttribute("penaltySettings") PenaltyDateSettings thePenaltyDateSettings){
			
			
			PenaltyDateSettings newPenaltyDateSettings =  penaltyService.savePenaltyDateSettings(thePenaltyDateSettings);
			
			if(newPenaltyDateSettings == null) {
				throw new RuntimeException("The penalty settigs not registred");
			}
			
			return "redirect:/department/penalty/maintain/en";
			
		}
	 
	 
	 
	 }