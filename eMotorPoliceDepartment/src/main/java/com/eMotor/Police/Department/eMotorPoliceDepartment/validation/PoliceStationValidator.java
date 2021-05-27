package com.eMotor.Police.Department.eMotorPoliceDepartment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceStationRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;

@Component
public class PoliceStationValidator implements Validator {

	@Autowired
	PoliceStationRepository policeStationRepository;
	
    @Override
    public boolean supports(Class<?> aClass) {
        return PoliceStation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	PoliceStation station = (PoliceStation) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "policeStation", "NotEmpty");
        
        if(!station.getPoliceStation().isEmpty()) {
        	
        	if(station.getOldPoliceStation().isEmpty()) {
        		
        if (policeStationRepository.findByPoliceStation(station.getPoliceStation()).isPresent()) {
            errors.rejectValue("policeStation", "Duplicate.policeStationEntity.policeStation");
           
        }
        	}else {
        		if(!station.getOldPoliceStation().equalsIgnoreCase(station.getPoliceStation())) {
        			if (policeStationRepository.findByPoliceStation(station.getPoliceStation()).isPresent()) {
        	            errors.rejectValue("policeStation", "Duplicate.policeStationEntity.policeStation");
        	           
        	        }
        		}
        	}
        
        
        
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oic", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oicOffice", "NotEmpty");
        
        if(!station.getOicOffice().isEmpty()) {
        if (station.getOicOffice().length() != 10) {
            errors.rejectValue("oicOffice", "Size.policeStationEntity.tel");
        }
        }
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oicMobile", "NotEmpty");
        
        if(!station.getOicMobile().isEmpty()) {
        if (station.getOicMobile().length() != 10) {
            errors.rejectValue("oicMobile", "Size.policeStationEntity.tel");
        }
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "general", "NotEmpty");
        
        if(!station.getGeneral().isEmpty()) {
        if (station.getGeneral().length() != 10) {
            errors.rejectValue("general", "Size.policeStationEntity.tel");
        }
        } 
       
    }
}