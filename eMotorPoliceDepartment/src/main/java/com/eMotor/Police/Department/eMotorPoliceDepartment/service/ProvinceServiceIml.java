package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.ProvinceRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Province;

@Service
public class ProvinceServiceIml implements ProvinceService {

	
	@Autowired
	private ProvinceRepository provinceRepository;

	
	@Override
	public List<Province> findAll() {
		
		return provinceRepository.findAll();
	}


	@Override
	public Province save(Province theProvince) {
		return provinceRepository.save(theProvince);
		
	}



}
