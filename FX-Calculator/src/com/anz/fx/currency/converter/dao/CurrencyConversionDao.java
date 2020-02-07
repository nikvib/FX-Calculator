package com.anz.fx.currency.converter.dao;

import com.anz.fx.currency.converter.data.ConversionMethod;
import com.anz.fx.currency.converter.data.ConversionRate;
import com.anz.fx.currency.converter.data.Currency;

/**
 * Dao class that will get the data from enum holding the data
 * @author Vaibhav
 * @version 1.0
 *
 */
public interface CurrencyConversionDao {
	
	public ConversionRate findCurrencyRateByName(String currencyName);
	
	public Currency findCurrencyByName(String currencyName);
	
	public String findCurrencyContainsAName(String currencyName);
	
	public int getPrecision(String currencyName);
	
	public ConversionMethod getConversionMethod(String inputCurrency, String outputCurrency);

	public Double conversionRateByConversionMethod(String inputCurrency, String outputCurrency, ConversionMethod conversionMethod);

}
