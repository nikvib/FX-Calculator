package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.anz.fx.currency.converter.calculation.CurrencyConversionCalculator;

public class CurrencyConversionCalculatorTest {	
	
	
	@Test
	public void testCalculateCoversionRateForDirectCurrencyPair1() {
		String 	resultToTest = "169.55";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("AUD", "USD", "202.55");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForDirectCurrencyPair2() {
		String 	resultToTest = "123.15";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("EUR", "USD", "100.00");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForDirectCurrencyPair3() {
		String 	resultToTest = "18052";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("USD", "JPY", "150.50");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForDirectCurrencyPair4() {
		String 	resultToTest = "1820.54";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("EUR", "NOK", "210.10");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForInverseCurrencyPair1() {
		String 	resultToTest = "444.15";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("USD", "NZD", "344.22");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForInverseCurrencyPair2() {
		String 	resultToTest = "0.85";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("CZK", "EUR", "23.55");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForInverseCurrencyPair3() {
		String 	resultToTest = "1.08";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("JPY", "USD", "130.00");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForInverseCurrencyPair4() {
		String 	resultToTest = "13.44";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("DKK", "EUR", "100.00");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForSameCurrencyPair1() {
		String 	resultToTest = "250.00";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("DKK", "DKK", "250.00");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForSameCurrencyPair2() {
		String 	resultToTest = "109.56";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("EUR", "EUR", "109.56");		
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testCalculateCoversionRateForDoubleCrossCurrencyPair1() {
		String 	resultToTest = "379.02";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("GBP", "DKK", "40.00");		
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testCalculateCoversionRateForDoubleCrossCurrencyPair2() {
		String 	resultToTest = "8.26";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("CZK", "CNY", "30.00");		
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testCalculateCoversionRateForDoubleCrossCurrencyPair3() {
		String 	resultToTest = "132.53";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("AUD", "NOK", "22.50");			
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testCalculateCoversionRateForSingleCrossCurrencyPair1() {
		String 	resultToTest = "100";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("AUD", "JPY", "1");			
		assertEquals(resultToTest, result);				
	}
	
	@Test
	public void testCalculateCoversionRateForSingleCrossCurrencyPair2() {
		String 	resultToTest = "108.01";
		CurrencyConversionCalculator currencyConversionCalculator = new CurrencyConversionCalculator();
		String result = currencyConversionCalculator.calculateCoversionRate("AUD", "NZD", "100");			
		assertEquals(resultToTest, result);				
	}

}
