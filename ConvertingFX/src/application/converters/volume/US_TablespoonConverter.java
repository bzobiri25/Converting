package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class US_TablespoonConverter extends BaseUnitConverter 
{
	public US_TablespoonConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.0147867747);
	}
	
	
	@Override
	public String getName() 
	{
		return "US Tablespoon";
	}
	
}
