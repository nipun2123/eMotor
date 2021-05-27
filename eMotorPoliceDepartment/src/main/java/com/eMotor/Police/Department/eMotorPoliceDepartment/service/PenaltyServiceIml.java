package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.FineAmountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PenaltyDateSettingsRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PenaltyRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.FineAmount;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PenaltyDateSettings;


@Service
public class PenaltyServiceIml implements PenaltyService {

	@Autowired
	private PenaltyRepository penaltyRepository;
	
	@Autowired
	private FineAmountRepository fineAmountRepository;

	
	@Autowired
	private PenaltyDateSettingsRepository penaltyDateSettingsRepository;
	
	
	@Transactional
	@Override
	public Penalty saveSpot(Penalty thePenalty) {
		
		
		if(thePenalty.getIdPenalty() == 0) {
		
		FineAmount theFineAmount = new FineAmount();
		theFineAmount.setIdFineAmount(0);
		theFineAmount.setAmount(thePenalty.getAmount());
		
		fineAmountRepository.save(theFineAmount);
		
		thePenalty.setIdPenalty(0);
		thePenalty.setFineAmount(theFineAmount);
		thePenalty.setType("spot");
		thePenalty.setStatus(true);
		
		return penaltyRepository.save(thePenalty);
		
		}else {
			
			Penalty oldPenalty = penaltyRepository.findById(thePenalty.getIdPenalty()).get();
			
			FineAmount oldFineAmount = oldPenalty.getFineAmount();
			
			oldFineAmount.setAmount(thePenalty.getAmount());
			
			fineAmountRepository.save(oldFineAmount);
			
			oldPenalty.setPenaltyEnglish(thePenalty.getPenaltyEnglish());
			oldPenalty.setPenaltySinhala(thePenalty.getPenaltySinhala());
			oldPenalty.setPenaltyTamil(thePenalty.getPenaltyTamil());
			
			return penaltyRepository.save(oldPenalty);
		}
	}

	@Transactional
	@Override
	public List<Penalty> findAll() {
		
		return penaltyRepository.findAll();
	}

	@Transactional
	@Override
	public Penalty findById(int idPenalty) {
		
		return penaltyRepository.findById(idPenalty).get();
	}

	@Transactional
	@Override
	public Penalty delete(int idPenalty) {

		Penalty oldPenalty =  penaltyRepository.findById(idPenalty).get();
		oldPenalty.setStatus(false);
		return penaltyRepository.save(oldPenalty);
	}

	@Transactional
	@Override
	public Penalty saveCourt(Penalty thePenalty) {
	
		
			thePenalty.setType("court");
			thePenalty.setStatus(true);
			
			return penaltyRepository.save(thePenalty);
			
			
	}

	@Transactional
	@Override
	public Penalty saveWarn(Penalty thePenalty) {
	
		thePenalty.setType("warn");
		thePenalty.setStatus(true);
		
		return penaltyRepository.save(thePenalty);
	}

	@Transactional
	@Override
	public PenaltyDateSettings savePenaltyDateSettings(PenaltyDateSettings thePenaltyDateSettings) {
		
		return penaltyDateSettingsRepository.save(thePenaltyDateSettings);
	}

	@Transactional
	@Override
	public PenaltyDateSettings findSettings() {
	
		List<PenaltyDateSettings> listPenaltySettings = penaltyDateSettingsRepository.findAll();
		
		if(listPenaltySettings.isEmpty()) {
			PenaltyDateSettings ps = new PenaltyDateSettings();
			ps.setIdPenaltyDateSettings(0);
			ps.setCourtDateCount(0);
			ps.setDoubleDateCount(0);
			return ps;
		}
		return penaltyDateSettingsRepository.findAll().get(0);
	}
	

	

}
