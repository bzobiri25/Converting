package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MicrogramConverter extends BaseUnitConverter 
{
	public MicrogramConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.000000001);
	}
	
	
	@Override
	public String getName() 
	{
		return "Microgram";
	}
	
}
