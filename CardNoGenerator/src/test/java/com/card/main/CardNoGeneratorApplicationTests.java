package com.card.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.card.interfaces.Card;
import com.card.interfaces.CardGeneratorService;
import com.card.interfaces.ValidatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardNoGeneratorApplicationTests {

	@Autowired
	CardGeneratorService cardService;
	
	@Test
	public void generatorVisa() {
		List<? extends Card> visaList = cardService.generateCard(10, "visa");
		
		if(visaList == null || visaList.isEmpty())
			assertNotNull("Visa list is empty or null", visaList);
		
		if(visaList.size()!=10)
			assertTrue("Expected card numbers not generated", false);
		
	}
	
	@Test
	public void generatorMaster() {
		List<? extends Card> masterList = cardService.generateCard(10, "master");
		
		if(masterList == null || masterList.isEmpty())
			assertNotNull("Master list is empty or null", masterList);
		
		if(masterList.size()!=10)
			assertTrue("Expected card numbers not generated", false);
		
	}
	
	@Test
	public void generatorAmerican() {
		List<? extends Card> americanList = cardService.generateCard(10, "american");
		
		if(americanList == null || americanList.isEmpty())
			assertNotNull("American list is empty or null", americanList);
		
		if(americanList.size()!=10)
			assertTrue("Expected card numbers not generated", false);
		
	}
	
	@Test
	public void generatorDiscover() {
		List<? extends Card> discoverList = cardService.generateCard(10, "discover");
		
		if(discoverList == null || discoverList.isEmpty())
			assertNotNull("Discover list is empty or null", discoverList);
		
		if(discoverList.size()!=10)
			assertTrue("Expected card numbers not generated", false);
		
	}

}
