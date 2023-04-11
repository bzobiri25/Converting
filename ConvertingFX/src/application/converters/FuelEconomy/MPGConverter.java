package application.converters.FuelEconomy;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MPGConverter extends BaseUnitConverter 
{
	public MPGConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.42514295431);
	}
	
	
	@Override
	public String getName() 
	{
		return "Miles Per Gallon";
	}
	
}
