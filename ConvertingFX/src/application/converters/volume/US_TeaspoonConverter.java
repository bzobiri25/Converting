package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class US_TeaspoonConverter extends BaseUnitConverter 
{
	public US_TeaspoonConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.00492892);
	}
	
	
	@Override
	public String getName() 
	{
		return "US Teaspoon";
	}
	
}
