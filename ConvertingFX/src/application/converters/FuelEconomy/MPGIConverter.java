package application.converters.FuelEconomy;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MPGIConverter extends BaseUnitConverter 
{
	public MPGIConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.354006);
	}
	
	
	@Override
	public String getName() 
	{
		return "Miles Per Gallon (Imperial)";
	}
	
}
