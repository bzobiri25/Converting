package application.converters.frequency;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class FrequencyConverter extends UnitTypeConverter 
{
	
	private static BaseUnitConverter hertzConverter = new HertzConverter();
	private static BaseUnitConverter kilohertzConverter = new KilohertzConverter();
	private static BaseUnitConverter megahertzConverter = new MegahertzConverter();
	private static BaseUnitConverter gigahertzConverter = new GigahertzConverter();




	public FrequencyConverter()
	{
		super("Hertz", new HashMap<String, BaseUnitConverter>(){
			{
				put (hertzConverter.getName(), hertzConverter);
				put (kilohertzConverter.getName(), kilohertzConverter);
				put (megahertzConverter.getName(), megahertzConverter);
				put (gigahertzConverter.getName(), gigahertzConverter);



			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Frequency";
	}
	
}
