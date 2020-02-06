package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.anz.fx.currency.converter.service.CurrencyConversionService;
import com.anz.fx.currency.converter.service.CurrencyConversionServiceImpl;

public class CurrencyConversionServiceTest {
	
	CurrencyConversionService currencyConversionService = CurrencyConversionServiceImpl.getInstance();
	
	@Test
	public void testCalculateCoversionRateForDirectCurrency(){
		String expectedResult = "AUD 20.22 = USD 16.93";
		String result = currencyConversionService.calculateCoversionRate("AUD", "USD", "20.22");		
		assertEquals(expectedResult, result);		
		
		
	}
	
	@Test
	public void testCalculateCoversionRateForSameCurrency(){
		String expectedResult = "NOK 34.00 = NOK 34.00";
		String result = currencyConversionService.calculateCoversionRate("NOK", "NOK", "34.00");		
		assertEquals(expectedResult, result);		
		
		
	}
	
	@Test
	public void testCalculateCoversionRateForInverseCurrency(){
		String expectedResult = "AUD 25 = USD 20.93";
		String result = currencyConversionService.calculateCoversionRate("AUD", "USD", "25");		
		assertEquals(expectedResult, result);		
		
		
	}
	
	@Test
	public void testCalculateCoversionRateForSingleCrossCurrency(){
		String expectedResult = "NZD 50.00 = JPY 4648";
		String result = currencyConversionService.calculateCoversionRate("NZD", "JPY", "50.00");		
		assertEquals(expectedResult, result);		
		
		
	}
	
	@Test
	public void testCalculateCoversionRateForDoubleCrossCurrency(){
		String expectedResult = "CAD 75 = NOK 459.69";
		String result = currencyConversionService.calculateCoversionRate("CAD", "NOK", "75");		
		assertEquals(expectedResult, result);		
		
		
	}

}
