package com.card.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.card.interfaces.Card;

@Entity
@Table(name="DiscoverCard")
public class DiscoverCard implements Card  {

	@Id
	long number;
	
	@Column
	String expiryDate;

	public DiscoverCard(long number)
	{
		this.number=number;
	}
	
	public DiscoverCard()
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
