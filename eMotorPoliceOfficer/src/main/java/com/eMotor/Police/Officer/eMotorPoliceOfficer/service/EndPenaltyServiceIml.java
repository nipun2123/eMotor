package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
public class EndPenaltyServiceIml implements EndPenaltyService{
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private UseraccountRepository useraccountRepository;
	
	@Autowired
	private DriverPenaltyRepository driverPenaltyRepository;
	
	@Autowired
	private CompletedRecordRepository completedRecordRepository;
	
	@Autowired
	private SuspendedLicenseRepository suspendedLicenseRepository;
	
	@Autowired
	private PenaltyDateSettingsRepository penaltyDateSettingsRepository;
	
	@Override
	public List<DriverPenalty> findPenaltiesByLicenseNo(String licenseNo) {
		  List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		int loggedUserId = 2;
	  Optional<Driver> theDriver =	driverRepository.findDriving(licenseNo);
	  
	  if(theDriver.isPresent()) {
		  List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenalty(theDriver.get());
	    	
		
		  
	    	for(DriverPenalty theDriverPenalty : driverPenaltyList) {
	    		
	    		if(!theDriverPenalty.getStatus().equalsIgnoreCase("completed")) {
	    			
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
		    					theDriverPenalty.setType("court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("court");
		    				}
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
		    		
		    				
		    			
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    				}
		    		
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
		    			
		    	
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("court");
		    				}
		    	
		    		}
	    			
	    			  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		    	       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
		    	       
		    	       
	    			if(theDriverPenalty.getType().equalsIgnoreCase("court")) {
	    			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
	    				
	    			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
	    			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
	    			  
	    			  if(penaltyPoliceStation.equalsIgnoreCase(userPoliceStation)) {
	    				  
	    				  newPenaltyList.add(theDriverPenalty);
	    			  }
	    			  
	    			}else {
	    				 newPenaltyList.add(theDriverPenalty);
	    			}
	    		}
	    		
	    
	    	}
	  }
	  
	  return newPenaltyList;
	}
	


	@Override
	public List<DriverPenalty> findPenaltyByNo(String penaltyNo) {
		
		List<DriverPenalty> newPenaltyList = new ArrayList<DriverPenalty>();
		
		int loggedUserId = 1;
		DriverPenalty theDriverPenalty =  driverPenaltyRepository.findDriverPenaltyByNo(penaltyNo);
		
		if(!theDriverPenalty.getStatus().equalsIgnoreCase("completed")) {
			
			
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
  					theDriverPenalty.setType("court");
  				}
  				
  				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
  					theDriverPenalty.setStatus("Expired");
  					theDriverPenalty.setType("court");
  				}
  			
  		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
  		
  				
  			
  				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
  					theDriverPenalty.setStatus("Expired");
  				}
  		
  		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
  			
  	
  				
  				if(theDriverPenalty.getPenaltyTo().before(new java.util.Date() )) {
  					theDriverPenalty.setStatus("Court pending");
  					theDriverPenalty.setType("court");
  				}
  				
  				if(theDriverPenalty.getCourtDate().before(new java.util.Date(cal.getTimeInMillis()) )) {
  					theDriverPenalty.setStatus("Expired");
  					theDriverPenalty.setType("court");
  				}
  	
  		}
			
			  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
  	       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
  	       
  	       
  	       if(theDriverPenalty.getType().equalsIgnoreCase("court")) {
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
				
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  if(penaltyPoliceStation.equalsIgnoreCase(userPoliceStation)) {
				  
				  newPenaltyList.add(theDriverPenalty);
			  }
			  
			}else {
				 newPenaltyList.add(theDriverPenalty);
			}
		}
		
	  	
	 		return newPenaltyList;
	}



	@Override
	public CompletedRecord endWarnPenalty(EndPenaltyBean endPenaltyBean) {
		int loggedUserId = 1;
		DriverPenalty theDriverPenalty =  driverPenaltyRepository.findDriverPenaltyByNo(endPenaltyBean.getPenaltyNo());
		
	    Useraccount theloggedUseraccount = useraccountRepository.findById(loggedUserId).get();
	    
	    CompletedRecord theCompletedRecord = new CompletedRecord();
	    theCompletedRecord.setResult("Warn completed");
	    theCompletedRecord.setCompletedDate(LocalDateTime.now());
	    theCompletedRecord.setUseraccount(theloggedUseraccount);
	    theCompletedRecord.setDriverPenalty(theDriverPenalty);
	    CompletedRecord theSavedCompletedRecord = completedRecordRepository.save(theCompletedRecord);
	    
	    if(theSavedCompletedRecord != null) {
	    	theDriverPenalty.setStatus("Completed");
	    	driverPenaltyRepository.save(theDriverPenalty);
	    }
	    
	    return theSavedCompletedRecord;
	}



	@Override
	public CompletedRecord endSpotPenalty(EndPenaltyBean endPenaltyBean) {
		int loggedUserId = 1;
		DriverPenalty theDriverPenalty =  driverPenaltyRepository.findDriverPenaltyByNo(endPenaltyBean.getPenaltyNo());
		
	    Useraccount theloggedUseraccount = useraccountRepository.findById(loggedUserId).get();
	    
	    CompletedRecord theCompletedRecord = new CompletedRecord();
	    theCompletedRecord.setResult("Spot fine completed by paying rs."+endPenaltyBean.getPaidAmount());
	    theCompletedRecord.setCompletedDate(LocalDateTime.now());
	    theCompletedRecord.setUseraccount(theloggedUseraccount);
	    theCompletedRecord.setDriverPenalty(theDriverPenalty);
	    CompletedRecord theSavedCompletedRecord = completedRecordRepository.save(theCompletedRecord);
		
		   if(theSavedCompletedRecord != null) {
		    	theDriverPenalty.setStatus("Completed");
		    	driverPenaltyRepository.save(theDriverPenalty);
		    }
		    
		    return theSavedCompletedRecord;
	}



	@Override
	public CompletedRecord endCourtPenalty(EndPenaltyBean endPenaltyBean) {
		int loggedUserId = 1;
		DriverPenalty theDriverPenalty =  driverPenaltyRepository.findDriverPenaltyByNo(endPenaltyBean.getPenaltyNo());
		
	    Useraccount theloggedUseraccount = useraccountRepository.findById(loggedUserId).get();
	    
	    CompletedRecord theCompletedRecord = new CompletedRecord();
	    
	    
	    String result = "Court fine completed: ";
	    if(endPenaltyBean.isPayFine()) {
	    	result += "| paid rs."+endPenaltyBean.getPaidAmount()+".";
	    }
	    
	    
	    if(endPenaltyBean.isLicenseSuspend()) {
	    	Driver theDriver = theDriverPenalty.getDriver();
	    	theDriver.setStatus(false);
	    	
	    	SuspendedLicense theSuspendedLicense = new SuspendedLicense();
	    	theSuspendedLicense.setDriver(theDriver);
	    	theSuspendedLicense.setsuspendedFrom(new Date(System.currentTimeMillis()));
	    	
	    	  if(endPenaltyBean.getSuspededYear() == 0 && endPenaltyBean.getSuspededMonth() == 0 && endPenaltyBean.getSuspededDate()== 0) {
	    		  result += "| license suspended for forever.";
	    		  
	  	    }else {
	  	    	Calendar cal = Calendar.getInstance();
	  			cal.add(Calendar.YEAR, endPenaltyBean.getSuspededYear());  
	  			cal.add(Calendar.MONTH, endPenaltyBean.getSuspededMonth());  
	  			cal.add(Calendar.DAY_OF_MONTH, endPenaltyBean.getSuspededDate());  
	  			
	  			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	  			java.util.Date date = new java.util.Date();
	  			
	  			theSuspendedLicense.setsuspendedTo(new Date(cal.getTimeInMillis()));
	  			
	  	    	result += "| license suspended from "+formatter.format(date)+" to "+new Date(cal.getTimeInMillis())+".";
	  	    }
	  	    
	    	  Driver savedDriver = driverRepository.save(theDriver);
	    	  
	    	  if(savedDriver != null) {
	    	  suspendedLicenseRepository.save(theSuspendedLicense);
	    	  }
	    	  
	    }
	    
	    if(endPenaltyBean.isJailed()) {
	    	  if(endPenaltyBean.getJailedYear() == 0 && endPenaltyBean.getJailedMonth() == 0 && endPenaltyBean.getJailedDate()== 0) {
	    		  result += "| jailed for forever.";
	  	    }else {
	  	    	Calendar cal = Calendar.getInstance();
	  			cal.add(Calendar.YEAR, endPenaltyBean.getJailedYear());  
	  			cal.add(Calendar.MONTH, endPenaltyBean.getJailedMonth());  
	  			cal.add(Calendar.DAY_OF_MONTH, endPenaltyBean.getJailedDate());  
	  			
	  			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	  			java.util.Date date = new java.util.Date();  
	  			
	  	    	result += "| jailed from "+formatter.format(date)+" to "+new Date(cal.getTimeInMillis())+".";
	  	    }
	  	    
	    }
	    if(endPenaltyBean.isFreed()) {
	    	result = "Court fine completed: freed.";
	    }
	    
	    theCompletedRecord.setResult(result);
	    theCompletedRecord.setCompletedDate(LocalDateTime.now());
	    theCompletedRecord.setUseraccount(theloggedUseraccount);
	    theCompletedRecord.setDriverPenalty(theDriverPenalty);
	    CompletedRecord theSavedCompletedRecord =  completedRecordRepository.save(theCompletedRecord);
		
		 if(theSavedCompletedRecord != null) {
		    	theDriverPenalty.setStatus("Completed");
		    	driverPenaltyRepository.save(theDriverPenalty);
		    }
		    
		    return theSavedCompletedRecord;
	}





	

}
