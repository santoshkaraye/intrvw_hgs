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
	public List<AmericanCard> findAllAmericanCards() {
		return entityManager.createQuery("FROM AmericanCard v ORDER BY v.number DESC").getResultList();
		 
	}
	
	@Override
	public List<DiscoverCard> findAllDiscoverCards() {
		return  entityManager.createQuery("FROM DiscoverCard v ORDER BY v.number DESC").getResultList();
		
	}
	
	@Override
	public List<MasterCard> findAllMasterCards() {
		return entityManager.createQuery("FROM MasterCard v ORDER BY v.number DESC").getResultList();
		
	}
	
	@Override
	public List<VisaCard> findAllVisaCards() {
		return entityManager.createQuery("FROM VisaCard v ORDER BY v.number DESC").getResultList();
		
	}

	@Override
	@Transactional
	public void save(T entity) {
		
					entityManager.persist(entity);
	}


}
