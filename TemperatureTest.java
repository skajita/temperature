/** 
 * 
 * EDITED BY: Saki Kajita 260196937
 * 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 * 
 */



import org.junit.* ;
import static org.junit.Assert.* ;
import org.junit.rules.ExpectedException;

public class TemperatureTest {
	
	   @Rule
       public ExpectedException thrown = ExpectedException.none();

	/*
	 * There are three main methodes to be tested on.
	 * 1. getUnits() : Tests if getUnits() method can return all CELSIUS, KELVIN and FAHRENHEIT units
	 * 2. getValue() : Tests if getValue() method can return right values for all CELSIUS, KELVIN and FAHRENHEIT
	 * 3. convertFrom...() : Tests if converting from one case to another is performed correctly
	 */


	/* Test the method getUnits() 
	 * 
	 * There are 3 test cases:
	 * 1. Celsius unit
	 * 2. Kelvin unit
	 * 3. Fahrenheit unit
	 */

	@Test
	public void test_getUnits(){

		System.out.println("Testing if the right temperature units are returned");

		// Test case for CELSIUS unit
		Temperature celsiusUnit = new Temperature(0.0, Temperature.Units.CELSIUS);
		assertTrue(celsiusUnit.getUnits() == Temperature.Units.CELSIUS);

		// Test case for KELVIN unit
		Temperature kelvinUnit = new Temperature(0.0, Temperature.Units.KELVIN);
		assertTrue(kelvinUnit.getUnits() == Temperature.Units.KELVIN);

		// Test case for FAHRENHEIT unit
		Temperature fahrenheitUnit = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		assertTrue(fahrenheitUnit.getUnits() == Temperature.Units.FAHRENHEIT);

	}

	/* Test the method getValues() 
	 * 
	 * There are at least 5 cases tested for each temperature units:
	 * 1. Positive non-zero values
	 * 2. Negative values 
	 * 3. Zero
	 * 4. Minimum value for that temperature unit
	 * 5. Maximum value possible (in all cases, it's the maximum of a double)
	 * 6. If there is a special case (ex. out of bounds)
	 */

	// Test case for Celsius
	@Test
	public void test_Celsius_getValue (){ 
		
		System.out.println("Testing if the correct values of Celsius are returned");

		Temperature celsiusValue1 = new Temperature(20.12, Temperature.Units.CELSIUS);
		assertEquals("Should return 20.12", 20.12, celsiusValue1.getValue(), 0.0000001);

		Temperature celsiusValue2 = new Temperature(-45.23, Temperature.Units.CELSIUS);
		assertEquals("Should return -45.23", -45.23, celsiusValue2.getValue(), 0.0000001);
		
		Temperature celsiusValue3 = new Temperature(0.0, Temperature.Units.CELSIUS);
		assertEquals("Should return 0.0", 0.0, celsiusValue3.getValue(), 0.0000001);
		
		Temperature celsiusValue4 = new Temperature(-273.15, Temperature.Units.CELSIUS);
		assertEquals("Minimum celsius degree is -273.15", -273.15, celsiusValue4.getValue(), 0.0000001);

		Temperature celsiusValue5 = new Temperature(Double.MAX_VALUE, Temperature.Units.CELSIUS);
		assertEquals("Should return the maximum number of double", Double.MAX_VALUE, celsiusValue5.getValue(), 0.0000001);

		thrown.expect(IllegalArgumentException.class); //Catch the IllegalArgumentException
		Temperature celsiusValue6 = new Temperature(-300.0, Temperature.Units.CELSIUS);
		assertEquals("Cannot go under -273.15 celsius", -300.0, celsiusValue6.getValue(), 0.0000001);

	}



	// Test case for Kelvin
	@Test
	public void test_Kelvin_getValue (){
		
		System.out.println("Testing if the correct values of Kelvin are returned");

		Temperature kelvinValue1 = new Temperature(20.12, Temperature.Units.KELVIN);
		assertEquals("Should return 20.12", 20.12, kelvinValue1.getValue(), 0.0000001);

		thrown.expect(IllegalArgumentException.class); //Catch the IllegalArgumentException
		Temperature kelvinValue2 = new Temperature(-45.23, Temperature.Units.KELVIN);
		assertEquals("Cannot be under 0 kelvin", -45.23, kelvinValue2.getValue(), 0.0000001);

		Temperature kelvinValue3 = new Temperature(0.0, Temperature.Units.KELVIN);
		assertEquals("Should return 0.0", 0.0, kelvinValue3.getValue(), 0.0000001);

		Temperature kelvinValue4 = new Temperature(Double.MIN_VALUE, Temperature.Units.KELVIN);
		assertEquals("Should return the minimum number of double", Double.MIN_VALUE, kelvinValue4.getValue(), 0.0000001);
		
		Temperature kelvinValue5 = new Temperature(Double.MAX_VALUE, Temperature.Units.KELVIN);
		assertEquals("Should return the maximum number of double", Double.MAX_VALUE, kelvinValue5.getValue(), 0.0000001);

	}


	// Test case for Fahrenheit
	@Test
	public void test_Fahrenheit_getValue (){
		
		System.out.println("Testing if the correct values of Fahrenheit are returned");
		
		Temperature fahrenheitValue1 = new Temperature(20.12, Temperature.Units.FAHRENHEIT);
		assertEquals("Should return 20.12", 20.12, fahrenheitValue1.getValue(), 0.0000001);

		Temperature fahrenheitValue2 = new Temperature(-45.23, Temperature.Units.FAHRENHEIT);
		assertEquals("Should return -45.23", -45.23, fahrenheitValue2.getValue(), 0.0000001);

		Temperature fahrenheitValue3 = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		assertEquals("Should return 0.0", 0.0, fahrenheitValue3.getValue(), 0.0000001);

		Temperature fahrenheitValue4 = new Temperature(-459.67, Temperature.Units.FAHRENHEIT);
		assertEquals("Minimum fahrenheit degree is -459.67", -459.67, fahrenheitValue4.getValue(), 0.0000001);		

		thrown.expect(IllegalArgumentException.class); //Catch the IllegalArgumentException
		Temperature fahrenheitValue5 = new Temperature(-600.0, Temperature.Units.FAHRENHEIT);
		assertEquals("Cannot go below -459.67 fahrenheit",-600.0, fahrenheitValue5.getValue(), 0.0000001);

	}
	
	
	/* Test the method convertFrom()  
	 * 
	 * There are 6 conversions to be tested on, and for each conversion we will verify:
	 * 1. positive values
	 * 2. negative values
	 * 3. boundary conditions 
	 */
	
	// Test cases for converting celsius to kelvin
	   @Test
	   public void test_celsiusToKelvin(){
		   
		   System.out.println("Testing if conversion from celsius to kelvin returns the correct values and units");
		   
		   Temperature positiveCelsiusToKelvin = new Temperature(20.12, Temperature.Units.CELSIUS);
		   positiveCelsiusToKelvin.changeUnits(Temperature.Units.KELVIN);
		   assertEquals("Temperature should be 293.27", 293.27, positiveCelsiusToKelvin.getValue(), 0.0000001);
		   assertTrue("Unit should be K", positiveCelsiusToKelvin.getUnits() == Temperature.Units.KELVIN);

		   Temperature negativeCelsiusToKelvin = new Temperature(-45.23, Temperature.Units.CELSIUS);
		   negativeCelsiusToKelvin.changeUnits(Temperature.Units.KELVIN);
		   assertEquals("Temperature should be 227.92", 227.92, negativeCelsiusToKelvin.getValue(), 0.0000001);
		   assertTrue("Unit should be K", negativeCelsiusToKelvin.getUnits() == Temperature.Units.KELVIN);

		   Temperature minimumCelsiusToKelvin = new Temperature(-273.15, Temperature.Units.CELSIUS);
		   minimumCelsiusToKelvin.changeUnits(Temperature.Units.KELVIN);
		   assertEquals("Temperature should be 0.0", 0.0, minimumCelsiusToKelvin.getValue(), 0.0000001);
		   assertTrue("Unit should be K", minimumCelsiusToKelvin.getUnits() == Temperature.Units.KELVIN);
		   
	   }
	   

	   // Test cases for converting kelvin to celsius
	   @Test
	   public void test_kelvinToCelsius(){

		   System.out.println("Testing if conversion from kelvin to celsius returns the correct values and units");

		   Temperature positiveKelvinToCelsius = new Temperature(20.12, Temperature.Units.KELVIN);
		   positiveKelvinToCelsius.changeUnits(Temperature.Units.CELSIUS);
		   assertEquals("Temperature should be -253.03", -253.03, positiveKelvinToCelsius.getValue(), 0.0000001);
		   assertTrue("Unit should be C", positiveKelvinToCelsius.getUnits() == Temperature.Units.CELSIUS);
		   
		   Temperature minimumKelvinToCelsius = new Temperature(0.0, Temperature.Units.KELVIN);
		   minimumKelvinToCelsius.changeUnits(Temperature.Units.CELSIUS);
		   assertEquals("Temperature should be -273.15", -273.15, minimumKelvinToCelsius.getValue(), 0.0000001);
		   assertTrue("Unit should be C", minimumKelvinToCelsius.getUnits() == Temperature.Units.CELSIUS);
		   
		   thrown.expect(IllegalArgumentException.class); //Catch the IllegalArgumentException
		   Temperature negativeKelvinToCelsius = new Temperature(-40.23, Temperature.Units.KELVIN);
		   negativeKelvinToCelsius.changeUnits(Temperature.Units.CELSIUS);
		   assertEquals("Cannot be under 0 kelvin", -40.23, negativeKelvinToCelsius.getValue(), 0.0000001);
		   assertTrue("Unit should be C", negativeKelvinToCelsius.getUnits() == Temperature.Units.CELSIUS);
		   
	   }
	   
	   
	// Test cases for converting celsius to fahrenheit
	   @Test
	   public void test_celsiusToFahrenheit(){
		   
		   System.out.println("Testing if conversion from celsius to fahrenheit returns the correct values and units");
		   
		   Temperature positiveCelsiusToFahrenheit = new Temperature(20.12, Temperature.Units.CELSIUS);
		   positiveCelsiusToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		   assertEquals("Temperature should be 68.216", 68.216, positiveCelsiusToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", positiveCelsiusToFahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		   
		   Temperature negativeCelsiusToFahrenheit = new Temperature(-40.23, Temperature.Units.CELSIUS);
		   negativeCelsiusToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		   assertEquals("Temperature should be -40.414", -40.414, negativeCelsiusToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", negativeCelsiusToFahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		   
		   Temperature minimumCelsiusToFahrenheit = new Temperature(-273.15, Temperature.Units.CELSIUS);
		   minimumCelsiusToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		   assertEquals("Temperature should be -459.67", -459.67, minimumCelsiusToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", minimumCelsiusToFahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		   
	   }
	   
	// Test cases for converting fahrenheit to celsius
	   @Test
	   public void test_fahrenheitToCelsius(){
		   
		   System.out.println("Testing if conversion from fahrenheit to celsius returns the correct values and units");
		   
		   Temperature positiveFahrenheitToCelsius = new Temperature(20.12, Temperature.Units.FAHRENHEIT);
		   positiveFahrenheitToCelsius.changeUnits(Temperature.Units.CELSIUS);
		   assertEquals("Temperature should be -6.6", -6.6, positiveFahrenheitToCelsius.getValue(), 0.0000001);
		   assertTrue("Unit should be F", positiveFahrenheitToCelsius.getUnits() == Temperature.Units.CELSIUS);
		   
		   Temperature negativeFahrenheitToCelsius = new Temperature(-40.23, Temperature.Units.FAHRENHEIT);
		   negativeFahrenheitToCelsius.changeUnits(Temperature.Units.CELSIUS);
		   assertEquals("Temperature should be -40.1277777", -40.1277777, negativeFahrenheitToCelsius.getValue(), 0.0000001);
		   assertTrue("Unit should be F", negativeFahrenheitToCelsius.getUnits() == Temperature.Units.CELSIUS);
		   
		   Temperature minimumCelsiusToFahrenheit = new Temperature(-459.67, Temperature.Units.FAHRENHEIT);
		   minimumCelsiusToFahrenheit.changeUnits(Temperature.Units.CELSIUS);
		   assertEquals("Temperature should be -273.15", -273.15, minimumCelsiusToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", minimumCelsiusToFahrenheit.getUnits() == Temperature.Units.CELSIUS);

	   }
	   
	   
	// Test cases for converting kelvin to fahrenheit
	   @Test
	   public void test_kelvinToFahrenheit(){
		   
		   System.out.println("Testing if conversion from kelvin to fahrenheit returns the correct values and units");
		   
		   Temperature positiveKelvinToFahrenheit = new Temperature(20.12, Temperature.Units.KELVIN);
		   positiveKelvinToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		   assertEquals("Temperature should be -423.454", -423.454, positiveKelvinToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", positiveKelvinToFahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		   
		   Temperature minimumKelvinToFahrenheit = new Temperature(0.0, Temperature.Units.KELVIN);
		   minimumKelvinToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		   assertEquals("Temperature should be -459.67", -459.67, minimumKelvinToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", minimumKelvinToFahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		   
		   thrown.expect(IllegalArgumentException.class); //Catch the IllegalArgumentException
		   Temperature negativeKelvinToFahrenheit = new Temperature(-40.23, Temperature.Units.KELVIN);
		   negativeKelvinToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		   assertEquals("Cannot be under 0 kelvin", -482.02, negativeKelvinToFahrenheit.getValue(), 0.0000001);
		   assertTrue("Unit should be F", negativeKelvinToFahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		   
	   }
	  
	   
	// Test cases for converting fahrenheit to kelvin 
	   @Test
	   public void test_fahrenheitToKelvin(){
		   
		   System.out.println("Testing if conversion from fahrenheit to kelvin returns the correct values and units");

		   Temperature positiveFahrenheitToKelvin = new Temperature(20.12, Temperature.Units.FAHRENHEIT);
		   positiveFahrenheitToKelvin.changeUnits(Temperature.Units.KELVIN);
		   assertEquals("Temperature should be 266.55", 266.55, positiveFahrenheitToKelvin.getValue(), 0.0000001);
		   assertTrue("Unit should be K", positiveFahrenheitToKelvin.getUnits() == Temperature.Units.KELVIN);

		   Temperature negativeFahrenheitToKelvin = new Temperature(-45.23, Temperature.Units.FAHRENHEIT);
		   negativeFahrenheitToKelvin.changeUnits(Temperature.Units.KELVIN);
		   assertEquals("Temperature should be 230.24444444", 230.24444444, negativeFahrenheitToKelvin.getValue(), 0.0000001);
		   assertTrue("Unit should be K", negativeFahrenheitToKelvin.getUnits() == Temperature.Units.KELVIN);

		   Temperature minimumFahrenheitToKelvin = new Temperature(-459.67, Temperature.Units.FAHRENHEIT);
		   minimumFahrenheitToKelvin.changeUnits(Temperature.Units.KELVIN);
		   assertEquals("Temperature should be 0.0", 0.0, minimumFahrenheitToKelvin.getValue(), 0.0000001);
		   assertTrue("Unit should be K", minimumFahrenheitToKelvin.getUnits() == Temperature.Units.KELVIN);
		   
	   }
	   
}