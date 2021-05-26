package com.eMotor.Driver.eMotorDriver.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Driver.eMotorDriver.dao.PenaltyRepository;
import com.eMotor.Driver.eMotorDriver.entity.Penalty;

@Service
public class PenaltyServiceIml implements PenaltyService {

	@Autowired
	private PenaltyRepository penaltyRepository;

	
	@Override
	public List<Penalty> findAll() {
		
		return penaltyRepository.findAll();
	}

	

}
