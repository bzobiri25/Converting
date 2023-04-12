package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialTablespoonConverter extends BaseUnitConverter 
{
	public ImperialTablespoonConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.0177582);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Tablespoon";
	}
	
}
