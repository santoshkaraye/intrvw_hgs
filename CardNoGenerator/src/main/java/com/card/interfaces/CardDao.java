package com.card.interfaces;

import java.util.List;

import com.card.entity.AmericanCard;
import com.card.entity.DiscoverCard;
import com.card.entity.MasterCard;
import com.card.entity.VisaCard;

public interface CardDao<T> {


	public void save(T entity);
	
	public List<AmericanCard> findAllAmericanCards();
	
	public List<DiscoverCard> findAllDiscoverCards();
	
	public List<MasterCard> findAllMasterCards();
	
	public List<VisaCard> findAllVisaCards();

}
