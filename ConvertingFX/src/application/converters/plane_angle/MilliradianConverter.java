package application.converters.plane_angle;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MilliradianConverter extends BaseUnitConverter 
{
	public MilliradianConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.0572958);
	}
	
	
	@Override
	public String getName() 
	{
		return "Milliradian";
	}
	
}
