package application.converters.FuelEconomy;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KPLConverter extends BaseUnitConverter 
{
	public KPLConverter()
	{
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	
	@Override
	public String getName() 
	{
		return "Kilometer Per Liter";
	}
	
}
