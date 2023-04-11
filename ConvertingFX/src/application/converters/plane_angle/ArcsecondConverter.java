package application.converters.plane_angle;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ArcsecondConverter extends BaseUnitConverter 
{
	public ArcsecondConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.000277778);
	}
	
	
	@Override
	public String getName() 
	{
		return "Arcsecond";
	}
	
}
