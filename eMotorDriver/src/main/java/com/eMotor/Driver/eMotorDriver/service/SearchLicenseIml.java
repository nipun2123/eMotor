package com.eMotor.Driver.eMotorDriver.service;

import java.time.format.DateTimeFormatter;
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
import com.eMotor.Driver.eMotorDriver.dao.SuspendedLicenseRepository;
import com.eMotor.Driver.eMotorDriver.entity.CompletedRecord;
import com.eMotor.Driver.eMotorDriver.entity.Driver;
import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;
import com.eMotor.Driver.eMotorDriver.entity.DrivingLicense;
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

	
	@Override
	public Map<String, Object> searchDrivingLicense(String licenseNo, String nic) {
		final String uri = "http://localhost:8081/license/search/license?licenseno="+licenseNo+"&nic="+nic;

	    RestTemplate restTemplate = new RestTemplate();
	    DrivingLicense theLicense = restTemplate.getForObject(uri, DrivingLicense.class);
	    
	    System.out.println(theLicense.getNic());
	    Optional<Driver> theDriver = driverRepository.findDriving(licenseNo,nic);
	    
	    Map<String, Object> response = new HashMap<String, Object>();
	    
	    response.put("license", theLicense);
	    System.out.println(theDriver.get().getNic());
	    
	    if(theDriver.isPresent()) {
	    	
	    	if(!theDriver.get().isStatus()) {
	    		SuspendedLicense theSuspendedLicense = suspendedLicenseRepository.findSuspendedLicense(theDriver.get()).get();
	    		 response.put("suspend", theSuspendedLicense);
	    	}
	    	
	    	List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenalty(theDriver.get());
	    	
	    	for(DriverPenalty theDriverPenalty : driverPenaltyList) {
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
