package application.converters.frequency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MegahertzConverter extends BaseUnitConverter 
{
	public MegahertzConverter()
	{
		this.MULTIPLIER = new BigDecimal(1000000);
	}
	
	
	@Override
	public String getName() 
	{
		return "Megahertz";
	}
	
}
