package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class USPintConverter extends BaseUnitConverter 
{
	public USPintConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.473176);
	}
	
	
	@Override
	public String getName() 
	{
		return "US Pint";
	}
	
}
