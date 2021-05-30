package com.eMotor.Police.Department.eMotorPoliceDepartment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="departmentaccount")
public class DepartmentAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddepartmentaccount", nullable = false)
	private int idDepartmentAccount;
	
	
	@Column(name="username", nullable = false, length=12)
	private String username;
	
	@Column(name="password",nullable = false, length=150)
	private String password;
	
	@Transient
	private String oldPassword;
	
	@Transient
	private String confirmPassword;


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

	public DepartmentAccount(int idDepartmentAccount, String username, String password) {
		this.idDepartmentAccount = idDepartmentAccount;
		this.username = username;
		this.password = password;
	}
	
	public DepartmentAccount() {

	}
	
	
	public int getIdDepartmentAccount() {
		return idDepartmentAccount;
	}

	public void setIdDepartmentAccount(int idDepartmentAccount) {
		this.idDepartmentAccount = idDepartmentAccount;
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
		return "DepartmentAccount [idDepartmentAccount=" + idDepartmentAccount + ", username=" + username
				+ ", password=" + password + "]";
	}

	
}
