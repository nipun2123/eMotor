package com.eMotor.Driver.eMotorDriver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fineamount")
public class FineAmount {

	@Id
	@Column(name="idfineamount", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFineAmount;
	
	public FineAmount() {
		
	}
	
	public FineAmount(int idFineAmount, double amount) {
		this.idFineAmount = idFineAmount;
		this.amount = amount;
	}
	
	@Column(name="amount", nullable = false)
	private double amount;

	public int getIdFineAmount() {
		return idFineAmount;
	}

	public void setIdFineAmount(int idFineAmount) {
		this.idFineAmount = idFineAmount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FineAmount [idFineAmount=" + idFineAmount + ", amount=" + amount + "]";
	}

	
	
	
}
