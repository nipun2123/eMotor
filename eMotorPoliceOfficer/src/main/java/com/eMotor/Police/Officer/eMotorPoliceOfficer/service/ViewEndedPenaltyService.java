package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;


import java.sql.Date;
import java.util.List;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface ViewEndedPenaltyService {

	public  List<DriverPenalty> findEndedPenaltiesByStationAll();
	
	public  List<DriverPenalty> findEndedPenaltiesByStationToday();
	
	public  List<DriverPenalty> findEndedPenaltiesByStationBetween(Date from, Date to);
}
