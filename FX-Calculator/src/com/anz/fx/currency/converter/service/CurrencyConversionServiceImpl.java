package com.anz.fx.currency.converter.service;

import com.anz.fx.currency.converter.constants.Messages;
import com.anz.fx.currency.converter.service.calculation.CurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

/**
 * This class does the calculation to convert one currency to another. Implementation of CurrencyConversionService
 * 
 * @author Vaibhav  
 * @version 1.0
 *
 */
public class CurrencyConversionServiceImpl  implements CurrencyConversionService  {
	
	
	 //Singleton to make sure only one instance is created of service throughout
	 private static CurrencyConversionServiceImpl instance = null;
	 
	 private CurrencyConversionServiceImpl() {	     
	 }

	   public static CurrencyConversionServiceImpl getInstance() {
	      if(instance == null) {
	         instance = new CurrencyConversionServiceImpl();
	      }
	      return instance;
	   }
	   //End Singleton
	
	/**
	 * 
	 * @param inputCurrency
	 * @param outputCurrency
	 * @param amount input that needs to be multiplied to conversion rate
	 * @return result in String format after all calculation
	 */
	public String calculateCoversionRate(String inputCurrency, String outputCurrency, String amount) {		
		Double rateToClaculate = CurrencyConversionCalculationEngine.calculateConversionRateByType(inputCurrency, outputCurrency);	
		/* 
		 * if rateToClaculate is null that means no equals, direct, inverse rates 
		 * are found then calculate rate by cross conversion */ 
		if(rateToClaculate == null) {
			rateToClaculate = CurrencyConversionCalculationEngine.calculateCrossConversionRate(inputCurrency, outputCurrency);
		}
		String result = CurrencyConversionCalculationEngine.calculateFinalRateByAmountAndPrecision(amount, rateToClaculate, outputCurrency);		
		String formattedResult = ConversionRateUtil.formatMessageByPlaceholders(Messages.RESULT, inputCurrency,amount,outputCurrency,result);
		return formattedResult;
	}		

	
	
}
