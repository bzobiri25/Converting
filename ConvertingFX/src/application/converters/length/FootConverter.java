package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class FootConverter extends BaseUnitConverter  // Cette classe est héritée de la classe BaseUnitConverter qui indiquait comment nous pouvons convertir de bse en unité et vice versa. 
{
	public FootConverter() // c'est le constructor pour le multiplier. 
	{
		this.MULTIPLIER = new BigDecimal(0.3048); // // "This." est une référence à l'objet courant — l'objet dont la méthode ou le constructeur est appelé. Donc le MULTIPLIER ou bien le taux de conversion entre BaseUnit et pied sera 0.3048.
	}
	
	
	@Override
	public String getName() 
	{
		return "Foot"; // Cela est dans un sorte l'etiquette dans le combobox du gauche et droite. Cela renverra le string "Foot" dans le combo box. Donc si vous voulez choisir pied pour convertir, choisir le string "Foot" car cela denote l'action de la conversion Foot specifiee en haut. 
	}
	
}
