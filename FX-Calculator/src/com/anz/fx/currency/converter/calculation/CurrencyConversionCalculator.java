package com.anz.fx.currency.converter.calculation;

import java.text.DecimalFormat;

import com.anz.fx.currency.converter.data.ConversionRate;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

/**
 * This class does the calculation to convert one currency to another
 * 
 * @author Vaibhav  
 * @version 1.0
 *
 */
public class CurrencyConversionCalculator {
	
	/**
	 * 
	 * @param inputCurrency
	 * @param outputCurrency
	 * @param amount input that needs to be multiplied to conversion rate
	 * @return result in String format after all calculation
	 */
	public String calculateCoversionRate(String inputCurrency, String outputCurrency, String amount) {	
		int precision = ConversionRateUtil.getPrecision(outputCurrency);
		Double rateToClaculate = calculateConversionRateByType(inputCurrency, outputCurrency);	
		/* 
		 * if rateToClaculate is null that means no equals, direct, inverse rates 
		 * are found then calculate rate by cross conversion */ 
		if(rateToClaculate == null) {
			rateToClaculate = calculateCrossConversionRate(inputCurrency, outputCurrency);
		}
		String result = calculateFinalRateByAmountAndPrecision(amount, rateToClaculate, precision);
		return result;
	}		

	/**
	 * This method calculates the rate based on the direct or inverse conversion or equals conversion
	 * @param inputCurrency
	 * @param outputCurrency
	 * @return rate
	 */
	private Double calculateConversionRateByType(String inputCurrency, String outputCurrency) {
		//converting to same currency, then rate is always 1.00
		if(inputCurrency.equalsIgnoreCase(outputCurrency)) {
			return 1.00;
		}
		
		//check if direct conversion is available by finding the value present in the ConversionRate enum 
		ConversionRate directCurrencyName = ConversionRateUtil.findCurrencyRateByName(inputCurrency+outputCurrency);
		//when it is not null that means direct conversion is available
		if(directCurrencyName!=null) {
			return directCurrencyName.getRate();
		}
		
		//check if inverse conversion is available by finding the inverse value present in the ConversionRate enum 
		ConversionRate inverseCurrencyName = ConversionRateUtil.findCurrencyRateByName(outputCurrency+inputCurrency);
		/* 
		 * when it is not null that means inverse conversion is available. 
		 * In this case, rate is inverse of direct rate = 1/directRate 
		*/
		if(inverseCurrencyName!=null) {
			return 1/inverseCurrencyName.getRate();
		}
		
		//If no inverse, direct, equals rate found then return null
		return null;		
	}
	
	/**
	 * 
	 * @param inputCurrency
	 * @param outputCurrency
	 * @return final currency rate based on cross currency
	 */
	private Double calculateCrossConversionRate(String inputCurrency, String outputCurrency) {
		/*
		 * First get the currency pairs cross currency name
		 */
		String inputCrossCurrency = ConversionRateUtil.findCurrencyContainsAName(inputCurrency);
		String outputCrossCurrency = ConversionRateUtil.findCurrencyContainsAName(outputCurrency);
		
		/*
		 * Get cross conversion rate 
		 * For example conversion of AUDJPY, then first in the above steps we got the cross currency name as USD for both AUD and JPY
		 * Then below we find calculation rate of USDAUD and USDJPY
		 */
		Double inputConversionRate = calculateConversionRateByType(inputCrossCurrency,inputCurrency);
		Double outputConversionRate = calculateConversionRateByType(outputCrossCurrency,outputCurrency);
		
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
			Double doubleCrossConversionRate = calculateConversionRateByType(outputCrossCurrency,inputCrossCurrency);
			Double doubleToSingleCrossConversionRate = outputConversionRate/doubleCrossConversionRate;
			double finalConversionRate = doubleToSingleCrossConversionRate/inputConversionRate;
			return finalConversionRate;	
		}		
	}
	
	/**
	 * 
	 * @param amount input that needs to be multiplied to conversion rate
	 * @param conversionRate
	 * @param precision 
	 * @return final result calculated by multiplying amount and conversion rate then formatting it based on precision for output currency
	 */
	private static String calculateFinalRateByAmountAndPrecision(String amount, double conversionRate, int precision) {
		double calculationAmount = Double.parseDouble(amount);
		double result = calculationAmount * conversionRate;
		DecimalFormat format = ConversionRateUtil.getFormatByPrecision(precision);		
		return format.format(result);
	}
	
}
