package com.card.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
			return generator.masterGenerate(count);
		
		if(type.equalsIgnoreCase("American"))
			return generator.americaGenerate(count);
		
		if(type.equalsIgnoreCase("Discover"))
			return generator.discoverGenerate(count);
		
		if(type.equalsIgnoreCase("Visa"))
			return generator.visaGenerate(count);
		
		
		return new ArrayList<>();
	}

	

	@Override
	public void response(List<? extends Card> cardList) {
		
		for(Card card: cardList)
		{
			dao.save(card);
		}
		
	}

}
