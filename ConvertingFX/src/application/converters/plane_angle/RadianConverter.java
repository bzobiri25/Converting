package application.converters.plane_angle;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class RadianConverter extends BaseUnitConverter 
{
	public RadianConverter()
	{
		this.MULTIPLIER = new BigDecimal(57.2958);
	}
	
	
	@Override
	public String getName() 
	{
		return "Radian";
	}
	
}
