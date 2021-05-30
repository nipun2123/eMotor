package com.eMotor.Police.Officer.eMotorPoliceOfficer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.dao.UseraccountRepository;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.encription.Encrypt;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UseraccountRepository userRepository;
    
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    

    @Override
    public Useraccount findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


	@Override
	public Useraccount changePassword(Useraccount useraccount) {
		Useraccount loggedUseraccount = userRepository.findByUsername(useraccount.getUsername());
		
		loggedUseraccount.setPassword(bCryptPasswordEncoder.encode(useraccount.getPassword()));
		
		return userRepository.save(loggedUseraccount);
		
	}


	@Override
	public Useraccount forgetPassword(Useraccount useraccount) {
		
		System.out.println(useraccount.getTel());
		Useraccount loggedUseraccount = userRepository.findByUsername(useraccount.getUsername());
		
		String pass = Encrypt.encript(loggedUseraccount.getOfficer().getOfficerNo());
		System.out.println(pass);
		loggedUseraccount.setPassword(bCryptPasswordEncoder.encode(pass));
		
		Useraccount savedAccount = userRepository.save(loggedUseraccount);
		
		
		String tel = savedAccount.getOfficer().getTel().substring(1);
		
		String msg = "Dear police officer, \n Your account password is "+ pass+" \n You can change it by login into the system.";
		
		final String uri = "https://app.notify.lk/api/v1/send?user_id=13387&api_key=QFHLNDXbpawpt5oQys3d&sender_id=NotifyDEMO&to=+94"+tel+"&message="+msg;

		 RestTemplate restTemplate = new RestTemplate();
		 
		restTemplate.getForObject(uri, Map.class);
		
		return savedAccount;
	}
}