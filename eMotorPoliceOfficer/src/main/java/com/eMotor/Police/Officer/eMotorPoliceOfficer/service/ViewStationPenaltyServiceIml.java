package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.EndPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.CompletedRecordRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverPenaltyRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.PenaltyDateSettingsRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.SuspendedLicenseRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.PenaltyDateSettings;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.SuspendedLicense;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Service
public class ViewStationPenaltyServiceIml implements ViewStationPenaltyService{

	@Autowired
	private UseraccountRepository useraccountRepository;
	
	@Autowired
	private DriverPenaltyRepository driverPenaltyRepository;
	
	@Autowired
	private CompletedRecordRepository completedRecordRepository;

	@Autowired
	private PenaltyDateSettingsRepository penaltyDateSettingsRepository;
	
	@Override
	public List<DriverPenalty> findPenaltiesByStationAll() {
		int loggedUserId = 2;
		
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findAll();
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  
			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				  
				  Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DAY_OF_MONTH, -1);  
					
				  if(!theDriverPenalty.getStatus().equalsIgnoreCase("completed")) {
		    			
			    		
			    		if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("spot")) {
			    			
			    				
			    				ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
			    				
			    				PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
			    				
			    				
			    				java.util.Date fromDate = java.sql.Timestamp.valueOf(theDriverPenalty.getPenaltyFrom().plusDays(dateSettings.getDoubleDateCount()));
			    				
			    				if(fromDate.before(new java.util.Date() )) {
			    					theDriverPenalty.setStatus("Double pending");
			    				}
			    				
			    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
			    					theDriverPenalty.setStatus("Court pending");
			    					theDriverPenalty.setType("Court");
			    				}
			    				
			    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
			    					theDriverPenalty.setStatus("Expired");
			    					theDriverPenalty.setType("Court");
			    				}
			    			
			    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
			    			
			    		
			    				
			    			
			    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
			    					theDriverPenalty.setStatus("Expired");
			    				}
			    				
			    			
			    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
			    			
			    		
			    				
			    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
			    					theDriverPenalty.setStatus("Court pending");
			    					theDriverPenalty.setType("Court");
			    				}
			    				
			    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
			    					theDriverPenalty.setStatus("Expired");
			    					theDriverPenalty.setType("Court");
			    				}
			    				
			    			
			    		}
			    		
			    	}
				  
				  
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
				
			  	 Optional<CompletedRecord> theCompletedrecord = completedRecordRepository.findCompletedRecord(theDriverPenalty);
			 
			 		if(theCompletedrecord.isPresent()) {
			 			theCompletedrecord.get().setDriverPenalty(null);
			 			theCompletedrecord.get().setFormatedCompletedDate(theCompletedrecord.get().getCompletedDate().format(format));
			 			theDriverPenalty.setCompletedRecord(theCompletedrecord.get());
			 		}
			 		
			 		newPenaltyList.add(theDriverPenalty);
			  }
		}
		return newPenaltyList;
	}

	
	
	
	@Override
	public List<DriverPenalty> findPenaltiesByStationMy() {
		int loggedUserId = 2;
		
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findAll();
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceOfficerNo =  loggedUseraccount.getOfficer().getOfficerNo();
			  
			  String penaltyPoliceOfficerNo =  theDriverPenalty.getUseraccount().getOfficer().getOfficerNo();
			  
			  if(userPoliceOfficerNo.equalsIgnoreCase(penaltyPoliceOfficerNo)) {
				  
				  Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DAY_OF_MONTH, -1);  
					
				  if(!theDriverPenalty.getStatus().equalsIgnoreCase("completed")) {
		    			
			    		
			    		if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("spot")) {
			    			
			    				
			    				ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
			    				
			    				PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
			    				
			    				
			    				java.util.Date fromDate = java.sql.Timestamp.valueOf(theDriverPenalty.getPenaltyFrom().plusDays(dateSettings.getDoubleDateCount()));
			    				
			    				if(fromDate.before(new java.util.Date() )) {
			    					theDriverPenalty.setStatus("Double pending");
			    				}
			    				
			    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
			    					theDriverPenalty.setStatus("Court pending");
			    					theDriverPenalty.setType("Court");
			    				}
			    				
			    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
			    					theDriverPenalty.setStatus("Expired");
			    					theDriverPenalty.setType("Court");
			    				}
			    			
			    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
			    			
			    		
			    				
			    			
			    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
			    					theDriverPenalty.setStatus("Expired");
			    				}
			    				
			    			
			    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
			    			
			    		
			    				
			    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
			    					theDriverPenalty.setStatus("Court pending");
			    					theDriverPenalty.setType("Court");
			    				}
			    				
			    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
			    					theDriverPenalty.setStatus("Expired");
			    					theDriverPenalty.setType("Court");
			    				}
			    				
			    			
			    		}
			    		
			    	}
				  
				  
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
				
			  	 Optional<CompletedRecord> theCompletedrecord = completedRecordRepository.findCompletedRecord(theDriverPenalty);
			 
			 		if(theCompletedrecord.isPresent()) {
			 			theCompletedrecord.get().setDriverPenalty(null);
			 			theCompletedrecord.get().setFormatedCompletedDate(theCompletedrecord.get().getCompletedDate().format(format));
			 			theDriverPenalty.setCompletedRecord(theCompletedrecord.get());
			 		}
			 		
			 		newPenaltyList.add(theDriverPenalty);
			  }
		}
		return newPenaltyList;
	}
	
	

	@Override
	public List<DriverPenalty> findPenaltiesByStationPending() {
		int loggedUserId = 2;
		
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenaltyNotEnded();
		
		System.out.println(driverPenaltyList.size());
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			
			 Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, -1);  
				
	    			
		    		
		    		if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("spot")) {
		    			
		    				
		    				ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
		    				
		    				PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
		    				
		    				
		    				java.util.Date fromDate = java.sql.Timestamp.valueOf(theDriverPenalty.getPenaltyFrom().plusDays(dateSettings.getDoubleDateCount()));
		    				
		    				if(fromDate.before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Double pending");
		    				}
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("Court");
		    				}
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
		    			
		    		
		    				
		    			
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    				}
		    				
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
		    			
		    		
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    			
		    		}
		    	
		    		if(!theDriverPenalty.getStatus().equalsIgnoreCase("Expired")) {
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  
			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
				
			 		newPenaltyList.add(theDriverPenalty);
			  }
		    		}
		}
		return newPenaltyList;
	}

	
	
	@Override
	public List<DriverPenalty> findPenaltiesByStationEnded() {
		
		int loggedUserId = 2;
		
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenaltyEnded();
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  
			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
				
			  	 Optional<CompletedRecord> theCompletedrecord = completedRecordRepository.findCompletedRecord(theDriverPenalty);
			 
			 		if(theCompletedrecord.isPresent()) {
			 			theCompletedrecord.get().setDriverPenalty(null);
			 			theCompletedrecord.get().setFormatedCompletedDate(theCompletedrecord.get().getCompletedDate().format(format));
			 			theDriverPenalty.setCompletedRecord(theCompletedrecord.get());
			 		}
			 		
			 		newPenaltyList.add(theDriverPenalty);
			  }
		}
		return newPenaltyList;
	}

	
	
	@Override
	public List<DriverPenalty> findPenaltiesByStationExpired() {
int loggedUserId = 2;
		
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenaltyNotEnded();
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			
			 Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, -1);  
				
	    			
		    		
		    		if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("spot")) {
		    			
		    				
		    				ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
		    				
		    				PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
		    				
		    				
		    				java.util.Date fromDate = java.sql.Timestamp.valueOf(theDriverPenalty.getPenaltyFrom().plusDays(dateSettings.getDoubleDateCount()));
		    				
		    				if(fromDate.before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Double pending");
		    				}
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("Court");
		    				}
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
		    			
		    		
		    				
		    			
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    				}
		    				
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
		    			
		    		
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    			
		    		}
		    		
		    		if(theDriverPenalty.getStatus().equalsIgnoreCase("Expired")) {
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  
			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
			
			 		
			 		newPenaltyList.add(theDriverPenalty);
			  }
		    		}
		}
		return newPenaltyList;
	}
	


	

}
