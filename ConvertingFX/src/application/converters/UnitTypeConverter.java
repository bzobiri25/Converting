package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UnitTypeConverter 
{
	private String standardBaseUnit; // This is a private field that is a string that we will call standardBaseUnit. 
	private Map<String, BaseUnitConverter> baseUnitConverters = new HashMap<>(); // 
	
	public Map<String, BaseUnitConverter> getBaseUnitConvertersMap() // This is a Hashmap called "getBaseUnitConverterMap", which is a hash table based implementation of Java's Map interface. It maps keys to values. In our case, the key is gonna be a string like "meter", and our value is going to be the BaseUnitConverter. 
	{
		return baseUnitConverters; // Returns all the base converters. Donc quand on choisi un unit type, cela nous renverra un liste de différents unités qui sont les baseUnitConverters. 
	}
	
	public List<BaseUnitConverter> getBaseUnitConvertersList() // This is a way to return just a list of all the base unit converters. So instead of a map, this is a way to return only the base converters. This will be efficient when we want to populate our drop down list of all the units.  
	{
		return new ArrayList<BaseUnitConverter>(baseUnitConverters.values()); // It will be an ArrayList of all the baseunitconverters values. 
	}
	
	public abstract String getUnitType(); // We want all the implementors of the UnitTypeConverter class to override and create this method. It has a string return type.  

	protected UnitTypeConverter(String standardBaseUnit, Map<String, BaseUnitConverter> baseUnitConverters) // The constructor. It will accept our String, which is our standardBaseUnit and it will accept the hasmap specified before. 
	{
		this.standardBaseUnit = standardBaseUnit; // This means our standardBaseUnit equals the passed in or accepted standardBaseUnit. 
		this.baseUnitConverters = baseUnitConverters; // This means our baseUnitConverters equals our passed in or accepted baseUnitConverters. 
	}
	
	public BigDecimal convert(BigDecimal value, BaseUnitConverter from, BaseUnitConverter to) // This method called "convert" will return a BigDecimal. It will convert and return a BigDecimal value, and passes in the BaseUnitConverter we are converting from to the BaseUnitConverter we are converting to. 
	{
		if(to.getName().equals(from.getName())) // if what we are converting to and what we are converting from are the same. Par ex:  we chose meter on the two combo boxes.
		{
			return value.setScale(10, RoundingMode.HALF_UP); //  we are going to return our value (for ex: if we write 4 in one text field) since no conversion is necessary. It will be rounded to the tenth nearest digit after the decimal. 
		}
		else // if what we are converting to and from is not the same.
		{
			BigDecimal base = baseUnitConverters.get(from.getName()).convertToBase(value); // First we want to convert the unit to the base unit. So we take what we are converting from and we convert to base as the line of code specifies. 
			if(to.getName().equals(standardBaseUnit)) // If what we are converting to is the base For example we are converting a foot to a meter
			{
				return base.setScale(10, RoundingMode.HALF_UP); // Then we return the base rounded to the tenth nearest decimal. 
			}
			else // If what we are converting is the not the base 
			{
				BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(base); // We need to convert from the base. This means we have this base value and we have to convert this base value to the needed unit. For example we had feet, we converted to meter so now we can convert to centimeter and the conversion is basically foot to centimeter. 
				return fromBase.setScale(10, RoundingMode.HALF_UP); //  Return the value rounded to the nearest 10th decimal. 
			}
		}
	}
}
