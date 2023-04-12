package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class USQuartConverter extends BaseUnitConverter 
{
	public USQuartConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.946353);
	}
	
	
	@Override
	public String getName() 
	{
		return "US Quart";
	}
	
}
