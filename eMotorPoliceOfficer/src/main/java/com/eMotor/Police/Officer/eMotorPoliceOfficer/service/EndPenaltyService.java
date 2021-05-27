package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;


import java.util.List;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface EndPenaltyService {

	public  List<DriverPenalty> findPenaltiesByLicenseNo(String licenseNo, String loggedUsername);
	
	public  List<DriverPenalty> findPenaltyByNo(String penaltyNo, String loggedUsername);
	
	public  CompletedRecord endWarnPenalty(EndPenaltyBean endPenaltyBean, String loggedUsername);
	
	public  CompletedRecord endSpotPenalty(EndPenaltyBean endPenaltyBean, String loggedUsername);
	
	public  CompletedRecord endCourtPenalty(EndPenaltyBean endPenaltyBean, String loggedUsername);
}
