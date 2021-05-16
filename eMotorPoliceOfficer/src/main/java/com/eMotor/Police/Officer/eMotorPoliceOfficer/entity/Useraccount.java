package com.eMotor.Police.Officer.eMotorPoliceOfficer.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="useraccount")
public class Useraccount  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="iduseraccount", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUserAccount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="policeofficer_idofficer", nullable = false)
	private PoliceOfficer officer;

	
	public Useraccount() {
	
	}
	

	public Useraccount(int idUserAccount, PoliceOfficer officer) {
		
		this.idUserAccount = idUserAccount;
		this.officer = officer;
	}


	public int getIdUserAccount() {
		return idUserAccount;
	}


	public void setIdUserAccount(int idUserAccount) {
		this.idUserAccount = idUserAccount;
	}



	public PoliceOfficer getOfficer() {
		return officer;
	}


	public void setOfficer(PoliceOfficer officer) {
		this.officer = officer;
	}


	@Override
	public String toString() {
		return "Useraccount [idUserAccount=" + idUserAccount + ", officer=" + officer + "]";
	}



	
}
