package com.anz.fx.currency.converter.calculation;

import java.text.DecimalFormat;

import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.dao.CurrencyConversionDaoImpl;
import com.anz.fx.currency.converter.data.ConversionMethod;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * abstract class to calculate conversion rate based on method
 * 
 */
public abstract class CurrencyConversionCalculationEngine {
	
	public abstract Double calculateConversionRate(String inputCurrency, String outputCurrency, ConversionMethod conversionMethod);
	
	/**
	 * 
	 * @param amount input that needs to be multiplied to conversion rate
	 * @param conversionRate
	 * @param precision 
	 * @return final result calculated by multiplying amount and conversion rate then formatting it based on precision for output currency
	 */
	public String calculateFinalRateByAmountAndPrecision(String amount, double conversionRate, String outputCurrency) {
		CurrencyConversionDao currencyConversionDao = CurrencyConversionDaoImpl.getInstance();
		int precision = currencyConversionDao.getPrecision(outputCurrency);
		double calculationAmount = Double.parseDouble(amount);
		double result = calculationAmount * conversionRate;
		DecimalFormat format = ConversionRateUtil.getFormatByPrecision(precision);		
		return format.format(result);
	}

}
