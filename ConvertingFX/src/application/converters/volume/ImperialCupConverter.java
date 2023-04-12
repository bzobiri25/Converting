package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialCupConverter extends BaseUnitConverter 
{
	public ImperialCupConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.284131);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Cup";
	}
	
}
