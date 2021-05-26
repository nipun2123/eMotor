package com.eMotor.Police.Department.eMotorPoliceDepartment.service;


import java.util.List;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;

public interface PoliceStationService {

	
	public PoliceStation save(PoliceStation thePoliceStation);
	
	public List<PoliceStation> findAll();
	

}

