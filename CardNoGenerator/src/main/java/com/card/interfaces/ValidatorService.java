package com.card.interfaces;

import java.util.List;

public interface ValidatorService {

	public List<? extends Card> validator(List<? extends Card> cards, String type);

}
