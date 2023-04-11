package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class StoneConverter extends BaseUnitConverter 
{
	public StoneConverter()
	{
		this.MULTIPLIER = new BigDecimal(6.35029);
	}
	
	
	@Override
	public String getName() 
	{
		return "Stone";
	}
	
}
