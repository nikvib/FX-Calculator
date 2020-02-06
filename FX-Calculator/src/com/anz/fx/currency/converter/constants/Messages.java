package com.anz.fx.currency.converter.constants;

/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * Constant class to keep messages displayed as output
 *
 */
public class Messages {
	
	public static final String INVALID_LENGTH = "Input length is invalid either too many words or not enough words.\nPlease provide in correct format - \"<ccy1> <amount1> in <ccy2>\"";
	public static final String INVALID_NUMBER = "Number error. Input cotains no number to convert.\nPlease provide in correct format - \"<ccy1> <amount1> in <ccy2>\"";
	public static final String INVALID_FORMAT = "Wrong format. Word \"in\" is missing.\nPlease provide in correct format - \"<ccy1> <amount1> in <ccy2>\"";
	public static final String INVALID_CURRENCY = "Unable to find rate for %1$s/%2$s";	
	public static final String RESULT = "%1$s %2$s = %3$s %4$s";
}
