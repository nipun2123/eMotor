package com.eMotor.Driver.eMotorDriver.TestController;

import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.stereotype.Controller;
@Controller
public class Test {

	
	 @RequestMapping("/search")
	 public String search() {
	 return "search_license";
	 }
	 
	 @RequestMapping("/view_penalty")
	 public String viewPenalt() {
	 return "view_penalty";
	 }
	 
	 
	 @RequestMapping("/view_license")
	 public String viewLicense() {
	 return "view_license";
	 }
	 
	 @RequestMapping("/all_penalties")
	 public String penaltyMaintain() {
	 return "all_penalties";
	 }
}
