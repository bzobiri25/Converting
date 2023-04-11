package application.converters.FuelEconomy;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class FuelEconomyConverter extends UnitTypeConverter 
{
	
	private static BaseUnitConverter KPLConverter = new KPLConverter();
	private static BaseUnitConverter MPGConverter = new MPGConverter();
	private static BaseUnitConverter MPGIConverter = new MPGIConverter();



	public FuelEconomyConverter()
	{
		super("Kilometer Per Liter", new HashMap<String, BaseUnitConverter>(){
			{
				put (KPLConverter.getName(), KPLConverter);
				put (MPGConverter.getName(), MPGConverter);
				put (MPGIConverter.getName(), MPGIConverter);

			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Fuel Economy";
	}
	
}
