package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.data.ConversionMethod;
import com.anz.fx.currency.converter.service.calculation.CrossCurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.service.calculation.CurrencyConversionCalculationEngine;
import com.anz.fx.currency.converter.service.calculation.NonCrossCurrencyConversionCalculationEngine;


@RunWith(MockitoJUnitRunner.class)
public class CurrencyConversionCalculationEngineMockTest {
	
	
	@InjectMocks
	private static CurrencyConversionCalculationEngine currencyConversionCalculationEngine1 = new NonCrossCurrencyConversionCalculationEngine();
	
	@InjectMocks
	private static CurrencyConversionCalculationEngine currencyConversionCalculationEngine2 = new CrossCurrencyConversionCalculationEngine();
	
	@Mock
	private CurrencyConversionDao currencyConversionDao;	
	
	
	
	@Test
	public void testCalculateConversionRateForMockData() {
		Double 	resultToTest = 0.8371;		
		when(currencyConversionDao.conversionRateByConversionMethod("AUD", "USD",ConversionMethod.DIRECT)).thenReturn(0.8371);
		Double result = currencyConversionCalculationEngine1.calculateConversionRate("AUD", "USD",ConversionMethod.DIRECT);		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateForMockDataVerifyCount() {			
		when(currencyConversionDao.conversionRateByConversionMethod("AUD", "USD",ConversionMethod.DIRECT)).thenReturn(0.8371);
		currencyConversionCalculationEngine1.calculateConversionRate("AUD", "USD",ConversionMethod.DIRECT);		
		verify(currencyConversionDao,times(1)).conversionRateByConversionMethod("AUD","USD",ConversionMethod.DIRECT);		
	}
	
	@Test
	public void testCalculateConversionRateForMockDataOfDoubleCrossConversion() {
		Double 	resultToTest = 0.5;			
		when(currencyConversionDao.findCurrencyContainsAName("AUD")).thenReturn("USD");
		when(currencyConversionDao.findCurrencyContainsAName("NOK")).thenReturn("EUR");		
		when(currencyConversionDao.getConversionMethod("USD", "AUD")).thenReturn(ConversionMethod.INVERSE);
		when(currencyConversionDao.getConversionMethod("EUR", "NOK")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.conversionRateByConversionMethod("USD", "AUD",ConversionMethod.INVERSE)).thenReturn(2.0);
		when(currencyConversionDao.conversionRateByConversionMethod("EUR", "NOK",ConversionMethod.DIRECT)).thenReturn(2.0);		
		when(currencyConversionDao.getConversionMethod("EUR", "USD")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.conversionRateByConversionMethod("EUR", "USD",ConversionMethod.DIRECT)).thenReturn(2.0);		
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("AUD", "NOK",ConversionMethod.CROSS);		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateForMockDataOfSingleCrossConversion() {
		Double 	resultToTest = 1.2;			
		when(currencyConversionDao.findCurrencyContainsAName("AUD")).thenReturn("USD");
		when(currencyConversionDao.findCurrencyContainsAName("JPY")).thenReturn("USD");		
		when(currencyConversionDao.getConversionMethod("USD", "AUD")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.getConversionMethod("USD", "JPY")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.conversionRateByConversionMethod("USD", "AUD",ConversionMethod.DIRECT)).thenReturn(5.5);
		when(currencyConversionDao.conversionRateByConversionMethod("USD", "JPY",ConversionMethod.DIRECT)).thenReturn(6.6);			
		Double result = currencyConversionCalculationEngine2.calculateConversionRate("AUD", "JPY",ConversionMethod.CROSS);		
		assertEquals(resultToTest, result);			
	}
	
	@Test
	public void testCalculateConversionRateForMockDataOfDoubleCrossConversionVerifyCount() {			
		when(currencyConversionDao.findCurrencyContainsAName("AUD")).thenReturn("USD");
		when(currencyConversionDao.findCurrencyContainsAName("NOK")).thenReturn("EUR");		
		when(currencyConversionDao.getConversionMethod("USD", "AUD")).thenReturn(ConversionMethod.INVERSE);
		when(currencyConversionDao.getConversionMethod("EUR", "NOK")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.conversionRateByConversionMethod("USD", "AUD",ConversionMethod.INVERSE)).thenReturn(2.0);
		when(currencyConversionDao.conversionRateByConversionMethod("EUR", "NOK",ConversionMethod.DIRECT)).thenReturn(2.0);		
		when(currencyConversionDao.getConversionMethod("EUR", "USD")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.conversionRateByConversionMethod("EUR", "USD",ConversionMethod.DIRECT)).thenReturn(2.0);		
		currencyConversionCalculationEngine2.calculateConversionRate("AUD", "NOK",ConversionMethod.CROSS);	
		
		verify(currencyConversionDao,times(1)).findCurrencyContainsAName("AUD");
		verify(currencyConversionDao,times(1)).findCurrencyContainsAName("NOK");
		verify(currencyConversionDao,times(1)).getConversionMethod("USD","AUD");
		verify(currencyConversionDao,times(1)).getConversionMethod("EUR","NOK");
		verify(currencyConversionDao,times(1)).conversionRateByConversionMethod("USD","AUD",ConversionMethod.INVERSE);
		verify(currencyConversionDao,times(1)).conversionRateByConversionMethod("EUR","NOK",ConversionMethod.DIRECT);
		verify(currencyConversionDao,times(1)).getConversionMethod("EUR","USD");
		verify(currencyConversionDao,times(1)).conversionRateByConversionMethod("EUR","USD",ConversionMethod.DIRECT);
				
	}
	
	@Test
	public void testCalculateConversionRateForMockDataOfSingleCrossConversionVerifyCount() {			
		when(currencyConversionDao.findCurrencyContainsAName("AUD")).thenReturn("USD");
		when(currencyConversionDao.findCurrencyContainsAName("JPY")).thenReturn("USD");		
		when(currencyConversionDao.getConversionMethod("USD", "AUD")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.getConversionMethod("USD", "JPY")).thenReturn(ConversionMethod.DIRECT);
		when(currencyConversionDao.conversionRateByConversionMethod("USD", "AUD",ConversionMethod.DIRECT)).thenReturn(5.5);
		when(currencyConversionDao.conversionRateByConversionMethod("USD", "JPY",ConversionMethod.DIRECT)).thenReturn(6.6);			
		currencyConversionCalculationEngine2.calculateConversionRate("AUD", "JPY",ConversionMethod.CROSS);		
		
		verify(currencyConversionDao,times(1)).findCurrencyContainsAName("AUD");
		verify(currencyConversionDao,times(1)).findCurrencyContainsAName("JPY");
		verify(currencyConversionDao,times(1)).getConversionMethod("USD","AUD");
		verify(currencyConversionDao,times(1)).getConversionMethod("USD","JPY");
		verify(currencyConversionDao,times(1)).conversionRateByConversionMethod("USD","AUD",ConversionMethod.DIRECT);
		verify(currencyConversionDao,times(1)).conversionRateByConversionMethod("USD","JPY",ConversionMethod.DIRECT);		
	}

}
