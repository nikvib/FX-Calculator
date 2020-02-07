package com.anz.fx.currency.converter.service;

import com.anz.fx.currency.converter.constants.Messages;
import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.dao.CurrencyConversionDaoImpl;
import com.anz.fx.currency.converter.data.ConversionMethod;
import com.anz.fx.currency.converter.service.calculation.CrossCurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.service.calculation.CurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.service.calculation.NonCrossCurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

/**
 * This class does the calculation to convert one currency to another. Implementation of CurrencyConversionService
 * 
 * @author Vaibhav  
 * @version 1.0
 *
 */
public class CurrencyConversionServiceImpl  implements CurrencyConversionService  {
	
	CurrencyConversionDao currencyConversionDao = CurrencyConversionDaoImpl.getInstance();
	CurrencyConversionCalculationEngine currencyConversionCalculationEngine1 = new NonCrossCurrencyConversionCalculationEngine();
	CurrencyConversionCalculationEngine currencyConversionCalculationEngine2 = new CrossCurrencyConversionCalculationEngine();
	
	
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
		//Calculate method that is required for conversion
		ConversionMethod conversionMethod = currencyConversionDao.getConversionMethod(inputCurrency, outputCurrency);
		String result;
		if(!conversionMethod.equals(ConversionMethod.CROSS)) {
			Double coversionRate = currencyConversionCalculationEngine1.calculateConversionRate(inputCurrency, outputCurrency, conversionMethod);
		
		//calculate final amount
		 result = currencyConversionCalculationEngine1.calculateFinalRateByAmountAndPrecision(amount, coversionRate, outputCurrency);		
		}else {
			Double coversionRate = currencyConversionCalculationEngine2.calculateConversionRate(inputCurrency, outputCurrency, conversionMethod);
		
		//calculate final amount
		 result = currencyConversionCalculationEngine2.calculateFinalRateByAmountAndPrecision(amount, coversionRate, outputCurrency);		
		}
		//Calculate conversion rate depending on class to call - either cross conversion or non cross conversion
		
		String formattedResult = ConversionRateUtil.formatMessageByPlaceholders(Messages.RESULT, inputCurrency,amount,outputCurrency,result);
		return formattedResult;
	}		

	
	
}
