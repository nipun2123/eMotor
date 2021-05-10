package com.eMotor.Driver.eMotorDriver.entity;


import java.time.LocalDateTime;

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
@Table(name="suspendedlicense")
public class SuspendedLicense {

	@Id
	@Column(name="idsuspendedlicense", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSuspendedLicense;
	
	@Column(name="suspendedfrom")
	private LocalDateTime suspendedFrom;
	
	@Column(name="suspendedto")
	private LocalDateTime suspendedTo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driver_iddriver", nullable = false)
	private Driver driver;
	
	
	public SuspendedLicense() {

	} 
	

	public SuspendedLicense(int idSuspendedLicense, LocalDateTime suspendedFrom, LocalDateTime suspendedTo, Driver driver) {

		this.idSuspendedLicense = idSuspendedLicense;
		this.suspendedFrom = suspendedFrom;
		this.suspendedTo = suspendedTo;
		this.driver = driver;
	}

	public int getIdSuspendedLicense() {
		return idSuspendedLicense;
	}

	public void setIdSuspendedLicense(int idSuspendedLicense) {
		this.idSuspendedLicense = idSuspendedLicense;
	}

	public LocalDateTime getsuspendedFrom() {
		return suspendedFrom;
	}

	public void setsuspendedFrom(LocalDateTime suspendedFrom) {
		this.suspendedFrom = suspendedFrom;
	}

	public LocalDateTime getsuspendedTo() {
		return suspendedTo;
	}

	public void setsuspendedTo(LocalDateTime suspendedTo) {
		this.suspendedTo = suspendedTo;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	@Override
	public String toString() {
		return "SuspendedLicense [idSuspendedLicense=" + idSuspendedLicense + ", suspendedFrom=" + suspendedFrom + ", suspendedTo=" + suspendedTo
				+ ", driver=" + driver + "]";
	}
	
	
}
