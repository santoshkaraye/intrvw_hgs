package com.card.interfaces;

import java.util.List;

import com.card.entity.AmericanCard;
import com.card.entity.DiscoverCard;
import com.card.entity.MasterCard;
import com.card.entity.VisaCard;


public interface Generator {

	public List<VisaCard> visaGenerate(int number);
	
	public List<MasterCard> masterGenerate(int number);
	
	public List<AmericanCard> americaGenerate(int number);
	
	public List<DiscoverCard> discoverGenerate(int number);
	
	public <T> void response(T entity);
	
}
