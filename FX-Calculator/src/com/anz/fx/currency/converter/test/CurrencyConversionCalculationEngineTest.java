package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.anz.fx.currency.converter.service.calculation.CurrencyConversionCalculationEngine;

public class CurrencyConversionCalculationEngineTest {	
	
	
	@Test
	public void testcalculateConversionRateByTypeForDirectCurrencyPair1() {
		Double 	resultToTest = 0.8371;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("AUD", "USD");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForDirectCurrencyPair2() {
		Double 	resultToTest = 1.2315;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("EUR", "USD");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForDirectCurrencyPair3() {
		Double 	resultToTest = 119.95;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("USD", "JPY");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForDirectCurrencyPair4() {
		Double 	resultToTest = 8.6651;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("EUR", "NOK");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForInverseCurrencyPair1() {
		Double 	resultToTest = 1.2903225806451613;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("USD", "NZD");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForInverseCurrencyPair2() {
		Double 	resultToTest = 0.036228208732447434;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("CZK", "EUR");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForInverseCurrencyPair3() {
		Double 	resultToTest = 0.008336807002917883;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("JPY", "USD");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForInverseCurrencyPair4() {
		Double 	resultToTest = 0.13439956992137625;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("DKK", "EUR");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForSameCurrencyPair1() {
		Double 	resultToTest = 1.0;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("DKK", "DKK");		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testcalculateConversionRateByTypeForSameCurrencyPair2() {
		Double 	resultToTest = 1.0;		
		Double result = CurrencyConversionCalculationEngine.calculateConversionRateByType("EUR", "EUR");		
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testcalculateConversionRateByTypeForDoubleCrossCurrencyPair1() {
		Double 	resultToTest = 9.47538461226147;		
		Double result = CurrencyConversionCalculationEngine.calculateCrossConversionRate("GBP", "DKK");		
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testcalculateConversionRateByTypeForDoubleCrossCurrencyPair2() {
		Double 	resultToTest = 0.2753417135218167;		
		Double result = CurrencyConversionCalculationEngine.calculateCrossConversionRate("CZK", "CNY");		
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testcalculateConversionRateByTypeForDoubleCrossCurrencyPair3() {
		Double 	resultToTest = 5.890016410881039;		
		Double result = CurrencyConversionCalculationEngine.calculateCrossConversionRate("AUD", "NOK");			
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testcalculateConversionRateByTypeForSingleCrossCurrencyPair1() {
		Double 	resultToTest = 100.410145;		
		Double result = CurrencyConversionCalculationEngine.calculateCrossConversionRate("AUD", "JPY");			
		assertEquals(resultToTest, result);				
	}
	
	@Test
	public void testcalculateConversionRateByTypeForSingleCrossCurrencyPair2() {
		Double 	resultToTest = 1.0801290322580643;		
		Double result = CurrencyConversionCalculationEngine.calculateCrossConversionRate("AUD", "NZD");			
		assertEquals(resultToTest, result);				
	}

}
