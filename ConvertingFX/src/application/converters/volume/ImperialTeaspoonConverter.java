package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialTeaspoonConverter extends BaseUnitConverter 
{
	public ImperialTeaspoonConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.00591939);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Teaspoon";
	}
	
}
