package com.eMotor.Police.Department.eMotorPoliceDepartment.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.PoliceOfficerRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;

@Component
public class PoliceOfficerValidator implements Validator {

	@Autowired 
	PoliceOfficerRepository policeOfficerRepository;
	
    @Override
    public boolean supports(Class<?> aClass) {
        return PoliceOfficer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	PoliceOfficer officer = (PoliceOfficer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nic", "NotEmpty");
        
        if(!officer.getNic().isEmpty()) {
        	
        	if(officer.getOldPoliceOfficerNic().isEmpty()) {
        		
        		if (policeOfficerRepository.findByNIC(officer.getNic()).isPresent()) {
        			errors.rejectValue("nic", "Duplicate.policeStation.policeOfficer");
           
        		}
        	}else {
        		if(!officer.getOldPoliceOfficerNic().equalsIgnoreCase(officer.getNic())) {
        			
        			if (policeOfficerRepository.findByNIC(officer.getNic()).isPresent()) {
            			errors.rejectValue("nic", "Duplicate.policeStation.policeOfficer");
               
            		}
        		}
        	}
        
        }
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officerNo", "NotEmpty");
        
        if(!officer.getOfficerNo().isEmpty()) {
        	
        	if(officer.getOldPoliceOfficerNo().isEmpty()) {
        		
        		if (policeOfficerRepository.findByOfficerNo(officer.getOfficerNo()).isPresent()) {
        			errors.rejectValue("officerNo", "Duplicate.policeStation.policeOfficer");
           
        		}
        	}else {
        		if(!officer.getOldPoliceOfficerNo().equalsIgnoreCase(officer.getOfficerNo())) {
        			
        			if (policeOfficerRepository.findByOfficerNo(officer.getOfficerNo()).isPresent()) {
            			errors.rejectValue("officerNo", "Duplicate.policeStation.policeOfficer");
               
            		}
        		}
        	}
        
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "NotEmpty");
        
        
        if(!officer.getTel().isEmpty()) {
        if (officer.getTel().length() != 10) {
            errors.rejectValue("tel", "Size.policeStationEntity.tel");
        }
        }
        
        
       
    }
}