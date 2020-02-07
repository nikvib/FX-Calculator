package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.anz.fx.currency.converter.data.ConversionMethod;
import com.anz.fx.currency.converter.service.calculation.CrossCurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.service.calculation.CurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.service.calculation.NonCrossCurrencyConversionCalculationEngine;

public class CurrencyConversionCalculationEngineTest {	
	
	CurrencyConversionCalculationEngine currencyConversionCalculationEngine = null;	
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair1() {
		Double 	resultToTest = 0.8371;	
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();
		Double result = currencyConversionCalculationEngine.calculateConversionRate("AUD", "USD",ConversionMethod.DIRECT);		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair2() {
		Double 	resultToTest = 1.2315;		
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("EUR", "USD",ConversionMethod.DIRECT);	
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair3() {
		Double 	resultToTest = 119.95;
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("USD", "JPY",ConversionMethod.DIRECT);	
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair4() {
		Double 	resultToTest = 8.6651;	
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("EUR", "NOK",ConversionMethod.DIRECT);	
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair1() {
		Double 	resultToTest = 1.2903225806451613;	
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();	
		Double result = currencyConversionCalculationEngine.calculateConversionRate("USD", "NZD",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair2() {
		Double 	resultToTest = 0.036228208732447434;	
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();	
		Double result = currencyConversionCalculationEngine.calculateConversionRate("CZK", "EUR",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair3() {
		Double 	resultToTest = 0.008336807002917883;
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("JPY", "USD",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair4() {
		Double 	resultToTest = 0.13439956992137625;	
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("DKK", "EUR",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForSameCurrencyPair1() {
		Double 	resultToTest = 1.0;		
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("DKK", "DKK",ConversionMethod.EQUALS);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForSameCurrencyPair2() {
		Double 	resultToTest = 1.0;		
		currencyConversionCalculationEngine = new NonCrossCurrencyConversionCalculationEngine();		
		Double result = currencyConversionCalculationEngine.calculateConversionRate("EUR", "EUR",ConversionMethod.EQUALS);
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForDoubleCrossCurrencyPair1() {
		Double 	resultToTest = 9.47538461226147;
		currencyConversionCalculationEngine = new CrossCurrencyConversionCalculationEngine();
		Double result = currencyConversionCalculationEngine.calculateConversionRate("GBP", "DKK",ConversionMethod.CROSS);		
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForDoubleCrossCurrencyPair2() {
		Double 	resultToTest = 0.2753417135218167;	
		currencyConversionCalculationEngine = new CrossCurrencyConversionCalculationEngine();
		Double result = currencyConversionCalculationEngine.calculateConversionRate("CZK", "CNY",ConversionMethod.CROSS);		
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForDoubleCrossCurrencyPair3() {
		Double 	resultToTest = 5.890016410881039;
		currencyConversionCalculationEngine = new CrossCurrencyConversionCalculationEngine();
		Double result = currencyConversionCalculationEngine.calculateConversionRate("AUD", "NOK",ConversionMethod.CROSS);			
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForSingleCrossCurrencyPair1() {
		Double 	resultToTest = 100.410145;	
		currencyConversionCalculationEngine = new CrossCurrencyConversionCalculationEngine();
		Double result = currencyConversionCalculationEngine.calculateConversionRate("AUD", "JPY",ConversionMethod.CROSS);			
		assertEquals(resultToTest, result);				
	}
	
	@Test
	public void testCalculateConversionRateByTypeForSingleCrossCurrencyPair2() {
		Double 	resultToTest = 1.0801290322580643;
		currencyConversionCalculationEngine = new CrossCurrencyConversionCalculationEngine();
		Double result = currencyConversionCalculationEngine.calculateConversionRate("AUD", "NZD",ConversionMethod.CROSS);			
		assertEquals(resultToTest, result);				
	}

}
