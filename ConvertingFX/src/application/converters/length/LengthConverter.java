/*
 * Auteur: Bilal Z. 
 * Description: Cela regroupe tous le conversions de tous les unités dans un unit type, 
                donc tous les base units dans le grand Unit type. C'est la meme pour tous les autres classes qui vont extend le UnitTypeConverter 
 */

package application.converters.length;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class LengthConverter extends UnitTypeConverter // Cette classe est héritée de la classe UnitTypeConverter qui indiquait comment nous pouvons convertir les unités 
{
	
	private static BaseUnitConverter meterConverter = new MeterConverter(); // Champs statiques privés. Type BaseUnitConverter donc, nous disons que c'est un BaseUnitConverter mais, nous l'implémentons en tant que MeterConverter à la place.
	private static BaseUnitConverter footConverter = new FootConverter(); // Champs statiques privés. Type BaseUnitConverter donc, nous disons que c'est un BaseUnitConverter mais, nous l'implémentons en tant que FootConverter à la place.

	public LengthConverter()
	{
		super("Meter", new HashMap<String, BaseUnitConverter>(){ // Appellera une méthode de superclasse et accédera au constructeur de la superclasse. le compteur est l'unité de base standard. Nous voulons transmettre un Hashmap de toutes les différentes conversions d'unités de base de longueur que nous avons. Nous avons donc le pied, le mètre, etc.
			{
				put (meterConverter.getName(), meterConverter); // Nous voulons transmettre la valeur String et le MeterConverter.
				put (footConverter.getName(), footConverter); // Nous voulons transmettre la valeur String et le FootConverter.
			}
		});
		
	}

	@Override
	public String getUnitType() 
	{
		return "Length"; // Cela est dans une sorte l'etiquette dans le combobox principal. Cela renverra le string "Length" dans le combo box. Donc si vous voulez choisir le length comme unit type, choisi le string "Length" car cela denote l'action de la conversion des unités du length specifiee en haut. So whenever we ask the LengthConverter what is its unit type, it will return the string "Length"
	}
	
}
