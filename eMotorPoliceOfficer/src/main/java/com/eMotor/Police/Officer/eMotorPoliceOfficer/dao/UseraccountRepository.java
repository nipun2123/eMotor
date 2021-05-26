package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Useraccount;

public interface UseraccountRepository extends JpaRepository<Useraccount, Integer> {

	Useraccount findByUsername(String username);
}
