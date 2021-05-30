package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;


import java.sql.Date;
import java.util.List;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface ViewEndedPenaltyService {

	public  List<DriverPenalty> findEndedPenaltiesByStationAll(String loggedUsername);
	
	public  List<DriverPenalty> findEndedPenaltiesByStationToday(String loggedUsername);
	
	public  List<DriverPenalty> findEndedPenaltiesByStationBetween(Date from, Date to,String loggedUsername);
}
