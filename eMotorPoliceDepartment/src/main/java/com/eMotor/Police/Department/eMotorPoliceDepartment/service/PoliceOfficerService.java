package com.eMotor.Police.Department.eMotorPoliceDepartment.service;


import java.util.List;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;



public interface PoliceOfficerService {

	
	public PoliceOfficer save(PoliceOfficer thePoliceOfficer);
	
	public List<PoliceOfficer> findAll();
	
	public boolean sendPasswordAgain(String nic);
	
}

