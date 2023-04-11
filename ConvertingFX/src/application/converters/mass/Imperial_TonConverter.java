package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class Imperial_TonConverter extends BaseUnitConverter 
{
	public Imperial_TonConverter()
	{
		this.MULTIPLIER = new BigDecimal(1016.05);
	}
	
	
	@Override
	public String getName() 
	{
		return "Imperial Ton";
	}
	
}
