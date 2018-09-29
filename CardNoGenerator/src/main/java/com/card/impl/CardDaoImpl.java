package com.card.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.card.entity.AmericanCard;
import com.card.entity.DiscoverCard;
import com.card.entity.MasterCard;
import com.card.entity.VisaCard;
import com.card.interfaces.CardDao;

@Component
public class CardDaoImpl<T> implements CardDao<T>{

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AmericanCard> findAllAmericanCards() {
		List<AmericanCard> americanCards= entityManager.createQuery("FROM AmericanCard v ORDER BY v.number DESC").getResultList();
		return americanCards;
	}
	
	@Override
	public List<DiscoverCard> findAllDiscoverCards() {
		List<DiscoverCard> cards= entityManager.createQuery("FROM DiscoverCard v ORDER BY v.number DESC").getResultList();
		return cards;
	}
	
	@Override
	public List<MasterCard> findAllMasterCards() {
		List<MasterCard> cards= entityManager.createQuery("FROM MasterCard v ORDER BY v.number DESC").getResultList();
		return cards;
	}
	
	@Override
	public List<VisaCard> findAllVisaCards() {
		List<VisaCard> cards= entityManager.createQuery("FROM VisaCard v ORDER BY v.number DESC").getResultList();
		return cards;
	}

	@Override
	@Transactional
	public void save(T entity) {
		
					entityManager.persist(entity);
	}


	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	


}
