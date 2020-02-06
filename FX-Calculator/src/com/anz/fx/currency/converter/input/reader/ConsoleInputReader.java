package com.anz.fx.currency.converter.input.reader;

import java.util.Scanner;

/**
 * 
 * @author Vaibhav
 * 
 * @version 1.0
 * 
 * This is InputReader implementation class and specific to read input from console
 *
 */
public class ConsoleInputReader implements InputReader {

	/**
	 * Implementation of readInput.
	 * Reads input line entered from console and returns string array with all inputs separated by space
	 * @return String[] of inputs separated by space 	 
	 */
	@Override
	public String[] readInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		//split the inputs by space 
		String[] inputs = input.split(" ");
		return inputs;
	}

}
