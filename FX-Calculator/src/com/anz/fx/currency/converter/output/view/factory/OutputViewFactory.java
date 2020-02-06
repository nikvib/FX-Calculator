package com.anz.fx.currency.converter.output.view.factory;

import com.anz.fx.currency.converter.constants.InputOutputReaderContants;
import com.anz.fx.currency.converter.output.view.ConsoleOutputView;
import com.anz.fx.currency.converter.output.view.OutputView;


/**
 * 
 * @author Vaibhav
 * @version 1.0
 * 
 * Factory class to get the object of method to be used for output
 *
 */
public class OutputViewFactory {
	
	//use getOutputViewType method to get object of output view type
	   public OutputView getOutputViewType(String outputViewType){
	      if(outputViewType == null){
	         return null;
	      }		
	      if(outputViewType.equals(InputOutputReaderContants.CONSOLE)){
	         return new ConsoleOutputView();
	         
	      } 	      
	      return null;
	   }

}
