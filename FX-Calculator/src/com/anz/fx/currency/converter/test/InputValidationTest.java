package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.anz.fx.currency.converter.exception.CurrencyInputFormatException;
import com.anz.fx.currency.converter.input.validation.InputValidation;

public class InputValidationTest {
	
	private InputValidation inputValidation = null;
	
	@Before
	public void createInstance(){
		inputValidation = new InputValidation();
	}
	
	@Test(expected = CurrencyInputFormatException.class)
	public void testValidateInputForInvalidLengthExpenctedToThrowException() throws CurrencyInputFormatException {
		String[] wrongLengthInputs = {"AUD","100","in"};
		inputValidation.validateInput(wrongLengthInputs);			
	}
	
	@Test(expected = CurrencyInputFormatException.class)
	public void testValidateInputForInvalidCurrencyExpenctedToThrowException() throws CurrencyInputFormatException {
		String[] wrongLengthInputs = {"ABC","100","in","USD"};
		inputValidation.validateInput(wrongLengthInputs);			
	}
	
	@Test(expected = CurrencyInputFormatException.class)
	public void testValidateInputForInvalidNumberExpenctedToThrowException() throws CurrencyInputFormatException {
		String[] wrongLengthInputs = {"ABC","AA","in","USD"};
		inputValidation.validateInput(wrongLengthInputs);			
	}
	
	@Test(expected = CurrencyInputFormatException.class)
	public void testValidateInputForInvalidFormatExpenctedToThrowException() throws CurrencyInputFormatException {
		String[] wrongLengthInputs = {"ABC","100","of","USD"};
		inputValidation.validateInput(wrongLengthInputs);			
	}
	
	@Test
	public void testIsValidLengthTrueForCorrectInputs() {
		String[] inputs = {"AUD","100","in","USD"};		
		boolean isValidForCorrectInput = inputValidation.isValidLength(inputs);
		assertEquals(true, isValidForCorrectInput);			
	}
	
	@Test
	public void testIsValidLengthFalseForWrongInputs() {
		String[] wrongInputs = {"AUD","100","in"};
		boolean isValidForWrongInput = inputValidation.isValidLength(wrongInputs);
		assertEquals(false, isValidForWrongInput);				
	}
	
	
	@Test
	public void testIsValidInputFormatIsTrueForCorrectInputs() {		
		boolean isValidFormatForCorrectInput = inputValidation.isValidInputFormat("in");
		assertEquals(true, isValidFormatForCorrectInput);		
	}	
	
	
	@Test
	public void testIsValidInputFormatIsFalseForInputsWhereWordInNotPresent() {		
		boolean isValidFormatForWrongInput = inputValidation.isValidInputFormat("of");
		assertEquals(false, isValidFormatForWrongInput);		
	}
	
	@Test
	public void testIsValidCurrencyNameIsTrueForCorrectCurrencyName1() {
		boolean isValidCorrency = inputValidation.isValidCurrencyName("NOK", "JPY");
		assertEquals(true, isValidCorrency);	
	}
	
	@Test
	public void testIsValidCurrencyNameIsTrueForCorrectCurrencyName2() {
		boolean isValidCorrency = inputValidation.isValidCurrencyName("AUD", "CNY");
		assertEquals(true, isValidCorrency);	
	}
	
	@Test
	public void testIsValidCurrencyNameIsTrueForCorrectCurrencyName3() {
		boolean isValidCorrency = inputValidation.isValidCurrencyName("USD", "CZK");
		assertEquals(true, isValidCorrency);	
	}
	
	@Test
	public void testIsValidCurrencyNameIsFalseForWrongCurrencyName() {
		boolean isValidCorrency = inputValidation.isValidCurrencyName("ABC", "JPY");
		assertEquals(false, isValidCorrency);	
	}

}
