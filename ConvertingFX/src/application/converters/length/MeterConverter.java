/*
 * Auteur: Bilal Z. 
 * Description: C'et la classe qui va extend le BaseUnitConverter et indique l'unité de base pour la conversion. 
 * */

package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MeterConverter extends BaseUnitConverter  // Cette classe est héritée de la classe BaseUnitConverter qui indiquait comment nous pouvons convertir de bse en unité et vice versa. 
{
	public MeterConverter() // c'est le constructor pour le multiplier. 
	{
		this.MULTIPLIER = new BigDecimal(1); // "This." est une référence à l'objet courant — l'objet dont la méthode ou le constructeur est appelé. Donc le MULTIPLIER ou bien le taux de conversion d'aller du BaseUnit au metre sera 1. Cela est car le metre est le base unit donc il y a aucun conversion nécessaire. 
	}
	
	
	@Override
	public String getName() 
	{
		return "Meter"; // Cela est dans un sorte etiquette dans le combobox du gauche et droite. Cela renverra le string "Meter" dans le combo box. Donc si vous voulez choisir metre pour convertir, choisir le string "Meter" car cela denote l'action de la conversion meter specifiee en haut. 
	}
	
}
