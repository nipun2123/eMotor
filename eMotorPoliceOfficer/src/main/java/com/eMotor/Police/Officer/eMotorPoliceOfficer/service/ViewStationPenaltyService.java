package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;


import java.sql.Date;
import java.util.List;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface ViewStationPenaltyService {

	public  List<DriverPenalty> findPenaltiesByStationAll();
	
	public  List<DriverPenalty> findPenaltiesByStationMy();
	
	public  List<DriverPenalty> findPenaltiesByStationPending();
	
	public  List<DriverPenalty> findPenaltiesByStationEnded();
	
	public  List<DriverPenalty> findPenaltiesByStationExpired();
}
