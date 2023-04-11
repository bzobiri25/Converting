// Ceci est une classe abstraite

package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BaseUnitConverter // Ce BaseUnitConverter doit avoir une sorte de multiplicateur, de cette façon tous les différents enfants (différentes unités que nous voulons convertir) de ce BaseUnitConverter vont essentiellement devoir "override" ce multiplicateur. Cela va être essentiellement le multiplicateur donc le taux de conversion pour aller et venir de ce type d'unité de base standardisée (par exemple : le mètre dans la conversion de longueur).
{
	protected BigDecimal MULTIPLIER; // "Protected" spécifie que le membre n'est accessible que dans son propre package (comme avec package-private) et, en plus, par une sous-classe de sa classe dans un autre package. Nous utiliserons "BigDecimal" de la bibliothèque java.math car cela nous aide avec des conversions très précises, comme fournir des opérations d'arrondi, de conversion de format et de hachage que nous utiliserons. Enfin, MULTIPLICATEUR est le nom de la variable que nous utiliserons pour désigner ces taux de conversion qui se différencient selon l'unité (ex : passer du mètre au centimètre n'est pas la même chose que passer du mètre au kilomètre).
	
	public abstract String getName(); // Chaque type de BaseUnitConverter devra savoir à quoi ressemble son nom s'il s'agit d'un litre, d'un gallon ou d'une tasse. c'est une classe "abstraite publique" car cela signifie que c'est une classe qui ne peut pas être instanciée, ce qui signifie que vous ne pouvez pas créer de nouvelles instances d'une classe abstraite. Par conséquent, ce nom que nous attribuons à l'unité est défini par défaut et ne peut pas être modifié. Cette classe renvoie une chaîne (le nom de l'unité). La méthode s'appelle "getName"
	
	public BigDecimal convertToBase(BigDecimal value) //Cela convertira le numéro reçu dans l'unité de base. (Par exemple : pied en mètre). Il renverra un BigDecimal (un nombre décimal signé de précision arbitraire immuable). La méthode s'appellera "ConvertToBase". Il acceptera un BigDecimal.
	{
		return value.multiply(MULTIPLIER).setScale(10, RoundingMode.HALF_UP); // Il renverra la valeur BigDecimal acceptée multipliée par la variable MULTIPLIER, qui est le taux de conversion de l'unité à l'unité de base (comme du pied au mètre). En réglant l'échelle sur 10, il ne renverra que les 10 premiers chiffres significatifs et quelles que soient les décimales restantes, il l'arrondira au 10ème chiffre le plus proche.
	}
	
	public BigDecimal convertFromBase(BigDecimal value) // Cela convertira l'unité de base en l'unité souhaitée. (Par exemple : du mètre au pied). Encore une fois, il acceptera une valeur BigDecimal (étant la quantité de l'unité de base) et renverra une valeur BigDecimal (nombre converti en une autre unité).
	{
		return value.divide(MULTIPLIER, 10, RoundingMode.HALF_UP); // Il renverra la valeur BigDecimal acceptée divisée par la variable MULTIPLIER. Puisque passer de l'unité à l'unité de base on multiplie par le MULTIPLICATEUR, pour faire le contraire il faut diviser la valeur par le MULTIPLICATEUR. En réglant l'échelle sur 10, il ne renverra que les 10 premiers chiffres significatifs, et quelles que soient les décimales restantes, il l'arrondira au 10ème chiffre le plus proche.
	}
	
}
