package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.util.List;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.beans.OfferPenaltyBean;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Penalty;

public interface OfferPenaltyService {

	public DriverPenalty offerPenalty(OfferPenaltyBean theOfferPenaltyBean);
	
	public List<Penalty> findPenaltiesByType(String type);
}
