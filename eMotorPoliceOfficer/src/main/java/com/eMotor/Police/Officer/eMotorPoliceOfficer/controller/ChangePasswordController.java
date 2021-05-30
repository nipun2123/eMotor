package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.UserService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.validation.ChangePasswordValidator;


@Controller
@RequestMapping("/change/password")
public class ChangePasswordController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChangePasswordValidator changePasswordValidator;
	
	
	
	 @RequestMapping()
	 public String changePassword(Model theModel) {
		 
		 Useraccount account = new Useraccount();
			theModel.addAttribute("account",account);
			
			return "change_password";
	 }
	 
	 
	 @RequestMapping("/process")
	 public String changePasswordProcess(@ModelAttribute("account") Useraccount account, Principal principal, BindingResult bindingResult, Model theModel,HttpServletRequest request, HttpServletResponse response) {
		 account.setUsername(principal.getName());
		 
		 changePasswordValidator.validate(account, bindingResult);

	        if (bindingResult.hasErrors()) {
	        	return "change_password";
	        }

		 	
	        Useraccount savedAccount = userService.changePassword(account);
		 	
		 if(savedAccount != null) {
			 
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
		        if (auth != null){      
		           new SecurityContextLogoutHandler().logout(request, response, auth);  
		        }  
		        
			 return "login"; 
		 }else {
			 return "redirect:/change/password";
		 }
		 
		 
	 }
	 
	 
	 
	 
	 }