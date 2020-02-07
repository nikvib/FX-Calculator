package com.anz.fx.currency.converter.dao;

import com.anz.fx.currency.converter.data.ConversionMethod;
import com.anz.fx.currency.converter.data.ConversionRate;
import com.anz.fx.currency.converter.data.Currency;


/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * Implementation of CurrencyConversionDao to fetch data
 *
 */
public class CurrencyConversionDaoImpl implements CurrencyConversionDao {
	
	  
	  //Singleton to make sure only one instance is created of DAO throughout 	   
	  private static CurrencyConversionDaoImpl instance = null;
	   
	  private CurrencyConversionDaoImpl() {	      
	  }

	   public static CurrencyConversionDaoImpl getInstance() {
	      if(instance == null) {
	         instance = new CurrencyConversionDaoImpl();
	      }
	      return instance;
	   }
	   //End Singleton

	/**
	 * 
	 * @param currencyName
	 * @return enum of the currency name conversion 
	 */
	@Override
	public  ConversionRate findCurrencyRateByName(String currencyName) {
		for(ConversionRate type:ConversionRate.values()) {
			if(type.name().equalsIgnoreCase(currencyName)) {
				return type;
			}
		}
		//if there is no enum (currency conversion) present for given name then return null
		return null;
	}
	
	/**
	 * 
	 * @param currencyName
	 * @return enum of the currency
	 */
	 @Override
	public Currency findCurrencyByName(String currencyName) {
		for(Currency type:Currency.values()) {
			if(type.name().equalsIgnoreCase(currencyName)) {
				return type;
			}
		}
		//if there is no currency present for given name then return null
		return null;
	}
	
	/**
	 * 
	 * @param currencyName
	 * @return enum of the currency name conversion 
	 */
	 @Override
	public String findCurrencyContainsAName(String currencyName) {
		for(ConversionRate type:ConversionRate.values()) {
			if(type.name().contains(currencyName)) {
				//replace the currency name with blank string this will give cross conversion currency
				String replacedString = type.name().replace(currencyName, "");
				return replacedString;
			}
		}
		//if there is no enum (currency conversion) present that contains given name then return null
		return null;
	}
	
	/**
	 * 
	 * @param currencyName
	 * @return precision for a given currency
	 */
	 @Override
	public int getPrecision(String currencyName) {
		Currency currency = findCurrencyByName(currencyName);
		if(currency!=null) {
			return currency.getPrecision();
		}
		return 0;		
	}
	
	 /**
	  * 
	  * @param inputCurrency
	  * @param outputCurrency
	  * @return ConversionMethod to convert
	  */
	public ConversionMethod getConversionMethod(String inputCurrency, String outputCurrency) {
		if(inputCurrency.equalsIgnoreCase(outputCurrency)) {
			return ConversionMethod.EQUALS;
		}
		ConversionRate directCurrencyName = findCurrencyRateByName(inputCurrency+outputCurrency);
		//when it is not null that means direct conversion is available
		if(directCurrencyName!=null) {
			return ConversionMethod.DIRECT;
		}
		ConversionRate inverseCurrencyName = findCurrencyRateByName(outputCurrency+inputCurrency);
		//when it is not null that means direct conversion is available
		if(inverseCurrencyName!=null) {
			return ConversionMethod.INVERSE;
		}
		return ConversionMethod.CROSS;
	}
	
	@Override
	public Double conversionRateByConversionMethod(String inputCurrency, String outputCurrency, ConversionMethod conversionMethod) {
		switch(conversionMethod) {
		case EQUALS:
			return 1.00;
		case DIRECT:
			ConversionRate directConversionRate = findCurrencyRateByName(inputCurrency+outputCurrency);
			return directConversionRate.getRate();
		case INVERSE:
			ConversionRate inverseConversionRate = findCurrencyRateByName(outputCurrency+inputCurrency);
			return 1 / inverseConversionRate.getRate();
		default:
			return null;
		}		
		
	}	

}
