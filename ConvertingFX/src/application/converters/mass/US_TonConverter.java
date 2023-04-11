package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class US_TonConverter extends BaseUnitConverter 
{
	public US_TonConverter()
	{
		this.MULTIPLIER = new BigDecimal(907.185);
	}
	
	
	@Override
	public String getName() 
	{
		return "US Ton";
	}
	
}
