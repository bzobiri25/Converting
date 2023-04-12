package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ImperialFluidOunceConverter extends BaseUnitConverter 
{
	public ImperialFluidOunceConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.0284131);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Fluid Ounce";
	}
	
}
