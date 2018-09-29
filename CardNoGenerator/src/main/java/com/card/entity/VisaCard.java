package com.card.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.card.interfaces.Card;

@Entity
@Table(name="VisaCard")
public class VisaCard implements Card {

	@Id
	long number;
	
	@Column
	String expiryDate;

	public VisaCard(long number)
	{
		this.number=number;
	}
	
	public VisaCard()
	{
		
	}
	
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}


	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
