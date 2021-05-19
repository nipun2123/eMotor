package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;


import java.util.List;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface EndPenaltyService {

	public  List<DriverPenalty> findPenaltiesByLicenseNo(String licenseNo);
	
	public  List<DriverPenalty> findPenaltyByNo(String penaltyNo);
	
	public  CompletedRecord endWarnPenalty(EndPenaltyBean endPenaltyBean);
	
	public  CompletedRecord endSpotPenalty(EndPenaltyBean endPenaltyBean);
	
	public  CompletedRecord endCourtPenalty(EndPenaltyBean endPenaltyBean);
}
