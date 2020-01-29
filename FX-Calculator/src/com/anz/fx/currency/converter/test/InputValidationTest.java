package com.anz.fx.currency.converter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.anz.fx.currency.converter.validation.InputValidation;

public class InputValidationTest {
	
	@Test
	public void testIsValidLengthTrueForCorrectInputs() {
		String[] inputs = {"AUD","100","in","USD"};		
		boolean isValidForCorrectInput = InputValidation.isValidLength(inputs);
		assertEquals(true, isValidForCorrectInput);			
	}
	
	@Test
	public void testIsValidLengthFalseForWrongInputs() {
		String[] wrongInputs = {"AUD","100","in"};
		boolean isValidForWrongInput = InputValidation.isValidLength(wrongInputs);
		assertEquals(false, isValidForWrongInput);				
	}
	
	
	@Test
	public void testIsValidInputFormatIsTrueForCorrectInputs() {		
		boolean isValidFormatForCorrectInput = InputValidation.isValidInputFormat("in", "202.2");
		assertEquals(true, isValidFormatForCorrectInput);		
	}
	
	@Test
	public void testIsValidInputFormatIsFalseForInputsWhereAmountIsNotNumber() {		
		boolean isValidFormatForWrongInput = InputValidation.isValidInputFormat("in", "test");
		assertEquals(false, isValidFormatForWrongInput);		
	}
	
	@Test
	public void testIsValidInputFormatIsFalseForInputsWhereWordInNotPresent() {		
		boolean isValidFormatForWrongInput = InputValidation.isValidInputFormat("of", "202.2");
		assertEquals(false, isValidFormatForWrongInput);		
	}
	
	@Test
	public void testIsValidCurrencyNameIsTrueForCorrectCurrencyName1() {
		boolean isValidCorrency = InputValidation.isValidCurrencyName("NOK", "JPY");
		assertEquals(true, isValidCorrency);	
	}
	
	@Test
	public void testIsValidCurrencyNameIsTrueForCorrectCurrencyName2() {
		boolean isValidCorrency = InputValidation.isValidCurrencyName("AUD", "CNY");
		assertEquals(true, isValidCorrency);	
	}
	
	@Test
	public void testIsValidCurrencyNameIsTrueForCorrectCurrencyName3() {
		boolean isValidCorrency = InputValidation.isValidCurrencyName("USD", "CZK");
		assertEquals(true, isValidCorrency);	
	}
	
	@Test
	public void testIsValidCurrencyNameIsFalseForWrongCurrencyName() {
		boolean isValidCorrency = InputValidation.isValidCurrencyName("ABC", "JPY");
		assertEquals(false, isValidCorrency);	
	}

}
