package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.DepartmentAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;


@Service
public class DepartmentAccountServiceIml implements DepartmentAccountService {

	
	@Autowired
	private DepartmentAccountRepository departmentAccountRepository;

	@Override
	public DepartmentAccount checkUsernamePassword(DepartmentAccount theDepartmentAccount) {
		
		return departmentAccountRepository.chekcUsernamePassword(theDepartmentAccount.getUsername(), theDepartmentAccount.getPassword());
	}

	



}
