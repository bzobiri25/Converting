package application.converters.frequency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KilohertzConverter extends BaseUnitConverter 
{
	public KilohertzConverter()
	{
		this.MULTIPLIER = new BigDecimal(1000);
	}
	
	
	@Override
	public String getName() 
	{
		return "Kilohertz";
	}
	
}
