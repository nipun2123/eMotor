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
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.SuspendedLicenseRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
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
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenaltyPending();
		
		System.out.println(driverPenaltyList.size());
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  
			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
				
			 		newPenaltyList.add(theDriverPenalty);
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
		
		List<DriverPenalty> driverPenaltyList =  driverPenaltyRepository.findDriverPenaltyExpired();
		
		for(DriverPenalty theDriverPenalty : driverPenaltyList) {
			
			  Useraccount loggedUseraccount = useraccountRepository.findById(loggedUserId).get();
			  String userPoliceStation =  loggedUseraccount.getOfficer().getStation().getPoliceStation();
			  
			  String penaltyPoliceStation =  theDriverPenalty.getUseraccount().getOfficer().getStation().getPoliceStation();
			  
			  if(userPoliceStation.equalsIgnoreCase(penaltyPoliceStation)) {
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			       theDriverPenalty.setFormatedPenaltyFrom(theDriverPenalty.getPenaltyFrom().format(format));
			
			 		
			 		newPenaltyList.add(theDriverPenalty);
			  }
		}
		return newPenaltyList;
	}
	


	

}
