package com.card.interfaces;

import java.util.List;

public interface CardGeneratorService {

	
	public  List<? extends Card> generateCard(int count,String type);
	
	public void response(List<? extends Card> cardList);
	
}
