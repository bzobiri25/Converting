package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class USLegalCupConverter extends BaseUnitConverter 
{
	public USLegalCupConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.24);
	}
	
	
	@Override
	public String getName() 
	{
		return "US legal cup";
	}
	
}
