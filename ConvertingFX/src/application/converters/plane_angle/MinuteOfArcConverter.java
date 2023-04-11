package application.converters.plane_angle;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MinuteOfArcConverter extends BaseUnitConverter 
{
	public MinuteOfArcConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.0166667);
	}
	
	
	@Override
	public String getName() 
	{
		return "Minute of Arc";
	}
	
}
