package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class FluidOunceConverter extends BaseUnitConverter 
{
	public FluidOunceConverter()
	{
		this.MULTIPLIER = new BigDecimal(0.02957704821);
	}
	
	
	@Override
	public String getName() 
	{
		return "Fluid Ounce";
	}
	
}
