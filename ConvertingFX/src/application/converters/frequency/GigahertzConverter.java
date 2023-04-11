package application.converters.frequency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class GigahertzConverter extends BaseUnitConverter 
{
	public GigahertzConverter()
	{
		this.MULTIPLIER = new BigDecimal(1000000000);
	}
	
	
	@Override
	public String getName() 
	{
		return "Gigahertz";
	}
	
}
