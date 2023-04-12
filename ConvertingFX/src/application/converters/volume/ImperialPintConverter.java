package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialPintConverter extends BaseUnitConverter 
{
	public ImperialPintConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.568261);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Pint";
	}
	
}
