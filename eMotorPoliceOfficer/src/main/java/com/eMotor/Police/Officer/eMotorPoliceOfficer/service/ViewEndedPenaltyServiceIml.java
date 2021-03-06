package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.CompletedRecordRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverPenaltyRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Service
public class ViewEndedPenaltyServiceIml implements ViewEndedPenaltyService{

	@Autowired
	private UseraccountRepository useraccountRepository;
	
	@Autowired
	private DriverPenaltyRepository driverPenaltyRepository;
	
	@Autowired
	private CompletedRecordRepository completedRecordRepository;
	


	@Override
	public List<DriverPenalty> findEndedPenaltiesByStationAll(String loggedUsername) {
		
		
		 List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		 
		 
		  List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findAll();
	    	
			
		  
	    	for(DriverPenalty theDriverPenalty : driverPenaltyList) {
	    		
	    		if(theDriverPenalty.getStatus().equalsIgnoreCase("completed") ) {
	    			
	    			  Useraccount loggedUseraccount = useraccountRepository.findByUsername(loggedUsername);
	    			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
	    			  
	    			  CompletedRecord theCompletedRecord =  completedRecordRepository.findCompletedRecord(theDriverPenalty).get();
	    			  String penaltyPoliceStation =  theCompletedRecord.getUseraccount().getOfficer().getStation().getPoliceStation();
	    			  
	    			  
	    			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
	    				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			    	       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
			    	       theCompletedRecord.setFormatedCompletedDate(theCompletedRecord.getCompletedDate().format(format));
	    				  theDriverPenalty.setCompletedRecord(theCompletedRecord);
	    				  newPenaltyList.add(theDriverPenalty);
	    			  }
	    			
	    		}
	    		
	    
	    	}
	    	
	    	return newPenaltyList;
	}



	@Override
	public List<DriverPenalty> findEndedPenaltiesByStationToday(String loggedUsername) {
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		Useraccount loggedUseraccount = useraccountRepository.findByUsername(loggedUsername);
		  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
		  
		  
		List<CompletedRecord> theCompletedRecordList =  completedRecordRepository.findCompletedRecordsToday(new Date(System.currentTimeMillis()));
		
		for(CompletedRecord theCompletedRecord : theCompletedRecordList) {
			String penaltyPoliceStation =  theCompletedRecord.getUseraccount().getOfficer().getStation().getPoliceStation();
			 if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				 theCompletedRecord.getDriverPenalty().setCompletedRecord(theCompletedRecord);
				 
				 DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				 theCompletedRecord.getDriverPenalty().setFormatedPenaltyFrom(theCompletedRecord.getDriverPenalty().getPenaltyFrom().format(format));
	    	       theCompletedRecord.setFormatedCompletedDate(theCompletedRecord.getCompletedDate().format(format));
				  
				 newPenaltyList.add(theCompletedRecord.getDriverPenalty());
			 }
		}
		return newPenaltyList;
	}



	@Override
	public List<DriverPenalty> findEndedPenaltiesByStationBetween(Date from, Date to, String loggedUsername) {
List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		Useraccount loggedUseraccount = useraccountRepository.findByUsername(loggedUsername);
		  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
		  
		  
		List<CompletedRecord> theCompletedRecordList =  completedRecordRepository.findCompletedRecordsBetween(from, to);
		
		for(CompletedRecord theCompletedRecord : theCompletedRecordList) {
			String penaltyPoliceStation =  theCompletedRecord.getUseraccount().getOfficer().getStation().getPoliceStation();
			 if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				 theCompletedRecord.getDriverPenalty().setCompletedRecord(theCompletedRecord);
				 
				 DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				 theCompletedRecord.getDriverPenalty().setFormatedPenaltyFrom(theCompletedRecord.getDriverPenalty().getPenaltyFrom().format(format));
	    	       theCompletedRecord.setFormatedCompletedDate(theCompletedRecord.getCompletedDate().format(format));
				  
				 newPenaltyList.add(theCompletedRecord.getDriverPenalty());
			 }
		}
		return newPenaltyList;
	}
	


	
	

}
