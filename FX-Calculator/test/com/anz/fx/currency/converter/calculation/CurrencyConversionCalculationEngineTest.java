package com.anz.fx.currency.converter.calculation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.anz.fx.currency.converter.calculation.CrossCurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.calculation.CurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.calculation.NonCrossCurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.data.ConversionMethod;

public class CurrencyConversionCalculationEngineTest {	
	
	CurrencyConversionCalculationEngine currencyConversionCalculationEngine1 = null;
	CurrencyConversionCalculationEngine currencyConversionCalculationEngine2 = null;
	
	@Before
	public void createInstancxe() {
		currencyConversionCalculationEngine1 = new NonCrossCurrencyConversionCalculationEngine();
		currencyConversionCalculationEngine2 = new CrossCurrencyConversionCalculationEngine();
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair1() {
		Double 	resultToTest = 0.8371;			
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("AUD", "USD",ConversionMethod.DIRECT);		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair2() {
		Double 	resultToTest = 1.2315;					
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("EUR", "USD",ConversionMethod.DIRECT);	
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair3() {
		Double 	resultToTest = 119.95;				
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("USD", "JPY",ConversionMethod.DIRECT);	
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForDirectCurrencyPair4() {
		Double 	resultToTest = 8.6651;					
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("EUR", "NOK",ConversionMethod.DIRECT);	
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair1() {
		Double 	resultToTest = 1.2903225806451613;				
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("USD", "NZD",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair2() {
		Double 	resultToTest = 0.036228208732447434;			
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("CZK", "EUR",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair3() {
		Double 	resultToTest = 0.008336807002917883;				
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("JPY", "USD",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForInverseCurrencyPair4() {
		Double 	resultToTest = 0.13439956992137625;					
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("DKK", "EUR",ConversionMethod.INVERSE);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForSameCurrencyPair1() {
		Double 	resultToTest = 1.0;					
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("DKK", "DKK",ConversionMethod.EQUALS);
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateByTypeForSameCurrencyPair2() {
		Double 	resultToTest = 1.0;					
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("EUR", "EUR",ConversionMethod.EQUALS);
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForDoubleCrossCurrencyPair1() {
		Double 	resultToTest = 9.47538461226147;		
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("GBP", "DKK",ConversionMethod.CROSS);		
		assertEquals(resultToTest, result);			
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForDoubleCrossCurrencyPair2() {
		Double 	resultToTest = 0.2753417135218167;		
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("CZK", "CNY",ConversionMethod.CROSS);		
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForDoubleCrossCurrencyPair3() {
		Double 	resultToTest = 5.890016410881039;		
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("AUD", "NOK",ConversionMethod.CROSS);			
		assertEquals(resultToTest, result);				
	}	
	
	@Test
	public void testCalculateConversionRateByTypeForSingleCrossCurrencyPair1() {
		Double 	resultToTest = 100.410145;		
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("AUD", "JPY",ConversionMethod.CROSS);			
		assertEquals(resultToTest, result);				
	}
	
	@Test
	public void testCalculateConversionRateByTypeForSingleCrossCurrencyPair2() {
		Double 	resultToTest = 1.0801290322580643;		
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("AUD", "NZD",ConversionMethod.CROSS);			
		assertEquals(resultToTest, result);				
	}

}
