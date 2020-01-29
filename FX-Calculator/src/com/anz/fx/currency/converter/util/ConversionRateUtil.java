package com.anz.fx.currency.converter.util;

import java.text.DecimalFormat;

import com.anz.fx.currency.converter.data.ConversionRate;
import com.anz.fx.currency.converter.data.Currency;
/**
 * Utility class 
 * @author Vaibhav
 * 
 * @version 1.0
 *
 */
public class ConversionRateUtil {	
	
	/**
	 * 
	 * @param currencyName
	 * @return enum of the currency name conversion 
	 */
	public static ConversionRate findCurrencyRateByName(String currencyName) {
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
	public static Currency findCurrencyByName(String currencyName) {
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
	public static String findCurrencyContainsAName(String currencyName) {
		for(ConversionRate type:ConversionRate.values()) {
			if(type.name().contains(currencyName)) {
				//replace the currency name with blqank string this will give cross conversion currency
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
	public static int getPrecision(String currencyName) {
		Currency currency = findCurrencyByName(currencyName);
		if(currency!=null) {
			return currency.getPrecision();
		}
		return 0;		
	}

	
	/**
	 * 
	 * @param precision
	 * @return decimal format for a given currency
	 */
	public static DecimalFormat getFormatByPrecision(int precision) {
		if(precision == 0) {
			return new DecimalFormat ("0");
		}
		String numberSigns = generateNumberSigns(precision);		
		DecimalFormat format = new DecimalFormat ("0." + numberSigns);
		return format;
	}
	
	/**
	 * 
	 * @param number of precision
	 * @return pattern for formatting of a given currency
	 */
	private static String generateNumberSigns(int n) {
	    String s = "";
	    for (int i = 0; i < n; i++) {
	        s += "0";
	    }
	    return s;
	}
}
