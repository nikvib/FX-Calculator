package com.anz.fx.currency.converter.validation;

import com.anz.fx.currency.converter.util.ConversionRateUtil;

/**
 * This class does the validation of input provided by user
 * @author Vaibhav
 * @version 1.0
 *
 */
public class InputValidation {
	
	/**
	 * 
	 * @param inputs
	 * @return true if length is valid
	 */
	public static boolean isValidLength(String[] inputs) {
		if(inputs.length!=4) {
			return false;
		}
		return true;
		
	}
	
	/**
	 * 
	 * @param in
	 * @param inputAmount
	 * @return true if input format is valid
	 */
	public static boolean isValidInputFormat(String in, String inputAmount) {	
		//check if amount provided to convert is a valid number
		if(isNotNumber(inputAmount)) {
			return false;
		}
		//check if input is in correct format 
		if("in".equalsIgnoreCase(in)==false) {
			return false;
		}
		//if all validation are passed then return true
		return true;		
	}

	/**
	 * 
	 * @param inputNumber
	 * @return true if a given string can be converted to number.
	 */
	private static boolean isNotNumber(String inputNumber) {
		try {  
		    Double.parseDouble(inputNumber);  
		    return false;
		  } catch(NumberFormatException e){  
		    return true;  
		  }  
	}
	
	/**
	 * 
	 * @param inputCurrency
	 * @param ouptputCurrency
	 * @return true if currency name provided as input is valid currency
	 */
	public static boolean isValidCurrencyName(String inputCurrency, String ouptputCurrency) {
		if(ConversionRateUtil.findCurrencyByName(inputCurrency)!=null && ConversionRateUtil.findCurrencyByName(ouptputCurrency)!=null) {
			return true;
		}
		return false;		
	}
}
