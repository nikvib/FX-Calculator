package com.anz.fx.currency.converter.input.reader.factory;

import com.anz.fx.currency.converter.constants.InputOutputReaderContants;
import com.anz.fx.currency.converter.input.reader.ConsoleInputReader;
import com.anz.fx.currency.converter.input.reader.InputReader;

/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * Factory class to get the object of method to be used for input
 *
 */
public class InputReaderFactory {
	
	//use getReader method to get object of reader type
	   public InputReader getReaderType(String readerType){
	      if(readerType == null){
	         return null;
	      }		
	      if(readerType.equals(InputOutputReaderContants.CONSOLE)){
	         return new ConsoleInputReader();
	         
	      } 
	      
	      return null;
	   }

}
