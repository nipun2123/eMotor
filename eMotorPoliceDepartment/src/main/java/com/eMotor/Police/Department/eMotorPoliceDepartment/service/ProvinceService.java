package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.List;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Province;



public interface ProvinceService {

	public Province save(Province theProvince);
	
	public List<Province> findAll();
	
	
}
