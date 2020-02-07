package com.anz.fx.currency.converter.service.calculation;

import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.dao.CurrencyConversionDaoImpl;
import com.anz.fx.currency.converter.data.ConversionMethod;

/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * calculate conversion rate for cross conversion 
 *
 */
public class CrossCurrencyConversionCalculationEngine extends CurrencyConversionCalculationEngine {
	
	CurrencyConversionDao currencyConversionDao = CurrencyConversionDaoImpl.getInstance();

	@Override
	public Double calculateConversionRate(String inputCurrency, String outputCurrency, ConversionMethod conversionMethod) {
		/*
		 * First get the currency pairs cross currency name
		 */
		String inputCrossCurrency = currencyConversionDao.findCurrencyContainsAName(inputCurrency);
		String outputCrossCurrency = currencyConversionDao.findCurrencyContainsAName(outputCurrency);
		
		/*
		 * Get cross conversion rate 
		 * For example conversion of AUDJPY, then first in the above steps we got the cross currency name as USD for both AUD and JPY
		 * Then below we find calculation rate of USDAUD and USDJPY
		 */
		ConversionMethod conversionMethod1 = currencyConversionDao.getConversionMethod(inputCrossCurrency, inputCurrency);
		ConversionMethod conversionMethod2 = currencyConversionDao.getConversionMethod(outputCrossCurrency, outputCurrency);
		Double inputConversionRate = currencyConversionDao.conversionRateByConversionMethod(inputCrossCurrency, inputCurrency,conversionMethod1);
		Double outputConversionRate = currencyConversionDao.conversionRateByConversionMethod(outputCrossCurrency, outputCurrency,conversionMethod2);
		
		/*
		 * If cross currency name is same for both input and output currency then calculate the actual rate for input and output currency
		 * In the example now AUDJPY will be (Rate of USDJPY)/(Rate of USDAUD)
		 * 
		 */
		if(inputCrossCurrency.equalsIgnoreCase(outputCrossCurrency)) {			
			double finalConversionRate = outputConversionRate/inputConversionRate;
			return finalConversionRate;
		/*
		 * If cross currency name is not same then do the further calculation
		 * for example conversion of GBPDKK, then first steps we got the cross currency name not same and different for both -  USD for GBP and EUR for DKK
		 * In this case now we need to calculate double cross currency EUR to USD and then convert it to final conversion rate.
		 * So final calculation will be -
		 * ((Rate of EURDKK)/(Rate of EURUSD))/(USDGBP) 
		 */
		}else {
			ConversionMethod conversionMethod3 = currencyConversionDao.getConversionMethod(outputCrossCurrency, inputCrossCurrency);
			Double doubleCrossConversionRate = currencyConversionDao.conversionRateByConversionMethod(outputCrossCurrency, inputCrossCurrency,conversionMethod3);
			Double doubleToSingleCrossConversionRate = outputConversionRate/doubleCrossConversionRate;
			double finalConversionRate = doubleToSingleCrossConversionRate/inputConversionRate;
			return finalConversionRate;	
		}		
	}	
	
	

}
