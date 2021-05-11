package com.eMotor.Police.Department.eMotorPoliceDepartment.service;


import java.util.List;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PenaltyDateSettings;


public interface PenaltyService {

	
	public Penalty saveSpot(Penalty thePenalty);
	
	public Penalty saveCourt(Penalty thePenalty);
	
	public Penalty saveWarn(Penalty thePenalty);
	
	public List<Penalty> findAll();
	
	public Penalty findById(int idPenalty);
	
	public Penalty delete(int idPenalty);
	
	
	public PenaltyDateSettings savePenaltyDateSettings(PenaltyDateSettings thePenaltyDateSettings);
	
	public PenaltyDateSettings findSettings();
}

