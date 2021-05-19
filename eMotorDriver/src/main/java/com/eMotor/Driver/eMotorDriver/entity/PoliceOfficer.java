package com.eMotor.Driver.eMotorDriver.entity;


import java.io.Serializable;

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
@Table(name="policeofficer")
public class PoliceOfficer  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpoliceofficer", nullable = false)
	private int idPoliceOfficer;
	
	
	@Column(name="officerno",nullable = false, length=20,unique=true)
	private String officerNo;
	
	@Column(name="fname",nullable = false, length=45)
	private String fName;
	
	@Column(name="lname",nullable = false, length=45)
	private String lName;
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="policestation_idstation", nullable = false)
	private PoliceStation station;
	
	@javax.persistence.Transient
	private String policeStationName;
	
	@javax.persistence.Transient
	private String oldPoliceOfficerNic;
	
	@javax.persistence.Transient
	private String oldPoliceOfficerNo;



	public PoliceOfficer() {
	}
	
	public PoliceOfficer(int idPoliceOfficer,  String officerNo, String fName, String lName, PoliceStation station) {
		this.idPoliceOfficer = idPoliceOfficer;
		this.officerNo = officerNo;
		this.fName = fName;
		this.lName = lName;
		this.station = station;
	}

	public int getIdPoliceOfficer() {
		return idPoliceOfficer;
	}

	public void setIdPoliceOfficer(int idPoliceOfficer) {
		this.idPoliceOfficer = idPoliceOfficer;
	}


	public String getOfficerNo() {
		return officerNo;
	}

	public void setOfficerNo(String officerNo) {
		this.officerNo = officerNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public PoliceStation getStation() {
		return station;
	}

	public void setStation(PoliceStation station) {
		this.station = station;
	}
	
	public String getPoliceStationName() {
		return policeStationName;
	}

	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}

	public String getOldPoliceOfficerNic() {
		return oldPoliceOfficerNic;
	}

	public void setOldPoliceOfficerNic(String oldPoliceOfficerNic) {
		this.oldPoliceOfficerNic = oldPoliceOfficerNic;
	}
	
	public String getOldPoliceOfficerNo() {
		return oldPoliceOfficerNo;
	}

	public void setOldPoliceOfficerNo(String oldPoliceOfficerNo) {
		this.oldPoliceOfficerNo = oldPoliceOfficerNo;
	}

	@Override
	public String toString() {
		return "PoliceOfficer [idPoliceOfficer=" + idPoliceOfficer + ", officerNo=" + officerNo + ", fName=" + fName
				+ ", lName=" + lName + ", station=" + station + ", policeStationName=" + policeStationName
				+ ", oldPoliceOfficerNic=" + oldPoliceOfficerNic + ", oldPoliceOfficerNo=" + oldPoliceOfficerNo + "]";
	}

	

}
