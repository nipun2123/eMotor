package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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
	
	
	@Transactional
	@Override
	public DriverPenalty offerPenalty(OfferPenaltyBean theOfferPenaltyBean) {
		
		Optional<Driver> foundDriver = driverRepository.findDriving(theOfferPenaltyBean.getLicenseNo(), theOfferPenaltyBean.getNic());
			
		Penalty thePenalty =  penaltyRepository.findById(theOfferPenaltyBean.getPenaltyId()).get();
		
		System.out.println("bbbbbb"+theOfferPenaltyBean.getUsername());
		Useraccount theUseraccount =  useraccountRepository.findByUsername(theOfferPenaltyBean.getUsername());
		System.out.println("cccc"+theUseraccount.getIdUserAccount());
		DriverPenalty theDriverPenalty = new DriverPenalty();
		
		

		theDriverPenalty.setPenaltyFrom(LocalDateTime.now());
		
		theDriverPenalty.setPlace(theOfferPenaltyBean.getPlace());
		theDriverPenalty.setVehicleNo(theOfferPenaltyBean.getVehicleNo());
		theDriverPenalty.setCourt(theOfferPenaltyBean.getCourt());
		theDriverPenalty.setCourtDate(theOfferPenaltyBean.getCourtDate());
		theDriverPenalty.setType(theOfferPenaltyBean.getType());
		theDriverPenalty.setPenalty(thePenalty);
		theDriverPenalty.setUseraccount(theUseraccount);
		
		if(theOfferPenaltyBean.getType().equalsIgnoreCase("court")){
			theDriverPenalty.setStatus("Court pending");
			
			theDriverPenalty.setPenaltyTo(theOfferPenaltyBean.getCourtDate());
		}else {
			theDriverPenalty.setStatus("Pending");
			
			ArrayList<PenaltyDateSettings> dateSettingsList =  (ArrayList<PenaltyDateSettings>) penaltyDateSettingsRepository.findAll();
			
			PenaltyDateSettings dateSettings = dateSettingsList.get(dateSettingsList.size()-1);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, dateSettings.getCourtDateCount());  
			
			theDriverPenalty.setPenaltyTo(new Date(cal.getTimeInMillis()));
		}
		
		
	
		
		
	
		
		
		
		if(foundDriver.isPresent()) {
			
			theDriverPenalty.setDriver(foundDriver.get());
			
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
