package com.card.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.card.interfaces.Card;

@Entity
@Table(name="AmericanCard")
public class AmericanCard implements Card  {

	@Id
	long number;
	
	@Column
	Date expiryDate;

	public AmericanCard(long number)
	{
		this.number=number;
	}
	
	public AmericanCard()
	{
		
	}
	
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
