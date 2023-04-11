package application.converters.mass;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class MassConverter extends UnitTypeConverter 
{
	
	private static BaseUnitConverter gramConverter = new GramConverter();
	private static BaseUnitConverter imperial_tonConverter = new Imperial_TonConverter();
	private static BaseUnitConverter kilogramConverter = new KilogramConverter();
	private static BaseUnitConverter microgramConverter = new MicrogramConverter();
	private static BaseUnitConverter milligramConverter = new MilligramConverter();
	private static BaseUnitConverter ounceConverter = new OunceConverter();
	private static BaseUnitConverter poundConverter = new PoundConverter();
	private static BaseUnitConverter stoneConverter = new StoneConverter();
	private static BaseUnitConverter tonneConverter = new TonneConverter();
	private static BaseUnitConverter us_tonConverter = new US_TonConverter();


	public MassConverter()
	{
		super("Kilogram", new HashMap<String, BaseUnitConverter>(){
			{
				put (gramConverter.getName(), gramConverter);
				put (imperial_tonConverter.getName(), imperial_tonConverter);
				put (kilogramConverter.getName(), kilogramConverter);
				put (microgramConverter.getName(), microgramConverter);
				put (milligramConverter.getName(), milligramConverter);
				put (ounceConverter.getName(), ounceConverter);
				put (poundConverter.getName(), poundConverter);
				put (stoneConverter.getName(), stoneConverter);
				put (tonneConverter.getName(), tonneConverter);
				put (us_tonConverter.getName(), us_tonConverter);

			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Mass";
	}
	
}
