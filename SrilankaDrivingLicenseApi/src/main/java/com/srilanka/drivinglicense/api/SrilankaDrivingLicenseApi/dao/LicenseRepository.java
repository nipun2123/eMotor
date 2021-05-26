package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.License;


public interface LicenseRepository extends JpaRepository<License, Integer> {
	
	 @Query("SELECT ls FROM License ls where ls.licenseNo = :licenseNo and ls.nic = :nic") 
	 public License findDrivingLicense(String licenseNo, String nic);
}
