package com.eMotor.Police.Officer.eMotorPoliceOfficer.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Component
public class ChangePasswordValidator implements Validator {
    @Autowired
    private UseraccountRepository useraccountRepository;
    
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return Useraccount.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Useraccount useraccount = (Useraccount) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "NotEmpty");
    	
        if(!useraccount.getOldPassword().isEmpty()) {
        	Useraccount u = useraccountRepository.findByUsername(useraccount.getUsername());
    
        if(!bCryptPasswordEncoder.matches(useraccount.getOldPassword(), u.getPassword())) {
        	errors.rejectValue("oldPassword", "Wrong.change.password");
        }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(!useraccount.getPassword().isEmpty()) {
        if (useraccount.getPassword().length() < 8 || useraccount.getPassword().length() > 15) {
            errors.rejectValue("password", "Size.change.password");
        }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty");
        if(!useraccount.getPassword().isEmpty() && !useraccount.getConfirmPassword().isEmpty()) {
        if (!useraccount.getConfirmPassword().equals(useraccount.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.change.passwordConfirm");
        }
        }
    }
}