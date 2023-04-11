package application.converters.plane_angle;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class GradianConverter extends BaseUnitConverter 
{
	public GradianConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.9);
	}
	
	
	@Override
	public String getName() 
	{
		return "Gradian";
	}
	
}
