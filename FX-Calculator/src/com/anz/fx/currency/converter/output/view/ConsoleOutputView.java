package com.anz.fx.currency.converter.output.view;

/**
 * 
 * @author Vaibhav
 * 
 * @version 1.0
 * 
 * This is OutputView implementation class and specific to display output on console
 *
 */
public class ConsoleOutputView implements OutputView {

	/**
	 * @param output to be displayed
	 * display output on console
	 */
	@Override
	public void showOutput(String output) {
		System.out.println(output);
		
	}

}
