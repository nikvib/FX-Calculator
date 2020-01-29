package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.DecimalFormat;

import org.junit.Test;

import com.anz.fx.currency.converter.data.ConversionRate;
import com.anz.fx.currency.converter.data.Currency;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

public class ConversionRateUtilTest {
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName1() {
		String 	currencyConversion = "AUDUSD";
		ConversionRate currencyConversionRate = ConversionRateUtil.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName2() {
		String 	currencyConversion = "USDCNY";
		ConversionRate currencyConversionRate = ConversionRateUtil.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName3() {
		String 	currencyConversion = "NZDUSD";
		ConversionRate currencyConversionRate = ConversionRateUtil.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNotNullForValidCurrencyConversionName4() {
		String 	currencyConversion = "EURDKK";
		ConversionRate currencyConversionRate = ConversionRateUtil.findCurrencyRateByName(currencyConversion);
		assertNotNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyRateByNameIsNullForInvalidCurrencyConversionName() {
		String 	currencyConversion = "ABCUSD";
		ConversionRate currencyConversionRate = ConversionRateUtil.findCurrencyRateByName(currencyConversion);
		assertNull(currencyConversionRate);			
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName1() {
		String 	currencyName = "DKK";
		Currency currency = ConversionRateUtil.findCurrencyByName(currencyName);
		assertNotNull(currency);		
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName2() {
		String 	currencyName = "AUD";
		Currency currency = ConversionRateUtil.findCurrencyByName(currencyName);
		assertNotNull(currency);			
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName3() {
		String 	currencyName = "GBP";
		Currency currency = ConversionRateUtil.findCurrencyByName(currencyName);
		assertNotNull(currency);			
	}
	
	@Test
	public void testFindCurrencyByNameIsNotNullForValidCurrencyName4() {
		String 	currencyName = "NOK";
		Currency currency = ConversionRateUtil.findCurrencyByName(currencyName);
		assertNotNull(currency);		
	}
	
	@Test
	public void testFindCurrencyByNameIsNullForInvalidCurrencyName() {
		String 	currencyName = "ABC";
		Currency currency = ConversionRateUtil.findCurrencyByName(currencyName);
		assertNull(currency);			
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName1() {
		String 	currencyName = "AUD";
		String crossCurrency = ConversionRateUtil.findCurrencyContainsAName(currencyName);
		assertEquals("USD",crossCurrency);			
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName2() {
		String 	currencyName = "CNY";
		String crossCurrency = ConversionRateUtil.findCurrencyContainsAName(currencyName);
		assertEquals("USD",crossCurrency);				
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName3() {
		String 	currencyName = "CZK";
		String crossCurrency = ConversionRateUtil.findCurrencyContainsAName(currencyName);
		assertEquals("EUR",crossCurrency);				
	}
	
	@Test
	public void testFindCurrencyContainsANameForValidCurrencyName4() {
		String 	currencyName = "NOK";
		String crossCurrency = ConversionRateUtil.findCurrencyContainsAName(currencyName);
		assertEquals("EUR",crossCurrency);				
	}
	
	@Test
	public void testFindCurrencyContainsANameForInvalidValidCurrencyName() {
		String 	currencyName = "XYZ";
		String crossCurrency = ConversionRateUtil.findCurrencyContainsAName(currencyName);
		assertNull(crossCurrency);				
	}
	
	
	@Test
	public void testGetPrecisionForUSDCurrency() {
		String 	currencyName = "USD";
		int precision = ConversionRateUtil.getPrecision(currencyName);
		assertEquals(2, precision);		
	}
	
	@Test
	public void testGetPrecisionForJPYCurrency() {
		String 	currencyName = "JPY";
		int precision = ConversionRateUtil.getPrecision(currencyName);
		assertEquals(0, precision);		
	}
	
	@Test
	public void testGetPrecisionForInvalidCurrency() {
		String 	currencyName = "XYZ";
		int precision = ConversionRateUtil.getPrecision(currencyName);
		assertEquals(0, precision);		
	}
	
	@Test
	public void testGetFormatByPrecisionIs2() {
		int precision = 2;
		DecimalFormat formatToTest = new DecimalFormat ("0.00");
		DecimalFormat format = ConversionRateUtil.getFormatByPrecision(precision);		
		assertEquals(formatToTest, format);		
	}
	
	@Test
	public void testGetFormatByPrecisionIs5() {
		int precision = 5;
		DecimalFormat formatToTest = new DecimalFormat ("0.00000");
		DecimalFormat format = ConversionRateUtil.getFormatByPrecision(precision);		
		assertEquals(formatToTest, format);		
	}
	
	@Test
	public void testGetFormatByPrecisionIs0() {
		int precision = 0;
		DecimalFormat formatToTest = new DecimalFormat ("0");
		DecimalFormat format = ConversionRateUtil.getFormatByPrecision(precision);		
		assertEquals(formatToTest, format);		
	}

}
