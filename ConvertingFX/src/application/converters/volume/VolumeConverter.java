package application.converters.volume;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class VolumeConverter extends UnitTypeConverter 
{
	
	private static BaseUnitConverter literConverter = new LiterConverter();
	private static BaseUnitConverter gallonConverter = new GallonConverter();
	private static BaseUnitConverter fluidonceConverter = new FluidOunceConverter();
	private static BaseUnitConverter US_tablespoonConverter = new US_TablespoonConverter();

	public VolumeConverter()
	{
		super("Liter", new HashMap<String, BaseUnitConverter>(){
			{
				put (literConverter.getName(), literConverter);
				put (gallonConverter.getName(), gallonConverter);
				put (fluidonceConverter.getName(), fluidonceConverter);
				put (US_tablespoonConverter.getName(), US_tablespoonConverter);


			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Volume";
	}
	
}
