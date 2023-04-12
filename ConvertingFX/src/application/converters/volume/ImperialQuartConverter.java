package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialQuartConverter extends BaseUnitConverter 
{
	public ImperialQuartConverter()
	{
		this.MULTIPLIER = new BigDecimal(1.13652);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Quart";
	}
	
}
