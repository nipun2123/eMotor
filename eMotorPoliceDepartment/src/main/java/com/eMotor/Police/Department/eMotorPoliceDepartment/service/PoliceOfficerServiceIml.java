package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceOfficerRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceStationRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.UserAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.encription.Encrypt;
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
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
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
				user.setUsername(savedOfficer.getNic());
				String pass = Encrypt.encript(savedOfficer.getOfficerNo());
				user.setPassword(bCryptPasswordEncoder.encode(pass));
				user.setOfficer(savedOfficer);
				userAccountRepository.save(user);
				
				String tel = savedOfficer.getTel().substring(1);
				
				String msg = "Dear police officer, \n Your account username is "+savedOfficer.getNic()+" and password is "+ pass+" \n You can change it by login into the system.";
				
				final String uri = "https://app.notify.lk/api/v1/send?user_id=13387&api_key=QFHLNDXbpawpt5oQys3d&sender_id=NotifyDEMO&to=+94"+tel+"&message="+msg;

				 RestTemplate restTemplate = new RestTemplate();
				 
				restTemplate.getForObject(uri, Map.class);
				  
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


	



	

}
