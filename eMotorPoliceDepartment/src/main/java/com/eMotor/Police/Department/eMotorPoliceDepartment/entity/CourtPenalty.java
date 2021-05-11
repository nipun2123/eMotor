package com.eMotor.Police.Department.eMotorPoliceDepartment.entity;

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
@Table(name="courtpenalty")
public class CourtPenalty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcourtpenalty", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCourtPenalty;
	
	@Column(name="penalty", nullable = false)
	private String penalty;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="useraccount_idaccount", nullable = false)
	private UserAccount useraccount;

	
	public CourtPenalty() {
		
	}
	
	public CourtPenalty(int idCourtPenalty, String penalty, UserAccount useraccount) {
	
		this.idCourtPenalty = idCourtPenalty;
		this.penalty = penalty;
		this.useraccount = useraccount;
	}

	public int getIdCourtPenalty() {
		return idCourtPenalty;
	}

	public void setIdCourtPenalty(int idCourtPenalty) {
		this.idCourtPenalty = idCourtPenalty;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	public UserAccount getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.useraccount = useraccount;
	}

	@Override
	public String toString() {
		return "CourtPenalty [idCourtPenalty=" + idCourtPenalty + ", penalty=" + penalty + ", useraccount="
				+ useraccount + "]";
	}
	
	
	
}
