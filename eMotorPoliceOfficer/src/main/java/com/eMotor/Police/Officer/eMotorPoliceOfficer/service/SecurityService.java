package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;
public interface SecurityService {
	
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}