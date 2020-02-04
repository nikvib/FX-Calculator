package com.anz.fx.currency.converter;

import java.util.Scanner;

import com.anz.fx.currency.converter.calculation.CurrencyConversionCalculator;
import com.anz.fx.currency.converter.validation.InputValidation;

/**
 * <h1>Convert Currency</h1>
 * This class is the starting point of program execution for currency conversion
 * 
 * @author Vaibhav
 * 
 * @version 1.0 
 * 
 *
 */
public class CurrencyConverter {
	
	/**
	 * 
	 * Main method to read input and process them
	 * @param args input from console
	 * 
	 */
	public static void main(String[] args) {
		String[] inputs = readInputFromConsole();		
		boolean isValidInput = validateInputFormat(inputs);			
		if(isValidInput) {
			String inputCurrency = inputs[0];
			String outputCurrency = inputs[3];
			String inputAmount =  inputs[1];
			CurrencyConversionCalculator conversionCalculator = new CurrencyConversionCalculator();
			//after successful validation of inputs, calculate the currency conversion final rate
			String result = conversionCalculator.calculateCoversionRate(inputCurrency, outputCurrency, inputAmount);
			//output final result on console 
			outputFinalResult(inputCurrency,outputCurrency,inputAmount,result);		
		}
	}
	
	/**
	 * 
	 * @param inputs from console
	 * @return boolean true if input is valid
	 */
	private static boolean validateInputFormat(String[] inputs) {		
		if(!(InputValidation.isValidLength(inputs))) {
			outputFormatError();
			return false;
		}	
		if(!(InputValidation.isValidInputFormat(inputs[2], inputs[1]))) {
			outputFormatError();
			return false;
		}
		
		if(!(InputValidation.isValidCurrencyName(inputs[0],inputs[3]))) {
			outputCurrencyError(inputs[0],inputs[3]);
			return false;
		}
		return true;
	}
		
	/**
	 * Reads input line entered from console and returns string array with all inputs separated by space
	 * @return String[] of inputs separated by space 	 
	 */
	private static String[] readInputFromConsole() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		//split the inputs by space 
		String[] inputs = input.split(" ");
		return inputs;
	}	

	/** 
	 * Display error when input is given in wrong format
	 */
	private static void outputFormatError() {
		System.out.println("Input is provided in wrong format. Please provide in format - \"<ccy1> <amount1> in <ccy2>\"");		
	}
	
	/** 
	 * Display error when input is given in correct format but currency does not exists to convert
	 * @param inputCurrency
	 * @param ouptputCurrency
	 */
	private static void outputCurrencyError(String inputCurrency, String ouptputCurrency) {
		System.out.println("Unable to find rate for "+inputCurrency+"/"+ouptputCurrency);		
	}
	
	/**
	 * Display final result to user
	 *  
	 * @param inputCurrency
	 * @param outputCurrency
	 * @param inputAmount
	 * @param result
	 * 
	 *
	 */
	private static void outputFinalResult(String inputCurrency, String outputCurrency, String inputAmount, String result) {
		System.out.println(inputCurrency+" "+inputAmount+" = "+outputCurrency+" "+result);
	}

}
