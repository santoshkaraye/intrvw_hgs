package com.card.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.card.entity.AmericanCard;
import com.card.entity.DiscoverCard;
import com.card.entity.MasterCard;
import com.card.entity.VisaCard;
import com.card.interfaces.Card;
import com.card.interfaces.ValidatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardNoValidatorTest {
	
	@Autowired
	ValidatorService validatorService;
	
	@Test
	public void visaValidator()
	{
		List<VisaCard> visaList = new ArrayList<VisaCard>();
		List<? extends Card> visaOutList; 
		
		for(int i=0;i<10;i++)
		{
			VisaCard card= new VisaCard();
			
			card.setNumber(4000000000000L+i);
			
			visaList.add(card);
		}
		
		
		visaOutList = validatorService.validator(visaList, "visa");
		
		if(visaOutList == null || visaOutList.isEmpty())
			assertNotNull("Visa list is found invalid", visaOutList);
		
		
		for(Card card: visaOutList )
		{
			if(((VisaCard)card).getExpiryDate() ==null || ((VisaCard)card).getExpiryDate().isEmpty())
			{
				assertTrue("expiry date not generated for valid card", false);
				break;
			}
		}
		
			VisaCard card= new VisaCard();
			card.setNumber(000000);
			visaList.add(card);
		
			card = new VisaCard();
			card.setNumber(20000000000000000L);
			visaList.add(card);
			
			card = new VisaCard();
			card.setNumber(40000000000000000L);
			visaList.add(card);
			
		
		visaOutList = validatorService.validator(visaList, "visa");
		
		if(visaOutList != null && !visaOutList.isEmpty())
			assertTrue("invalid card not checked", false);
		
	}
	
	
	@Test
	public void masterValidator()
	{
		List<MasterCard> masterList = new ArrayList<MasterCard>();
		List<? extends Card> matserOutList; 
		
		for(int i=0;i<10;i++)
		{
			MasterCard card= new MasterCard();
			
			card.setNumber(5000000000000000L+i);
			
			masterList.add(card);
		}
		
		
		matserOutList = validatorService.validator(masterList, "master");
		
		if(matserOutList == null || matserOutList.isEmpty())
			assertNotNull("Visa list is found invalid", matserOutList);
		
		
		for(Card card: matserOutList )
		{
			if(((MasterCard)card).getExpiryDate() ==null || ((MasterCard)card).getExpiryDate().isEmpty())
			{
				assertTrue("expiry date not generated for valid card", false);
				break;
			}
		}
		
			MasterCard card= new MasterCard();
			card.setNumber(000000);
			masterList.add(card);
		
			card = new MasterCard();
			card.setNumber(20000000000000000L);
			masterList.add(card);
			
			card = new MasterCard();
			card.setNumber(40000000000000000L);
			masterList.add(card);
			
		
			matserOutList = validatorService.validator(masterList, "master");
		
		if(matserOutList != null && !matserOutList.isEmpty())
			assertTrue("invalid card not checked", false);
		
	}
	
	
	@Test
	public void discoverValidator()
	{
		List<DiscoverCard> discoverList = new ArrayList<DiscoverCard>();
		List<? extends Card> discoverOutList; 
		
		for(int i=0;i<10;i++)
		{
			DiscoverCard card= new DiscoverCard();
			
			card.setNumber(60000000000000000L+i);
			
			discoverList.add(card);
		}
		
		
		discoverOutList = validatorService.validator(discoverList, "discover");
		
		if(discoverOutList == null || discoverOutList.isEmpty())
			assertNotNull("Visa list is found invalid", discoverOutList);
		
		
		for(Card card: discoverOutList )
		{
			if(((DiscoverCard)card).getExpiryDate() ==null || ((DiscoverCard)card).getExpiryDate().isEmpty())
			{
				assertTrue("expiry date not generated for valid card", false);
				break;
			}
		}
		
			DiscoverCard card= new DiscoverCard();
			card.setNumber(000000);
			discoverList.add(card);
		
			card = new DiscoverCard();
			card.setNumber(20000000000000000L);
			discoverList.add(card);
			
			card = new DiscoverCard();
			card.setNumber(40000000000000000L);
			discoverList.add(card);
			
		
			discoverOutList = validatorService.validator(discoverList, "discover");
		
		if(discoverOutList != null && !discoverOutList.isEmpty())
			assertTrue("invalid card not checked", false);
		
	}
	
	
	@Test
	public void americanValidator()
	{
		List<AmericanCard> americanList = new ArrayList<AmericanCard>();
		List<? extends Card> americanOutList; 
		
		for(int i=0;i<10;i++)
		{
			AmericanCard card= new AmericanCard();
			
			card.setNumber(60000000000000000L+i);
			
			americanList.add(card);
		}
		
		
		americanOutList = validatorService.validator(americanList, "american");
		
		if(americanOutList == null || americanOutList.isEmpty())
			assertNotNull("Visa list is found invalid", americanOutList);
		
		
		for(Card card: americanOutList )
		{
			if(((AmericanCard)card).getExpiryDate() ==null || ((AmericanCard)card).getExpiryDate().isEmpty())
			{
				assertTrue("expiry date not generated for valid card", false);
				break;
			}
		}
		
			AmericanCard card= new AmericanCard();
			card.setNumber(000000);
			americanList.add(card);
		
			card = new AmericanCard();
			card.setNumber(20000000000000000L);
			americanList.add(card);
			
			card = new AmericanCard();
			card.setNumber(40000000000000000L);
			americanList.add(card);
			
		
			americanOutList = validatorService.validator(americanList, "american");
		
		if(americanOutList != null && !americanOutList.isEmpty())
			assertTrue("invalid card not checked", false);
		
	}

	

}
