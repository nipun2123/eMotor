package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.CompletedRecordRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverPenaltyRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.SuspendedLicenseRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DrivingLicense;
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
	
	
	@Override
	public Map<String, Object> searchDrivingLicense(String licenseNo, String nic) {
		
		final String uri = "http://localhost:8081/license/search/license?licenseno="+licenseNo+"&nic="+nic;

	    RestTemplate restTemplate = new RestTemplate();
	    DrivingLicense theLicense = restTemplate.getForObject(uri, DrivingLicense.class);
	    
	    
	    Optional<Driver> theDriver = driverRepository.findDriving(licenseNo,nic);
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("license", theLicense);
	   
	    
	    if(theDriver.isPresent()) {
	    	
	    	if(!theDriver.get().isStatus()) {
	    		SuspendedLicense theSuspendedLicense = suspendedLicenseRepository.findSuspendedLicense(theDriver.get()).get();
	    		 response.put("suspend", theSuspendedLicense);
	    	}
	    	
	    	List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenalty(theDriver.get());
	    	
	    	for(DriverPenalty theDriverPenalty : driverPenaltyList) {
	    		
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
		
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
		
	  	 Optional<CompletedRecord> theCompletedrecord = completedRecordRepository.findCompletedRecord(theDriverPenalty);
	 
	 		if(theCompletedrecord.isPresent()) {
	 			theCompletedrecord.get().setDriverPenalty(null);
	 			theDriverPenalty.setCompletedRecord(theCompletedrecord.get());
	 		}
	 		
	 		return theDriverPenalty;
	}
	
	

}
