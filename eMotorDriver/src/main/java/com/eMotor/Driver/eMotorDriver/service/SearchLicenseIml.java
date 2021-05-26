package com.eMotor.Driver.eMotorDriver.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eMotor.Driver.eMotorDriver.dao.CompletedRecordRepository;
import com.eMotor.Driver.eMotorDriver.dao.DriverPenaltyRepository;
import com.eMotor.Driver.eMotorDriver.dao.DriverRepository;
import com.eMotor.Driver.eMotorDriver.dao.PenaltyDateSettingsRepository;
import com.eMotor.Driver.eMotorDriver.dao.SuspendedLicenseRepository;
import com.eMotor.Driver.eMotorDriver.entity.CompletedRecord;
import com.eMotor.Driver.eMotorDriver.entity.Driver;
import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;
import com.eMotor.Driver.eMotorDriver.entity.DrivingLicense;
import com.eMotor.Driver.eMotorDriver.entity.PenaltyDateSettings;
import com.eMotor.Driver.eMotorDriver.entity.SuspendedLicense;
@Service
public class SearchLicenseIml implements SearchLicenseService{

	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private SuspendedLicenseRepository suspendedLicenseRepository;
	
	@Autowired
	private DriverPenaltyRepository driverPenaltyRepository;
	
	@Autowired
	private CompletedRecordRepository completedRecordRepository;

	@Autowired
	private PenaltyDateSettingsRepository penaltyDateSettingsRepository;
	
	
	@Override
	public Map<String, Object> searchDrivingLicense(String licenseNo, String nic) {
		final String uri = "http://localhost:8081/license/search/license?licenseno="+licenseNo+"&nic="+nic;

	    RestTemplate restTemplate = new RestTemplate();
	    DrivingLicense theLicense = restTemplate.getForObject(uri, DrivingLicense.class);
	    
	    System.out.println(theLicense.getNic());
	    Optional<Driver> theDriver = driverRepository.findDriving(licenseNo,nic);
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("license", theLicense);
	    Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);  
	    
	    
	    if(theDriver.isPresent()) {
	    	
	    	if(!theDriver.get().isStatus()) {
	    		SuspendedLicense theSuspendedLicense = suspendedLicenseRepository.findSuspendedLicense(theDriver.get()).get();
	    		if(theSuspendedLicense.getsuspendedTo().before(new Date(cal.getTimeInMillis())) ) {
	    		
	    			theDriver.get().setStatus(true);
	    			driverRepository.save(theDriver.get());
	    		}else {
	    			
	    			 response.put("suspend", theSuspendedLicense);
	    		}
	    	}
	    	
	    	List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenalty(theDriver.get());
	    	
	    	for(DriverPenalty theDriverPenalty : driverPenaltyList) {
	    		
	    		
	    		if(!theDriverPenalty.getStatus().equalsIgnoreCase("completed")) {
	    			
		    		
		    		if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("spot")) {
		    			
		    				
		    				ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
		    				
		    				PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
		    				
		    				
		    				Date fromDate = java.sql.Timestamp.valueOf(theDriverPenalty.getPenaltyFrom().plusDays(dateSettings.getDoubleDateCount()));
		    				
		    				if(fromDate.before(new Date() )) {
		    					theDriverPenalty.setStatus("Double pending");
		    				}
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("Court");
		    				}
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
		    			
		    		
		    				
		    			
		    				if(theDriverPenalty.getCourtDate().before(new Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    				}
		    				
		    			
		    		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
		    			
		    		
		    				
		    				if(theDriverPenalty.getPenaltyTo().before(new Date() )) {
		    					theDriverPenalty.setStatus("Court pending");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    				if(theDriverPenalty.getCourtDate().before(new Date(cal.getTimeInMillis()) )) {
		    					theDriverPenalty.setStatus("Expired");
		    					theDriverPenalty.setType("Court");
		    				}
		    				
		    			
		    		}
		    		
		    	}
	    		System.out.println(theDriverPenalty.getPenaltyNo());
	    		  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	    	       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
	    
	    	}
	    	
	    	 response.put("driverPenalties", driverPenaltyList);
	    }
	    
	    
		return response;
	}

	
	
	
	
	@Override
	public DriverPenalty findPenaltyByNo(String penaltyNo) {
		DriverPenalty theDriverPenalty =  driverPenaltyRepository.findDriverPenaltyByNo(penaltyNo);
		
		 Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -1);  
		    
			if(!theDriverPenalty.getStatus().equalsIgnoreCase("completed")) {
			
		if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("spot")) {
			
		
				
				ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
				
				PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
				
				
				Date fromDate = java.sql.Timestamp.valueOf(theDriverPenalty.getPenaltyFrom().plusDays(dateSettings.getDoubleDateCount()));
				
				if(fromDate.before(new Date() )) {
					theDriverPenalty.setStatus("Double pending");
				}
				
				if(theDriverPenalty.getPenaltyTo().before(new Date() )) {
					theDriverPenalty.setStatus("Court pending");
					theDriverPenalty.setType("Court");
				}
				
				if(theDriverPenalty.getCourtDate().before(new Date(cal.getTimeInMillis()) )) {
					theDriverPenalty.setStatus("Expired");
					theDriverPenalty.setType("Court");
				}
				
			
		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("court")) {
			
		
				
			
				if(theDriverPenalty.getCourtDate().before(new Date(cal.getTimeInMillis()) )) {
					theDriverPenalty.setStatus("Expired");
				}
				
			
		}else if(theDriverPenalty.getPenalty().getType().equalsIgnoreCase("warn")) {
			
				
				if(theDriverPenalty.getPenaltyTo().before(new Date() )) {
					theDriverPenalty.setStatus("Court pending");
					theDriverPenalty.setType("Court");
				}
				
				if(theDriverPenalty.getCourtDate().before(new Date(cal.getTimeInMillis()) )) {
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
	 		
	 		return theDriverPenalty;
	}

}
