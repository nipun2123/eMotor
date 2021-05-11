package com.eMotor.Police.Department.eMotorPoliceDepartment.controller;

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

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Province;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PoliceOfficerService;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PoliceStationService;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.ProvinceService;

@Controller
@RequestMapping("/department")
public class PoliceMaintainController {

	@Autowired
	private ProvinceService provinceService;
	
	@Autowired
	private PoliceStationService policeStationService;
	
	@Autowired
	private PoliceOfficerService policeOfficerService;


	
	 @RequestMapping("/police/maintain")
	 public String showPoliceMaintain(Model theModel) {
		 
	 List<Province> theProvinceService = provinceService.findAll();
		theModel.addAttribute("provinces",theProvinceService);
		
	List<PoliceStation>	thePoliceStation = policeStationService.findAll();
	theModel.addAttribute("staions",thePoliceStation);
	
	PoliceStation policeStation = new PoliceStation();
	theModel.addAttribute("policeStation",policeStation);
	
	List<PoliceOfficer>	thePoliceOfficer = policeOfficerService.findAll();
	theModel.addAttribute("officers",thePoliceOfficer);
	
	PoliceOfficer policeOfficer = new PoliceOfficer();
	theModel.addAttribute("policeOfficer",policeOfficer);
	
	 return "police_maintain";
	 }
	
	 
	
	@PostMapping("/police/savestation")
	public String saveStation(@ModelAttribute("policeStation") PoliceStation thePoliceStation){
		
		
		PoliceStation newPoliceStation =  policeStationService.save(thePoliceStation);
		
		if(newPoliceStation == null) {
			throw new RuntimeException("The police station not registred- "+ thePoliceStation.getPoliceStation());
		}
		
		return "redirect:/department/police/maintain";
		
	}
	
	@PostMapping("/police/saveofficer")
	public String saveOfficer(@ModelAttribute("policeOfficer") PoliceOfficer thePoliceOfficer){
		
		
		PoliceOfficer newPoliceOfficer =  policeOfficerService.save(thePoliceOfficer);
		
		if(newPoliceOfficer == null) {
			throw new RuntimeException("The police officer not registred- "+ thePoliceOfficer.getOfficerNo());
		}
		
		return "redirect:/department/police/maintain";
		
	}
	
	
	@GetMapping("/police/sendpassword")
	public String sendPasswordAgain(@RequestParam("nic") String nic){
		
		boolean b = policeOfficerService.sendPasswordAgain(nic);
		
		if(b) {
			return "redirect:/department/police/maintain";
		}else {
			return "redirect:/department/police/maintain"+nic;
		}
		
		
	}
	
	
	
	
	@PostMapping("/police/saveprovince")
	public Province saveProvince(@RequestBody Province theProvince){
		
		theProvince.setIdProvince(0);
		
		return provinceService.save(theProvince);
		
	}
	
}
