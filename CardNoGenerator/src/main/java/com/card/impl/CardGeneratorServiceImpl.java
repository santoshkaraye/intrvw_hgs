package com.card.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.card.interfaces.Card;
import com.card.interfaces.CardDao;
import com.card.interfaces.CardGeneratorService;
import com.card.interfaces.Generator;

@Component
public class CardGeneratorServiceImpl implements CardGeneratorService {

	@Autowired
	Generator generator;
	
	@Autowired
	CardDao dao;
	
	@Override
	public  List<? extends Card> generateCard(int count, String type) {

		if(type.equalsIgnoreCase("Master"))
			return	(List<? extends Card>) generator.masterGenerate(count);
		
		if(type.equalsIgnoreCase("American"))
			return	(List<? extends Card>) generator.americaGenerate(count);
		
		if(type.equalsIgnoreCase("Discover"))
			return	(List<? extends Card>) generator.discoverGenerate(count);
		
		if(type.equalsIgnoreCase("Visa"))
			return	(List<? extends Card>)generator.visaGenerate(count);
		
		
		return null;
	}

	
	public <T> boolean cardValidator(Set<T> cardList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void response(List<? extends Card> cardList) {
		
		for(Card card: cardList)
		{
			dao.save(card);
		}
		
	}

}
