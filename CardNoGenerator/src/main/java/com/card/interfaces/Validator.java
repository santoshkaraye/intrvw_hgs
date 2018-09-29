package com.card.interfaces;

import java.util.List;

public interface Validator {

public List<Integer> visaValidator(int number);
	
	public List<Integer> masterValidator(int number);
	
	public List<Integer> americaValidator(int number);
	
	public List<Integer> discoverValidator(int number);
}
