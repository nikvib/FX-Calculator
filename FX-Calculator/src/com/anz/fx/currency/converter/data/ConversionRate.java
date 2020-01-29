package com.anz.fx.currency.converter.data;

/**
 * enum to hold all currency conversion available with direct rate.  
 * @author Vaibhav
 * @version 1.0
 */
public enum ConversionRate {
	
			AUDUSD(0.8371),
			CADUSD(0.8711),
			USDCNY(6.1715),
			EURUSD(1.2315),
			GBPUSD(1.5683),
			NZDUSD(0.7750),
			USDJPY(119.95),
			EURCZK(27.6028),
			EURDKK(7.4405),
			EURNOK(8.6651);
	
	private double rate;
	
	/**
	 * 
	 * @param rate
	 */
	ConversionRate(double rate){
		this.rate=rate;
	}
	
	/**
	 * 
	 * @return direct rate of enum value for currency to convert
	 */
	public double getRate() {
		return rate;
	}	
	

}
