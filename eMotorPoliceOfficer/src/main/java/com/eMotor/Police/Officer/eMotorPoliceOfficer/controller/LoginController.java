package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.service.UserService;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.validation.ForgotPasswordValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ForgotPasswordValidator forgotPasswordValidator;
	
	 @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        Useraccount useraccount = new Useraccount();
	        model.addAttribute("forgotAccount",useraccount);
	        
	        return "login";
	    }
	 
	 @PostMapping("/forgot/password")
	 public String changePasswordProcess(@ModelAttribute("forgotAccount") Useraccount account, Principal principal, BindingResult bindingResult, Model theModel) {
		
		 forgotPasswordValidator.validate(account, bindingResult);

	        if (bindingResult.hasErrors()) {
	        	theModel.addAttribute("forgoterror","forgoterror");
	        	return "login";
	        }

	         userService.forgetPassword(account);
		
		        
			 return "redirect:/login"; 
		
		 
		 
	 }
	
}
