package com.anz.fx.currency.converter.service.calculation;

import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.dao.CurrencyConversionDaoImpl;
import com.anz.fx.currency.converter.data.ConversionMethod;


/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * calculate conversion rate for non cross conversion which is Direct, Indirect, Equals
 *
 */
public class NonCrossCurrencyConversionCalculationEngine extends CurrencyConversionCalculationEngine {
	
	private static CurrencyConversionDao currencyConversionDao = CurrencyConversionDaoImpl.getInstance();
	
	/**
	 * This method calculates the rate based on the direct or inverse conversion or equals conversion
	 * @param inputCurrency
	 * @param outputCurrency
	 * @param conversionMethod
	 * @return conversionRate based on non cross conversion method 
	 */
	@Override
	public Double calculateConversionRate(String inputCurrency, String outputCurrency, ConversionMethod conversionMethod) {
		return currencyConversionDao.conversionRateByConversionMethod(inputCurrency, outputCurrency,conversionMethod);
		
	}	

}
