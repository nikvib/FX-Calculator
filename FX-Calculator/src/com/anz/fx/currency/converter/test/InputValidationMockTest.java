package com.anz.fx.currency.converter.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.data.Currency;
import com.anz.fx.currency.converter.exception.CurrencyInputFormatException;
import com.anz.fx.currency.converter.input.validation.InputValidation;

@RunWith(MockitoJUnitRunner.class)
public class InputValidationMockTest {
	
	
	@InjectMocks
	private InputValidation inputValidation = new InputValidation();
	
	@Mock
	private CurrencyConversionDao currencyConversionDao;
	
	
	@Test(expected = CurrencyInputFormatException.class)
	public void testValidateInputForMockDataWhichShouldThrowException() throws CurrencyInputFormatException  {
		String[] inputs = {"USD","100","in","JPY"};
		 when(currencyConversionDao.findCurrencyByName("USD")).thenReturn(Currency.USD);	
		 when(currencyConversionDao.findCurrencyByName("JPY")).thenReturn(null);		 
		 assertEquals(inputValidation.validateInput(inputs), CurrencyInputFormatException.class);
	}
	
	@Test
	public void testValidateInputForMockDataWichWillBeSuccessfullyValidated() throws CurrencyInputFormatException  {
		String[] inputs = {"USD","100","in","JPY"};
		 when(currencyConversionDao.findCurrencyByName("USD")).thenReturn(Currency.USD);	
		 when(currencyConversionDao.findCurrencyByName("JPY")).thenReturn(Currency.JPY);		 
		 assertEquals(inputValidation.validateInput(inputs), null);
	}
	
	@Test
	public void testValidateInputNumberOfCallsToDao() throws CurrencyInputFormatException  {
		String[] inputs = {"USD","100","in","JPY"};
		when(currencyConversionDao.findCurrencyByName("USD")).thenReturn(Currency.USD);	
		when(currencyConversionDao.findCurrencyByName("JPY")).thenReturn(Currency.JPY);
		inputValidation.validateInput(inputs);
		verify(currencyConversionDao,times(1)).findCurrencyByName("USD");
		verify(currencyConversionDao,times(1)).findCurrencyByName("JPY");
		verify(currencyConversionDao,times(0)).findCurrencyByName("CKK");		 
	}
	

}
