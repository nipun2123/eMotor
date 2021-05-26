package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UseraccountRepository userRepository;
    

    @Override
    public Useraccount findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}