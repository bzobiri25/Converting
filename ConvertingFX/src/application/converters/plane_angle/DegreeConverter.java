package application.converters.plane_angle;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class DegreeConverter extends BaseUnitConverter 
{
	public DegreeConverter()
	{
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	
	@Override
	public String getName() 
	{
		return "Degree";
	}
	
}
