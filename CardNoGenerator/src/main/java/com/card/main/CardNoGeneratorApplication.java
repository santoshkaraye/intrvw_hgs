package com.card.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.interfaces.Card;
import com.card.interfaces.CardGeneratorService;
import com.card.interfaces.ValidatorService;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.card.impl"})
@EntityScan("com.card.entity")
public class CardNoGeneratorApplication {

	@Autowired
	CardGeneratorService cardService;
	
	@Autowired
	ValidatorService validatorService;
	
	@RequestMapping("/genrator")
	List<? extends Card> generateCard(Integer count,String type)
	{
		
		List<? extends Card> cardList = cardService.generateCard(count, type);
		
		validatorService.validator(cardList,type);
		
		if(cardList != null && cardList.size()!=0)
				cardService.response(cardList);
			
		return cardList;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CardNoGeneratorApplication.class, args);
	}
}
