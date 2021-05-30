package com.eMotor.Police.Department.eMotorPoliceDepartment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.DepartmentAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;

@Component
public class ChangePasswordValidator implements Validator {
    @Autowired
    private DepartmentAccountRepository departmentAccountRepository;
    
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return DepartmentAccount.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	DepartmentAccount departmentAccount = (DepartmentAccount) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "NotEmpty");
    	
        if(!departmentAccount.getOldPassword().isEmpty()) {
        DepartmentAccount da = departmentAccountRepository.findByUsername(departmentAccount.getUsername());
    
        if(!bCryptPasswordEncoder.matches(departmentAccount.getOldPassword(), da.getPassword())) {
        	errors.rejectValue("oldPassword", "Wrong.change.password");
        }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(!departmentAccount.getPassword().isEmpty()) {
        if (departmentAccount.getPassword().length() < 8 || departmentAccount.getPassword().length() > 15) {
            errors.rejectValue("password", "Size.change.password");
        }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty");
        if(!departmentAccount.getPassword().isEmpty() && !departmentAccount.getConfirmPassword().isEmpty()) {
        if (!departmentAccount.getConfirmPassword().equals(departmentAccount.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.change.passwordConfirm");
        }
        }
    }
}