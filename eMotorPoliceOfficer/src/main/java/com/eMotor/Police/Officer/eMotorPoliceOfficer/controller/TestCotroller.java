package com.eMotor.Police.Officer.eMotorPoliceOfficer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestCotroller {

	@RequestMapping("/hello")
	public String hello() {
		return "view_licenses";
	}
}
