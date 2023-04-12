package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class CubicMeterConverter extends BaseUnitConverter 
{
	public CubicMeterConverter()
	{
		this.MULTIPLIER = new BigDecimal(1000);
	}
	
	
	@Override
	public String getName() 
	{
		return "Cubic Meter";
	}
	
}
