package com.anz.fx.currency.converter.input.validation;

import com.anz.fx.currency.converter.constants.Messages;
import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.dao.CurrencyConversionDaoImpl;
import com.anz.fx.currency.converter.exception.CurrencyInputFormatException;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

/**
 * This class does the validation of input provided by user
 * @author Vaibhav
 * @version 1.0
 *
 */
public class InputValidation {
	
	CurrencyConversionDao currencyConversionDao = CurrencyConversionDaoImpl.getInstance();
	
	
	/**
	 * 
	 * @param inputs from console
	 * @return boolean true if input is valid
	 * @throws CurrencyInputFormatException 
	 */
	public String validateInput(String[] inputs) throws CurrencyInputFormatException {		
		if(!isValidLength(inputs)) {			
			throw new CurrencyInputFormatException(Messages.INVALID_LENGTH);
		}		
		if(isNotNumber(inputs[1])) {
			throw new CurrencyInputFormatException(Messages.INVALID_NUMBER);			
		}
		if(!isValidInputFormat(inputs[2])) {	
			throw new CurrencyInputFormatException(Messages.INVALID_FORMAT);			
		}		
		if(!isValidCurrencyName(inputs[0],inputs[3])) {			
			throw new CurrencyInputFormatException(ConversionRateUtil.formatMessageByPlaceholders(Messages.INVALID_CURRENCY, inputs[0],inputs[3]));			
		}
		return null;
	}	
	
	/**
	 * 
	 * @param inputs
	 * @return true if length is valid
	 */
	public boolean isValidLength(String[] inputs) {
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
	public boolean isValidInputFormat(String in) {		
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
	private boolean isNotNumber(String inputNumber) {
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
	public boolean isValidCurrencyName(String inputCurrency, String ouptputCurrency) {
		if(currencyConversionDao.findCurrencyByName(inputCurrency)!=null && currencyConversionDao.findCurrencyByName(ouptputCurrency)!=null) {
			return true;
		}
		return false;		
	}
}
