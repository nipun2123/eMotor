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
import javax.persistence.Transient;

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
	
	@Column(name="username", nullable = false, length=12)
	private String username;
	
	@Column(name="password",nullable = false, length=150)
	private String password;
	
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="policeofficer_idofficer", nullable = false)
	private PoliceOfficer officer;

	@Transient
	private String oldPassword;
	
	@Transient
	private String confirmPassword;
	
	@Transient
	private String tel;




	public Useraccount() {
	
	}
	
	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Useraccount [idUserAccount=" + idUserAccount + ", officer=" + officer + "]";
	}



	
}
