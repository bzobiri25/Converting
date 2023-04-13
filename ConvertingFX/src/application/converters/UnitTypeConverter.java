/*
 * Auteur: Bilal Z. 
 * Description: Cela est une classe abstraite. Cette classe montre comment on aura une liste 
                d'unités pour chaque type d'unité et montre davanatage les parametres de conversion,
                comme si les deux unités sont les memes of fait rien par exemple. 
 */

package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UnitTypeConverter 
{
	private String standardBaseUnit; // Ceci est un champ privé qui est une chaîne que nous appellerons standardBaseUnit.
	private Map<String, BaseUnitConverter> baseUnitConverters = new HashMap<>();  
	
	public Map<String, BaseUnitConverter> getBaseUnitConvertersMap() // Il s'agit d'un Hashmap appelé "getBaseUnitConverterMap", qui est une implémentation basée sur une table de hachage de l'interface Map de Java. Il mappe les clés aux valeurs. Dans notre cas, la clé sera une chaîne comme "meter", et notre valeur sera le BaseUnitConverter.
	{
		return baseUnitConverters; // Renvoie tous les convertisseurs de base. Ainsi, lorsque nous choisissons un type d'unité, il renverra une liste de différentes unités qui sont les baseUnitConverters.
	}
	
	public List<BaseUnitConverter> getBaseUnitConvertersList() // C'est une façon de renvoyer juste une liste de tous les convertisseurs d'unités de base. Ainsi, au lieu d'une carte, c'est un moyen de renvoyer uniquement les convertisseurs de base. Cela sera efficace lorsque nous voudrons remplir notre liste déroulante de toutes les unités.
	{
		return new ArrayList<BaseUnitConverter>(baseUnitConverters.values()); // Ce sera une ArrayList de toutes les valeurs de baseunitconverters.
	}
	
	public abstract String getUnitType(); // Nous voulons que tous les implémenteurs de la classe UnitTypeConverter remplacent et créent cette méthode. Il a un type de retour de chaîne.

	protected UnitTypeConverter(String standardBaseUnit, Map<String, BaseUnitConverter> baseUnitConverters) // Le constructeur. Il acceptera notre String, qui est notre standardBaseUnit et il acceptera le hasmap spécifié auparavant.
	{
		this.standardBaseUnit = standardBaseUnit; // Cela signifie que notre standardBaseUnit est égal à la standardBaseUnit transmise ou acceptée.
		this.baseUnitConverters = baseUnitConverters; // Cela signifie que nos baseUnitConverters sont égaux à nos baseUnitConverters transmis ou acceptés.
	}
	
	public BigDecimal convert(BigDecimal value, BaseUnitConverter from, BaseUnitConverter to) // Cette méthode appelée "convert" renverra un BigDecimal. Il convertira et renverra une valeur BigDecimal, et passera le BaseUnitConverter à partir duquel nous convertissons au BaseUnitConverter vers lequel nous convertissons.
	{
		if(to.getName().equals(from.getName())) // si ce que nous convertissons vers et ce à partir duquel nous convertissons sont les mêmes. Ex : nous avons choisi mètre sur les deux combos.
		{
			return value.setScale(10, RoundingMode.HALF_UP); // nous allons retourner notre valeur (par ex : si nous écrivons 4 dans un champ texte) puisqu'aucune conversion n'est nécessaire. Il sera arrondi au dixième chiffre le plus proche après la virgule.
		}
		else // si ce que nous convertissons vers et depuis n'est pas le même.
		{
			BigDecimal base = baseUnitConverters.get(from.getName()).convertToBase(value); // Nous voulons d'abord convertir l'unité en unité de base. Nous prenons donc ce à partir duquel nous convertissons et nous convertissons en base comme le spécifie la ligne de code.
			if(to.getName().equals(standardBaseUnit)) // Si ce que nous convertissons vers est la base. Par exemple, nous convertissons un pied en mètre
			{
				return base.setScale(10, RoundingMode.HALF_UP); // Ensuite, nous renvoyons la base arrondie au dixième décimal le plus proche.
			}
			else // Si ce que nous convertissons n'est pas la base 
			{
				BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(base); // Nous devons convertir à partir de base. Cela signifie que nous avons cette valeur de base et que nous devons convertir cette valeur de base dans l'unité nécessaire. Par exemple, nous avions des pieds, nous avons converti en mètre, donc maintenant nous pouvons convertir en centimètre et la conversion est essentiellement pied en centimètre.
				return fromBase.setScale(10, RoundingMode.HALF_UP); //  Renvoie la valeur arrondie à la 10ème décimale la plus proche.
			}
		}
	}
}
