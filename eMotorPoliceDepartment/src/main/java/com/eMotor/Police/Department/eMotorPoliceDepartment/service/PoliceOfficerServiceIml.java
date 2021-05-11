package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceOfficerRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceStationRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.UserAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.UserAccount;


@Service
public class PoliceOfficerServiceIml implements PoliceOfficerService {

	@Autowired
	private PoliceOfficerRepository policeOfficerRepository;
	
	@Autowired
	private PoliceStationRepository policeStationRepository;
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	

	@Override
	public PoliceOfficer save(PoliceOfficer thePoliceOfficer) {
		
		thePoliceOfficer.setStation(policeStationRepository.findByPoliceStation(thePoliceOfficer.getPoliceStationName()).get());
	
		if(thePoliceOfficer.getAvailabilityTxt().equalsIgnoreCase("active")) {
			thePoliceOfficer.setAvailability(true);
		}else {
			thePoliceOfficer.setAvailability(false);
		}
		
		Optional<PoliceOfficer> nicResult = policeOfficerRepository.findByNIC(thePoliceOfficer.getNic());
		Optional<PoliceOfficer> officerNoResult = policeOfficerRepository.findByOfficerNo(thePoliceOfficer.getOfficerNo());
		
		if(thePoliceOfficer.getOldPoliceOfficerNic().isEmpty()) {
			
		if(!nicResult.isPresent()) {
			if(!officerNoResult.isPresent()) {
				thePoliceOfficer.setIdPoliceOfficer(0);
				
				PoliceOfficer savedOfficer =  policeOfficerRepository.save(thePoliceOfficer);
				
				UserAccount user = new UserAccount();
				user.setIdUserAccount(0);
				user.setUsername(thePoliceOfficer.getNic());
				user.setPassword(thePoliceOfficer.getOfficerNo());
				user.setOfficer(savedOfficer);
				userAccountRepository.save(user);
				
				return savedOfficer;
				
				
				
			}else {
				throw new RuntimeException("The police officer already registred- "+ thePoliceOfficer.getOfficerNo());
			}
		}else {
			throw new RuntimeException("The police officer already registred- "+ thePoliceOfficer.getNic());
		}
		
		
		
		}else {
			
			Optional<PoliceOfficer> oldNicResult = policeOfficerRepository.findByNIC(thePoliceOfficer.getOldPoliceOfficerNic());
			
			thePoliceOfficer.setIdPoliceOfficer(oldNicResult.get().getIdPoliceOfficer());
			
			if(!thePoliceOfficer.getOldPoliceOfficerNic().equalsIgnoreCase(thePoliceOfficer.getNic())) {
				
				if(!nicResult.isPresent()) {
					if(!thePoliceOfficer.getOldPoliceOfficerNo().equalsIgnoreCase(thePoliceOfficer.getOfficerNo())) {
						
						if(!officerNoResult.isPresent()) {
							return policeOfficerRepository.save(thePoliceOfficer);
							
						}else {
							throw new RuntimeException("The police officer already registred- "+ thePoliceOfficer.getOfficerNo());
						}
						
					}else {
						return policeOfficerRepository.save(thePoliceOfficer);
					}
					
				}else {
					throw new RuntimeException("The police officer already registred- "+ thePoliceOfficer.getNic());
				}
			}else {
				
				if(!thePoliceOfficer.getOldPoliceOfficerNo().equalsIgnoreCase(thePoliceOfficer.getOfficerNo())) {
					
					if(!officerNoResult.isPresent()) {
						return policeOfficerRepository.save(thePoliceOfficer);
						
					}else {
						throw new RuntimeException("The police officer already registred- "+ thePoliceOfficer.getOfficerNo());
					}
					
				}else {
					return policeOfficerRepository.save(thePoliceOfficer);
				}
				
			}
			
		
		}
	}


	@Override
	public List<PoliceOfficer> findAll() {
		
		return policeOfficerRepository.findAll();
	}


	@Override
	public boolean sendPasswordAgain(String nic) {
		
		PoliceOfficer thePoliceOfficer =  policeOfficerRepository.findByNIC(nic).get();
		UserAccount theUserAccount = userAccountRepository.findByUsername(nic);
//		
		System.out.println(thePoliceOfficer.getTel());
		System.out.println(theUserAccount.getUsername());
//		
		System.out.println(theUserAccount.getPassword());
		
		
		return true;
	}



	

}
