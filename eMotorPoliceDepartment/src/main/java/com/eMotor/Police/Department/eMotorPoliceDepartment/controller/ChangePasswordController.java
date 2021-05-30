package com.eMotor.Police.Department.eMotorPoliceDepartment.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PenaltyDateSettings;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.DepartmentAccountService;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PenaltyService;
import com.eMotor.Police.Department.eMotorPoliceDepartment.validation.CourtWarnPenaltyValidator;
import com.eMotor.Police.Department.eMotorPoliceDepartment.validation.ChangePasswordValidator;
import com.eMotor.Police.Department.eMotorPoliceDepartment.validation.SpotPenaltyValidator;


@Controller
@RequestMapping("/department")
public class ChangePasswordController {

	@Autowired
	private DepartmentAccountService departmentAccountService;
	
	@Autowired
	private ChangePasswordValidator changePasswordValidator;
	
	
	
	 @RequestMapping("/change/password")
	 public String changePassword(Model theModel) {
		 
		 DepartmentAccount departmentAccount = new DepartmentAccount();
			theModel.addAttribute("account",departmentAccount);
			
			return "change_password";
	 }
	 
	 
	 @RequestMapping("/change/password/process")
	 public String changePasswordProcess(@ModelAttribute("account") DepartmentAccount departmentAccount, Principal principal, BindingResult bindingResult, Model theModel,HttpServletRequest request, HttpServletResponse response) {
		 departmentAccount.setUsername(principal.getName());
		 
		 changePasswordValidator.validate(departmentAccount, bindingResult);

	        if (bindingResult.hasErrors()) {
	        	return "change_password";
	        }
	        
		 
		 	
		 DepartmentAccount savedDepartmentAccount = departmentAccountService.changePassword(departmentAccount);
		 	
		 if(savedDepartmentAccount != null) {
			 
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
		        if (auth != null){      
		           new SecurityContextLogoutHandler().logout(request, response, auth);  
		        }  
		        
			 return "login"; 
		 }else {
			 return "redirect:/department/change/password";
		 }
		 
		 
	 }
	 
	 
	 
	 
	 }