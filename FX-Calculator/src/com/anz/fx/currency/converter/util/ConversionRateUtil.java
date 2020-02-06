package com.anz.fx.currency.converter.util;

import java.text.DecimalFormat;
/**
 * Utility class 
 * @author Vaibhav
 * 
 * @version 1.0
 *
 */
public class ConversionRateUtil {	
	/**
	 * 
	 * @param precision
	 * @return decimal format for a given currency
	 */
	public static DecimalFormat getFormatByPrecision(int precision) {
		if(precision == 0) {
			return new DecimalFormat ("0");
		}
		String numberSigns = generateNumberSigns(precision);		
		DecimalFormat format = new DecimalFormat ("0." + numberSigns);
		return format;
	}
	
	/**
	 * 
	 * @param message
	 * @param placeHolder
	 * @return formatted String which will be formatted based on place holders passed to format method of String
	 */
	public static String formatMessageByPlaceholders(String message, Object...placeHolder) {
		return String.format(message, placeHolder);
		
	}
	
	/**
	 * 
	 * @param number of precision
	 * @return pattern for formatting of a given currency
	 */
	private static String generateNumberSigns(int n) {
	    String s = "";
	    for (int i = 0; i < n; i++) {
	        s += "0";
	    }
	    return s;
	}	
	
}
