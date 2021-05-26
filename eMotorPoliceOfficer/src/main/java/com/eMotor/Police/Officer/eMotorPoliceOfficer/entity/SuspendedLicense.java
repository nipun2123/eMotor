package com.eMotor.Police.Officer.eMotorPoliceOfficer.entity;


import java.io.Serializable;
import java.sql.Date;
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
public class SuspendedLicense  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idsuspendedlicense", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSuspendedLicense;
	
	@Column(name="suspendedfrom")
	private Date suspendedFrom;
	
	@Column(name="suspendedto")
	private Date suspendedTo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driver_iddriver", nullable = false)
	private Driver driver;
	
	
	public SuspendedLicense() {

	} 
	

	public SuspendedLicense(int idSuspendedLicense, Date suspendedFrom, Date suspendedTo, Driver driver) {

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

	public Date getsuspendedFrom() {
		return suspendedFrom;
	}

	public void setsuspendedFrom(Date suspendedFrom) {
		this.suspendedFrom = suspendedFrom;
	}

	public Date getsuspendedTo() {
		return suspendedTo;
	}

	public void setsuspendedTo(Date suspendedTo) {
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
