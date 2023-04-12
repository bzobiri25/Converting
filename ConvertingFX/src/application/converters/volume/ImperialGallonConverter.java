package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialGallonConverter extends BaseUnitConverter 
{
	public ImperialGallonConverter()
	{
		this.MULTIPLIER = new BigDecimal(4.54609);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Gallon";
	}
	
}
