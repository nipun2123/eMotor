package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.CompletedRecordRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverPenaltyRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.PenaltyDateSettingsRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.PoliceOfficerRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.SuspendedLicenseRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DrivingLicense;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.PenaltyDateSettings;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.PoliceOfficer;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.SuspendedLicense;

@Service
public class ViewLicenseServiceIml implements ViewLicenseService{
	
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
	
	@Autowired
	private PoliceOfficerRepository policeOfficerRepository;
	
	
	@Transactional
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
		List<DriverPenalty> driverPenaltyList =  new ArrayList<DriverPenalty>();
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
	    	
	    	driverPenaltyList =  driverPenaltyRepository.findDriverPenalty(theDriver.get());
	    	
	    	if (!driverPenaltyList.isEmpty()) {
				
			
	    	
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
	    		
	    		  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	    	       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
	    
	    	}
	    	}
	    	
	    
	    }
		 response.put("driverPenalties", driverPenaltyList);
	    
		return response;
	}


	@Transactional
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
		System.out.println(theDriverPenalty.getVehicleNo());
	  	 Optional<CompletedRecord> theCompletedrecord = completedRecordRepository.findCompletedRecord(theDriverPenalty);
	  	System.out.println(theCompletedrecord.get().getCompletedDate());
	 		if(theCompletedrecord.isPresent()) {
	 			System.out.println("aaa");
//	 			theCompletedrecord.get().setDriverPenalty(null);
	 			System.out.println("bbb");
	 			theCompletedrecord.get().setFormatedCompletedDate(theCompletedrecord.get().getCompletedDate().format(format));
	 			System.out.println("ccc");
	 			theDriverPenalty.setCompletedRecord(theCompletedrecord.get());
	 			System.out.println("ddd");
	 		}
	 		
	 		return theDriverPenalty;
	}


	@Override
	public PoliceOfficer findByUsername(String username) {
		
		return policeOfficerRepository.findByUsername(username);
	}
	
	

}
