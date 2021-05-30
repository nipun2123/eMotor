package com.eMotor.Police.Department.eMotorPoliceDepartment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.DepartmentAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;


@Service
public class DepartmentAccountServiceIml implements DepartmentAccountService {

	@Autowired
	private DepartmentAccountRepository departmentAccountRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public DepartmentAccount changePassword(DepartmentAccount departmentAccount) {
		
		DepartmentAccount loggedUseraccount = departmentAccountRepository.findByUsername(departmentAccount.getUsername());
		
		loggedUseraccount.setPassword(bCryptPasswordEncoder.encode(departmentAccount.getPassword()));
		
		return departmentAccountRepository.save(loggedUseraccount);
	}

	

	

}
