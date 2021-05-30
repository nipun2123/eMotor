package com.eMotor.Police.Department.eMotorPoliceDepartment.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class SpotPenaltyValidator implements Validator {

	
    @Override
    public boolean supports(Class<?> aClass) {
        return Penalty.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "penaltyEnglish", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "penaltySinhala", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "penaltyTamil", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty");
        
       
    }
}