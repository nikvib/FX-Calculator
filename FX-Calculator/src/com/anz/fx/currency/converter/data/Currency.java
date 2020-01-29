package com.anz.fx.currency.converter.data;

/**
 * enum to hold currency available with precision 
 * 
 * @author Vaibhav
 * @version 1.0
 */
public enum Currency {
	
			AUD(2),
			CAD(2),
			CNY(2),
			CZK(2),
			DKK(2),
			EUR(2),
			GBP(2),
			JPY(0),
			NOK(2),
			NZD(2),
			USD(2);	
	
	private int precision;	
	
	/**
	 * 
	 * @param precision
	 */
	Currency(int precision) {		
		this.precision=precision;		
	}		

	/**
	 * 
	 * @return precision of a currency
	 */
	public int getPrecision() {
		return precision;
	}	

}
