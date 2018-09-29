package com.card.interfaces;

import java.util.Set;

public interface ValidatorService {
	public <T> boolean cardValidator(Set<T> cardList);

}
