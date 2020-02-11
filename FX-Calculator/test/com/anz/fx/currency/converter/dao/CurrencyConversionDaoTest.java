package com.anz.fx.currency.converter.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.anz.fx.currency.converter.dao.CurrencyConversionDao;
import com.anz.fx.currency.converter.dao.CurrencyConversionDaoImpl;
import com.anz.fx.currency.converter.data.ConversionRate;
import com.anz.fx.currency.converter.data.Currency;

public class CurrencyConversionDaoTest {
	
	private static CurrencyConversionDao currencyConversionDao = CurrencyConversionDaoImpl.getInstance();
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName1() {
		String 	currencyConversion = "AUDUSD";
		ConversionRate currencyConversionRate = currencyConversionDao.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName2() {
		String 	currencyConversion = "USDCNY";
		ConversionRate currencyConversionRate = currencyConversionDao.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName3() {
		String 	currencyConversion = "NZDUSD";
		ConversionRate currencyConversionRate = currencyConversionDao.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName4() {
		String 	currencyConversion = "EURDKK";
		ConversionRate currencyConversionRate = currencyConversionDao.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNullForInvalidCurrencyConversionName() {
		String 	currencyConversion = "ABCUSD";
		ConversionRate currencyConversionRate = currencyConversionDao.findCurrencyRateByName(currencyConversion);
		assertNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName1() {
		String 	currencyName = "DKK";
		Currency currency = currencyConversionDao.findCurrencyByName(currencyName);
		assertNotNull(currency);		
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName2() {
		String 	currencyName = "AUD";
		Currency currency = currencyConversionDao.findCurrencyByName(currencyName);
		assertNotNull(currency);			
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName3() {
		String 	currencyName = "GBP";
		Currency currency = currencyConversionDao.findCurrencyByName(currencyName);
		assertNotNull(currency);			
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName4() {
		String 	currencyName = "NOK";
		Currency currency = currencyConversionDao.findCurrencyByName(currencyName);
		assertNotNull(currency);		
	}
	
	@Test
	public void testFindCurrencyByNameIsNullForInvalidCurrencyName() {
		String 	currencyName = "ABC";
		Currency currency = currencyConversionDao.findCurrencyByName(currencyName);
		assertNull(currency);			
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName1() {
		String 	currencyName = "AUD";
		String crossCurrency = currencyConversionDao.findCurrencyContainsAName(currencyName);
		assertEquals("USD",crossCurrency);			
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName2() {
		String 	currencyName = "CNY";
		String crossCurrency = currencyConversionDao.findCurrencyContainsAName(currencyName);
		assertEquals("USD",crossCurrency);				
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName3() {
		String 	currencyName = "CZK";
		String crossCurrency = currencyConversionDao.findCurrencyContainsAName(currencyName);
		assertEquals("EUR",crossCurrency);				
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName4() {
		String 	currencyName = "NOK";
		String crossCurrency = currencyConversionDao.findCurrencyContainsAName(currencyName);
		assertEquals("EUR",crossCurrency);				
	}
	
	@Test
	public void testFindCurrencyContainsANameForInvalidValidCurrencyName() {
		String 	currencyName = "XYZ";
		String crossCurrency = currencyConversionDao.findCurrencyContainsAName(currencyName);
		assertNull(crossCurrency);				
	}
	
	
	@Test
	public void testGetPrecisionForUSDCurrency() {
		String 	currencyName = "USD";
		int precision = currencyConversionDao.getPrecision(currencyName);
		assertEquals(2, precision);		
	}
	
	@Test
	public void testGetPrecisionForJPYCurrency() {
		String 	currencyName = "JPY";
		int precision = currencyConversionDao.getPrecision(currencyName);
		assertEquals(0, precision);		
	}
	
	@Test
	public void testGetPrecisionForInvalidCurrency() {
		String 	currencyName = "XYZ";
		int precision = currencyConversionDao.getPrecision(currencyName);
		assertEquals(0, precision);		
	}
	

}
