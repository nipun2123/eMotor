package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

public interface UserService {
  
    Useraccount findByUsername(String username);
}