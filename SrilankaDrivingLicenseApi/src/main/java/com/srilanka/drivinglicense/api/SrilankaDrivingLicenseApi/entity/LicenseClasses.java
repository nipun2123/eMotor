package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="licenseclasses")
public class LicenseClasses {

	@Id
	@Column(name="idlicenseclasses", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLicenseClasses;
	
	@Column(name="classfrom")
	private Date classFrom;
	
	@Column(name="classto")
	private Date classTo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="license_idlicense", nullable = false)
	private License license;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vehicleclasses_idvehicleclasses", nullable = false)
	private VehicleClasses vehicleClasses;
	
	
	public LicenseClasses() {
	
	}

	public LicenseClasses(int idLicenseClasses, Date classFrom, Date classTo, License license,
			VehicleClasses vehicleClasses) {
	
		this.idLicenseClasses = idLicenseClasses;
		this.classFrom = classFrom;
		this.classTo = classTo;
		this.license = license;
		this.vehicleClasses = vehicleClasses;
	}

	public int getIdLicenseClasses() {
		return idLicenseClasses;
	}

	public void setIdLicenseClasses(int idLicenseClasses) {
		this.idLicenseClasses = idLicenseClasses;
	}

	public Date getClassFrom() {
		return classFrom;
	}

	public void setClassFrom(Date classFrom) {
		this.classFrom = classFrom;
	}

	public Date getClassTo() {
		return classTo;
	}

	public void setClassTo(Date classTo) {
		this.classTo = classTo;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public VehicleClasses getVehicleClasses() {
		return vehicleClasses;
	}

	public void setVehicleClasses(VehicleClasses vehicleClasses) {
		this.vehicleClasses = vehicleClasses;
	}

	@Override
	public String toString() {
		return "LicenseClasses [idLicenseClasses=" + idLicenseClasses + ", classFrom=" + classFrom + ", classTo="
				+ classTo + ", license=" + license + ", vehicleClasses=" + vehicleClasses + "]";
	}
	
	
}
