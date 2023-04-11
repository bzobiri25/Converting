package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class TonneConverter extends BaseUnitConverter 
{
	public TonneConverter()
	{
		this.MULTIPLIER = new BigDecimal(1000);
	}
	
	
	@Override
	public String getName() 
	{
		return "Tonne";
	}
	
}
