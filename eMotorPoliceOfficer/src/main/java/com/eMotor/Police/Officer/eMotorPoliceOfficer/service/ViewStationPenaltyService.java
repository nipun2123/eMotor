package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;


import java.util.List;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface ViewStationPenaltyService {

	public  List<DriverPenalty> findPenaltiesByStationAll(String loggedUsername);
	
	public  List<DriverPenalty> findPenaltiesByStationMy(String loggedUsername);
	
	public  List<DriverPenalty> findPenaltiesByStationPending(String loggedUsername);
	
	public  List<DriverPenalty> findPenaltiesByStationEnded(String loggedUsername);
	
	public  List<DriverPenalty> findPenaltiesByStationExpired(String loggedUsername);
}
