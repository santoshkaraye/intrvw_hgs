package com.card.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.card.entity.AmericanCard;
import com.card.entity.DiscoverCard;
import com.card.entity.MasterCard;
import com.card.entity.VisaCard;
import com.card.interfaces.CardDao;
import com.card.interfaces.Generator;

@Component
public class CCGenerationEngine implements Generator {

	@Autowired
	CardDao dao;
	
	List<VisaCard> visaList;
	
	List<MasterCard> masterList;
	
	List<DiscoverCard> discoverList;
	
	List<AmericanCard> americanList;
	
	@Override
		public List<VisaCard> visaGenerate(int number) {
			
			visaList= (List<VisaCard>) dao.findAllVisaCards();
			
			long id;
			
		if(visaList.size() ==0)
		{
			id = 4000000000000L;
		}else
		{
			id = visaList.get(0).getNumber();
		}
			
		visaList = new ArrayList<VisaCard>();
			for(int i=0;i<number;i++)
			{
				VisaCard visa= new VisaCard(++id); 
				visaList.add(visa);
			}
			
			return visaList;
	}

	@Override
		public List<MasterCard> masterGenerate(int number) {
			masterList= (List<MasterCard>) dao.findAllMasterCards();
			
			long id;
			
		if(masterList.size() ==0)
		{
			id = 5000000000000000L;
		}else
		{
			id = masterList.get(0).getNumber();
		}
			
		masterList = new ArrayList<MasterCard>();
			for(int i=0;i<number;i++)
			{
				MasterCard master= new MasterCard(++id); 
				masterList.add(master);
			}
			
			return masterList;
		}

	@Override
		public List<AmericanCard> americaGenerate(int number) {
			americanList= (List<AmericanCard>) dao.findAllAmericanCards();
			
			long id;
			
		if(americanList.size() ==0)
		{
			id = 370000000000000L;
		}else
		{
			id = americanList.get(0).getNumber();
		}
			
		americanList = new ArrayList<AmericanCard>();
			for(int i=0;i<number;i++)
			{
				AmericanCard american= new AmericanCard(++id); 
				americanList.add(american);
			}
			
			return americanList;
	}

	@Override
	public List<DiscoverCard> discoverGenerate(int number) {
		discoverList= (List<DiscoverCard>) dao.findAllDiscoverCards();
		
		long id;
		
	if(discoverList.size() ==0)
	{
		id = 6000000000000000L;
	}else
	{
		id = discoverList.get(0).getNumber();
	}
		
	discoverList = new ArrayList<DiscoverCard>();
		for(int i=0;i<number;i++)
		{
			DiscoverCard discover= new DiscoverCard(++id); 
			discoverList.add(discover);
		}
		
		return discoverList;
}

	@Override
	public <T> void response(T entity) {
		dao.save(entity);
		
	}

}
