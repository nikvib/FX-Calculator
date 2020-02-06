package com.anz.fx.currency.converter;

import com.anz.fx.currency.converter.constants.InputOutputReaderContants;
import com.anz.fx.currency.converter.exception.CurrencyInputFormatException;
import com.anz.fx.currency.converter.input.reader.InputReader;
import com.anz.fx.currency.converter.input.reader.factory.InputReaderFactory;
import com.anz.fx.currency.converter.input.validation.InputValidation;
import com.anz.fx.currency.converter.output.view.OutputView;
import com.anz.fx.currency.converter.output.view.factory.OutputViewFactory;
import com.anz.fx.currency.converter.service.CurrencyConversionService;
import com.anz.fx.currency.converter.service.CurrencyConversionServiceImpl;

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
		
		//read input
		String[] inputs = readInputs();
		
		//validate input
		String errorMessage = validateInputs(inputs);
		
		//get conversion rate and display output
		if(errorMessage == null) {
			String result = calculateRate(inputs, errorMessage);	
			displayOutput(result);
		}
		
		//if error is present then display error
		else {
			displayOutput(errorMessage);
		}
		
	}

	/**
	 * 
	 * @param inputs
	 * @param errorMessage
	 * @return Result (Output)
	 */
	private static String calculateRate(String[] inputs, String errorMessage) {
		CurrencyConversionService currencyConversionService = CurrencyConversionServiceImpl.getInstance();
		String inputCurrency= inputs[0];
		String outputCurrency= inputs[3];
		String amount= inputs[1];
		String result = currencyConversionService.calculateCoversionRate(inputCurrency, outputCurrency, amount);
		return result;		
	}
	
	/**
	 * 
	 * @return String[] as input Array
	 */
	private static String[] readInputs() {
		InputReaderFactory inputReaderFactory = new InputReaderFactory();
		InputReader readerType = inputReaderFactory.getReaderType(InputOutputReaderContants.CONSOLE);
		String[] inputs = readerType.readInput();
		return inputs;
	}
	
	/**
	 * 
	 * @param inputs
	 * @return Error message if exception is thrown
	 */
	private static String validateInputs(String[] inputs) {
		InputValidation vaildation = new InputValidation();
		String errorMessage = null;
		try {
			errorMessage = vaildation.validateInput(inputs);
		} catch (CurrencyInputFormatException e) {			
			errorMessage = e.getMessage();
		}
		return errorMessage;
	}

	/**
	 * This method displays output to user
	 * @param result
	 */
	private static void displayOutput(String result) {
		OutputViewFactory outputViewFactory = new OutputViewFactory();
		OutputView outputViewType = outputViewFactory.getOutputViewType(InputOutputReaderContants.CONSOLE);		
		outputViewType.showOutput(result);		
	}	

}
