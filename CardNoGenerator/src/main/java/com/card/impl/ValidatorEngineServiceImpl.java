package com.card.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.card.entity.AmericanCard;
import com.card.entity.DiscoverCard;
import com.card.entity.MasterCard;
import com.card.entity.VisaCard;
import com.card.interfaces.Card;
import com.card.interfaces.ValidatorService;

@Component
public class ValidatorEngineServiceImpl implements ValidatorService{

	@Override
	public List<? extends Card> validator(List<? extends Card> cards, String type) {
		
		ExecutorService exe = Executors.newFixedThreadPool(5);
		
		exe.submit(new Task(cards,type));
		exe.shutdown();
		try {
			exe.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return cards;
	}

	
	class Task implements Runnable {

       
        private List<? extends Card> cards;
        private String type;
        private String dateFormat="ddmmyyyy";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);  
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);

        public Task(List<? extends Card> cards, String type) {
            
            this.cards = cards;
            this.type=type;
            
        }

        public void run() {
           for(Card card:cards)
           {
        	  
        	   if(type.equalsIgnoreCase("visa"))
        	   {
        		   VisaCard visa = ((VisaCard)card);
        		   long id= visa.getNumber() ;
        		  if(!Long.toString(id).startsWith("4") || Long.toString(id).length() != 13) {
        			  cards.clear();
        			  break;
        		  }
        			   
        		   visa.setExpiryDate(currentDate);
        	   }else
        	   
        	   if(type.equalsIgnoreCase("master"))
        	   {
        		   MasterCard master = ((MasterCard)card);
        		   long id= master.getNumber() ;
        		  if(!Long.toString(id).startsWith("5") || Long.toString(id).length() != 16) {
        			  cards.clear();
        			  break;
        		  }
        		   
        		   master.setExpiryDate(currentDate);
        	   }else
        	           	   
        	   if(type.equalsIgnoreCase("american"))
        	   {
        		   AmericanCard american = ((AmericanCard)card);
        		   long id= american.getNumber() ;
        		  if(!Long.toString(id).startsWith("37") || Long.toString(id).length() != 15){
        			  cards.clear();
        			  break;
        		  }
        		   
        		   american.setExpiryDate(currentDate);
        	   }else
        	   
        	   if(type.equalsIgnoreCase("discover"))
        	   {
        		   DiscoverCard discover = ((DiscoverCard)card);
        		   long id= discover.getNumber() ;
        		  if(!Long.toString(id).startsWith("6") || Long.toString(id).length() != 16){
        			  cards.clear();
        			  break;
        		  }
        		   
        		   discover.setExpiryDate(currentDate);
        	   }
        	   
           }
           
        }
        
    }

}
