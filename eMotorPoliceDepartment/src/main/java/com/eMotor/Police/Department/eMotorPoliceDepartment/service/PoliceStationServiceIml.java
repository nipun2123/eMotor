package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceStationRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.ProvinceRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;

@Service
public class PoliceStationServiceIml implements PoliceStationService {

	@Autowired
	private PoliceStationRepository policeStationRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	

	@Override
	public PoliceStation save(PoliceStation thePoliceStation) {
		
		thePoliceStation.setProvince(provinceRepository.findByProvince(thePoliceStation.getProvinceName()));
	
		Optional<PoliceStation> result = policeStationRepository.findByPoliceStation(thePoliceStation.getPoliceStation());
		
		if(thePoliceStation.getOldPoliceStation().isEmpty()) {
			
		if(!result.isPresent()) {
			thePoliceStation.setIdPoliceStation(0);
			return policeStationRepository.save(thePoliceStation);
		}else {
			throw new RuntimeException("The police station already registred- "+ thePoliceStation.getPoliceStation());
		}
		
		}else {
			
			Optional<PoliceStation> oldResult = policeStationRepository.findByPoliceStation(thePoliceStation.getOldPoliceStation());
			
			thePoliceStation.setIdPoliceStation(oldResult.get().getIdPoliceStation());
			
			if(!thePoliceStation.getOldPoliceStation().equalsIgnoreCase(thePoliceStation.getPoliceStation())) {
				
				if(!result.isPresent()) {
			
			
			return policeStationRepository.save(thePoliceStation);
			
			}else {
				throw new RuntimeException("The police station already registred- "+ thePoliceStation.getPoliceStation());
			}
			
			}
			
			
			return policeStationRepository.save(thePoliceStation);
		}
	}


	@Override
	public List<PoliceStation> findAll() {
		
		return policeStationRepository.findAll();
	}
	
	

}
