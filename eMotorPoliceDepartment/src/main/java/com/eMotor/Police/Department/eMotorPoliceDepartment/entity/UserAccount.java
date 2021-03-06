package com.eMotor.Police.Department.eMotorPoliceDepartment.entity;

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
public class UserAccount  implements Serializable{

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

	
	public UserAccount() {
	
	}
	

	public UserAccount(int idUserAccount, String username, String password, PoliceOfficer officer) {
		
		this.idUserAccount = idUserAccount;
		this.username = username;
		this.password = password;
		this.officer = officer;
	}


	public int getIdUserAccount() {
		return idUserAccount;
	}


	public void setIdUserAccount(int idUserAccount) {
		this.idUserAccount = idUserAccount;
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


	public PoliceOfficer getOfficer() {
		return officer;
	}


	public void setOfficer(PoliceOfficer officer) {
		this.officer = officer;
	}


	@Override
	public String toString() {
		return "UserAccount [idUserAccount=" + idUserAccount + ", username=" + username + ", password=" + password
				+ ", officer=" + officer + "]";
	}
	
	
	
}
