package application.converters.length;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class LengthConverter extends UnitTypeConverter // Cette classe est héritée de la classe UnitTypeConverter qui indiquait comment nous pouvons convertir les unités 
{
	
	private static BaseUnitConverter meterConverter = new MeterConverter(); // Private static fields. BaseUnitConverter type so, we are saying its a BaseUnitConverter but, we are implementing it as the MeterConverter instead. 
	private static BaseUnitConverter footConverter = new FootConverter(); // Private static fields. BaseUnitConverter type so, we are saying its a BaseUnitConverter but, we are implementing it as the FootConverter instead. 

	public LengthConverter()
	{
		super("Meter", new HashMap<String, BaseUnitConverter>(){ // Will call a superclass method and access the superclass constructor. le metre est le standard base unit. We want to pass in a Hashmap of all the different base unit conversions of length we have. So we Have foot, meter, etc.  
			{
				put (meterConverter.getName(), meterConverter); // We want to pass in the String value and the MeterConverter. 
				put (footConverter.getName(), footConverter); // We want to pass in the String value and the FootConverter. 
			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Length"; // Cela est dans une sorte l'etiquette dans le combobox principal. Cela renverra le string "Length" dans le combo box. Donc si vous voulez choisir le length comme unit type, choisi le string "Length" car cela denote l'action de la conversion des unités du length specifiee en haut. So whenever we ask the LengthConverter what is its unit type, it will return the string "Length"
	}
	
}
