package com.eMotor.Police.Department.eMotorPoliceDepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.DepartmentAccountService;

@Controller
@RequestMapping("/department")
public class LoginController {

	@Autowired
	private DepartmentAccountService departmentAccountService;
	
	 @RequestMapping("/login")
	public String showLogin(Model theModel) {
		
		 DepartmentAccount theDepartmentAccount = new DepartmentAccount();
		 theModel.addAttribute("departmentAccount", theDepartmentAccount);
		 
		 return "login";
	}
	 
	 @PostMapping("/login/check")
		public String checkLogin(@ModelAttribute("departmentAccount") DepartmentAccount theDepartmentAccount){
		 
		 DepartmentAccount checkDepartmentAccount = departmentAccountService.checkUsernamePassword(theDepartmentAccount);
		 
		 if(checkDepartmentAccount == null) {
			 
			 return "redirect:/department/login";
		 }else {
			 
		 return "redirect:/department/police/maintain";
		 
		 }
		 
		
	 }
}
