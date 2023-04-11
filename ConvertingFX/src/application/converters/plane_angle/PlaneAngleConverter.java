package application.converters.plane_angle;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;
import application.converters.FuelEconomy.KPLConverter;
import application.converters.FuelEconomy.MPGConverter;
import application.converters.FuelEconomy.MPGIConverter;
public class PlaneAngleConverter extends UnitTypeConverter 
{
		
		private static BaseUnitConverter degreeConverter = new DegreeConverter();
		private static BaseUnitConverter radianConverter = new RadianConverter();
		private static BaseUnitConverter gradianConverter = new GradianConverter();
		private static BaseUnitConverter arcsecondConverter = new ArcsecondConverter();
		private static BaseUnitConverter milliradianConverter = new MilliradianConverter();
		private static BaseUnitConverter minuteofarcConverter = new MinuteOfArcConverter();





		public PlaneAngleConverter()
		{
			super("Degree", new HashMap<String, BaseUnitConverter>(){
				{
					put (degreeConverter.getName(), degreeConverter);
					put (radianConverter.getName(), radianConverter);
					put (gradianConverter.getName(), gradianConverter);
					put (arcsecondConverter.getName(), arcsecondConverter);
					put (milliradianConverter.getName(), milliradianConverter);
					put (minuteofarcConverter.getName(), minuteofarcConverter);


				}
			});
			
		}

		@Override
		public String getUnitType() 
		{
			return "Plane Angle";
		}
		
	
}
