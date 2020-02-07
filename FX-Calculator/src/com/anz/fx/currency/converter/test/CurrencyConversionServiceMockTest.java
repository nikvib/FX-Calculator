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
import com.anz.fx.currency.converter.service.CurrencyConversionService;
import com.anz.fx.currency.converter.service.CurrencyConversionServiceImpl;
import com.anz.fx.currency.converter.service.calculation.CurrencyConversionCalculationEngine;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyConversionServiceMockTest {
	
	@InjectMocks
	private static CurrencyConversionService currencyConversionService =  CurrencyConversionServiceImpl.getInstance();
	
	@Mock
	private CurrencyConversionDao currencyConversionDao;	
	
	@Mock
	private CurrencyConversionCalculationEngine currencyConversionCalculationEngine;
	
	
	@Test
	public void testCalculateCoversionRateForDirectCurrencyMock(){
		String expectedResult = "AUD 20.22 = USD 16.93";
		when(currencyConversionDao.getConversionMethod("AUD","USD")).thenReturn(ConversionMethod.DIRECT);			
		when(currencyConversionCalculationEngine.calculateConversionRate("AUD","USD",ConversionMethod.DIRECT)).thenReturn(0.8371);		
		when(currencyConversionCalculationEngine.calculateFinalRateByAmountAndPrecision("20.22",0.8371,"USD")).thenReturn("16.93");		
		String result = currencyConversionService.calculateCoversionRate("AUD", "USD", "20.22");		
		assertEquals(expectedResult, result);			
	}
	
	@Test
	public void testCalculateCoversionRateForDirectCurrencyMockMethodCount(){		
		when(currencyConversionDao.getConversionMethod("AUD","USD")).thenReturn(ConversionMethod.DIRECT);			
		when(currencyConversionCalculationEngine.calculateConversionRate("AUD","USD",ConversionMethod.DIRECT)).thenReturn(0.8371);		
		when(currencyConversionCalculationEngine.calculateFinalRateByAmountAndPrecision("20.22",0.8371,"USD")).thenReturn("16.93");		
		currencyConversionService.calculateCoversionRate("AUD", "USD", "20.22");
		verify(currencyConversionDao,times(1)).getConversionMethod("AUD","USD");
		verify(currencyConversionCalculationEngine,times(1)).calculateConversionRate("AUD","USD",ConversionMethod.DIRECT);
		verify(currencyConversionCalculationEngine,times(1)).calculateFinalRateByAmountAndPrecision("20.22",0.8371,"USD");			
	}

}
