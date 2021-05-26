package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.dao.LicenseClassesRepository;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.dao.LicenseRepository;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.DrivingLicense;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.DrivingLicenseClass;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.License;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.LicenseClasses;

@Transactional
@Service
public class DrivingLicenseService {

	
	@Autowired
	LicenseRepository licenseRepository;
	
	@Autowired
	LicenseClassesRepository licenseClassesRepository;
	
	public DrivingLicense findDrivingLicense(String licenseNo, String nic) {
		
			
		
		License theLicense = licenseRepository.findDrivingLicense(licenseNo, nic);
		
		List<LicenseClasses> theClasses = licenseClassesRepository.findDrivingLicenseClasses(theLicense);
		
		DrivingLicense theDrivingLicense = new DrivingLicense();
		
		theDrivingLicense.setLicenseNo(theLicense.getLicenseNo());
		theDrivingLicense.setLicenseType(theLicense.getLicenseType());
		theDrivingLicense.setIssueDate(theLicense.getIssueDate());
		theDrivingLicense.setExpireDate(theLicense.getExpireDate());
		theDrivingLicense.setNic(theLicense.getNic());
		theDrivingLicense.setName(theLicense.getName());
		theDrivingLicense.setAddress(theLicense.getAddress());
		theDrivingLicense.setDob(theLicense.getDob());
		theDrivingLicense.setBloodGroup(theLicense.getBloodgroup());
		
		List<DrivingLicenseClass> drivingLicenseClasses = new ArrayList<DrivingLicenseClass>();
		
		for(LicenseClasses liceseClass: theClasses) {
			
			DrivingLicenseClass theDrivingLicenseClass = new DrivingLicenseClass();
			
			theDrivingLicenseClass.setVehicleClass(liceseClass.getVehicleClasses().getVehicleClass());
			theDrivingLicenseClass.setClassValidFrom(liceseClass.getClassFrom());
			theDrivingLicenseClass.setClassValidTo(liceseClass.getClassTo());
			
			drivingLicenseClasses.add(theDrivingLicenseClass);
			
		}
		
		
		theDrivingLicense.setDrivingLicenseClasses(drivingLicenseClasses);
		
		return theDrivingLicense;
	}
}
