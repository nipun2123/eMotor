package com.eMotor.Police.Officer.eMotorPoliceOfficer.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Component
public class ForgotPasswordValidator implements Validator {
    @Autowired
    private UseraccountRepository useraccountRepository;
    

    @Override
    public boolean supports(Class<?> aClass) {
        return Useraccount.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Useraccount useraccount = (Useraccount) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "NotEmpty");
    	
        if(!useraccount.getUsername().isEmpty() && !useraccount.getTel().isEmpty()) {
        	Useraccount u = useraccountRepository.findByUsername(useraccount.getUsername());
    
        	if(u==null) {
        		errors.rejectValue("username", "Wrong.forgot.username");
        	}else {
        		
        		if(!u.getOfficer().getTel().equals(useraccount.getTel())) {
        			errors.rejectValue("tel", "Wrong.forgot.tel");
        		}
        	}
        }

       
        
    }
}