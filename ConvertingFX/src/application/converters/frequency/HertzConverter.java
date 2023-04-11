package application.converters.frequency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class HertzConverter extends BaseUnitConverter 
{
	public HertzConverter()
	{
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	
	@Override
	public String getName() 
	{
		return "Hertz";
	}
	
}
