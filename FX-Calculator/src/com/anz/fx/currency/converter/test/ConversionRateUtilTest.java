package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import com.anz.fx.currency.converter.constants.Messages;
import com.anz.fx.currency.converter.util.ConversionRateUtil;

public class ConversionRateUtilTest {
	
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
	
	
	@Test
	public void testFormatMessageByPlaceholdersForConstantResult() {
		String message = "USD 100 = JPY 1000";
		String format = ConversionRateUtil.formatMessageByPlaceholders(Messages.RESULT, "USD","100","JPY","1000");		
		assertEquals(message, format);		
	}
	
	@Test
	public void testFormatMessageByPlaceholdersForConstantInvalidCurrency() {
		String message = "Unable to find rate for ABC/XYZ";
		String format = ConversionRateUtil.formatMessageByPlaceholders(Messages.INVALID_CURRENCY, "ABC","XYZ");		
		assertEquals(message, format);		
	}

}
