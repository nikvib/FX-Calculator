package com.anz.fx.currency.converter.service;

/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * Service interface to calculate currency rate 
 *
 */
public interface CurrencyConversionService {
	
	public String calculateCoversionRate(String inputCurrency, String outputCurrency, String amount);

}
