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
	private static BaseUnitConverter US_teaspoonConverter = new US_TeaspoonConverter();
	private static BaseUnitConverter US_quartConverter = new USQuartConverter();
	private static BaseUnitConverter US_pintConverter = new USPintConverter();
	private static BaseUnitConverter US_legalcupConverter = new USLegalCupConverter();
	private static BaseUnitConverter cubicmeterConverter = new CubicMeterConverter();
	private static BaseUnitConverter milliliterConverter = new MilliliterConverter();
	private static BaseUnitConverter imperialgallonConverter = new ImperialGallonConverter();
	private static BaseUnitConverter imperialquartConverter = new ImperialQuartConverter();
	private static BaseUnitConverter imperialpintConverter = new ImperialPintConverter();
	private static BaseUnitConverter imperialcupConverter = new ImperialCupConverter();
	private static BaseUnitConverter imperialfluidounceConverter = new ImperialFluidOunceConverter();
	private static BaseUnitConverter imperialtablespoonConverter = new ImperialTablespoonConverter();
	private static BaseUnitConverter imperialteaspoonConverter = new ImperialTeaspoonConverter();





	public VolumeConverter()
	{
		super("Liter", new HashMap<String, BaseUnitConverter>(){
			{
				put (literConverter.getName(), literConverter);
				put (gallonConverter.getName(), gallonConverter);
				put (fluidonceConverter.getName(), fluidonceConverter);
				put (US_tablespoonConverter.getName(), US_tablespoonConverter);
				put (US_teaspoonConverter.getName(), US_teaspoonConverter);
				put (US_quartConverter.getName(), US_quartConverter);
				put (US_pintConverter.getName(), US_pintConverter);
				put (US_legalcupConverter.getName(), US_legalcupConverter);
				put (cubicmeterConverter.getName(), cubicmeterConverter);
				put (milliliterConverter.getName(), milliliterConverter);
				put (imperialgallonConverter.getName(), imperialgallonConverter);
				put (imperialquartConverter.getName(), imperialquartConverter);
				put (imperialpintConverter.getName(), imperialpintConverter);
				put (imperialcupConverter.getName(), imperialcupConverter);
				put (imperialfluidounceConverter.getName(), imperialfluidounceConverter);
				put (imperialtablespoonConverter.getName(), imperialtablespoonConverter);
				put (imperialteaspoonConverter.getName(), imperialteaspoonConverter);


			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Volume";
	}
	
}
