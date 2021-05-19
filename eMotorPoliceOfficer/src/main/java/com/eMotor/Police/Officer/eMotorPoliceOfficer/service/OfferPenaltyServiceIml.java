package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.OfferPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverPenaltyRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.DriverRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.PenaltyDateSettingsRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.PenaltyRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Penalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.PenaltyDateSettings;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Service
public class OfferPenaltyServiceIml implements OfferPenaltyService{

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private PenaltyRepository penaltyRepository;
	
	@Autowired
	private UseraccountRepository useraccountRepository;
	
	@Autowired
	private DriverPenaltyRepository driverPenaltyRepository;
	
	@Autowired
	private PenaltyDateSettingsRepository penaltyDateSettingsRepository;
	
	
	@Override
	public DriverPenalty offerPenalty(OfferPenaltyBean theOfferPenaltyBean) {
		
		Optional<Driver> foundDriver = driverRepository.findDriving(theOfferPenaltyBean.getLicenseNo(), theOfferPenaltyBean.getNic());
			
		Penalty thePenalty =  penaltyRepository.findById(theOfferPenaltyBean.getPenaltyId()).get();
		
		Useraccount theUseraccount =  useraccountRepository.findById(2).get();
		
		DriverPenalty theDriverPenalty = new DriverPenalty();
		
		

		theDriverPenalty.setPenaltyFrom(LocalDateTime.now());
		
		theDriverPenalty.setPlace(theOfferPenaltyBean.getPlace());
		theDriverPenalty.setVehicleNo(theOfferPenaltyBean.getVehicleNo());
		theDriverPenalty.setCourt(theOfferPenaltyBean.getCourt());
		theDriverPenalty.setCourtDate(theOfferPenaltyBean.getCourtDate());
		theDriverPenalty.setType(theOfferPenaltyBean.getType());
		
		if(theOfferPenaltyBean.getType().equalsIgnoreCase("court")){
			theDriverPenalty.setStatus("Court pending");
		}else {
			theDriverPenalty.setStatus("Pending");
		}
		
		theDriverPenalty.setPenalty(thePenalty);
		theDriverPenalty.setDriver(foundDriver.get());
		theDriverPenalty.setUseraccount(theUseraccount);
		
		ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
		
		PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dateSettings.getCourtDateCount());  
		
		theDriverPenalty.setPenaltyTo(new Date(cal.getTimeInMillis()));
		
		
		
		if(foundDriver.isPresent()) {
			
			int penaltyCount = driverPenaltyRepository.findDriverPenaltycountByDriver(foundDriver.get())+1;
			
			theDriverPenalty.setPenaltyNo(theOfferPenaltyBean.getLicenseNo()+penaltyCount);
			
			
			
			return driverPenaltyRepository.save(theDriverPenalty);
			
		}else {
			Driver theDriver = new Driver();
			
			theDriver.setLicenseNo(theOfferPenaltyBean.getLicenseNo());
			theDriver.setNic(theOfferPenaltyBean.getNic());
			theDriver.setStatus(true);
			
			Driver newDriver = driverRepository.save(theDriver);
			
			theDriverPenalty.setPenaltyNo(theOfferPenaltyBean.getLicenseNo()+"1");
			
			theDriverPenalty.setDriver(newDriver);
			
			return driverPenaltyRepository.save(theDriverPenalty);
		}
		
	}

	@Override
	public List<Penalty> findPenaltiesByType(String type) {
		
		return penaltyRepository.findPenaltiesByType(type);
	}

	
}
