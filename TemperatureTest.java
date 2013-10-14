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

public class TemperatureTest {

	/*
	 * There are three main methodes to be tested on.
	 * 1. getUnits() : Tests if getUnits() method can return all CELSIUS, KELVIN and FAHRENHEIT units
	 * 2. getValue() : Tests if getValue() method can return right values for all CELSIUS, KELVIN and FAHRENHEIT
	 * 3. convertFrom...() : 
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
		
		System.out.println("Test if the correct values of Celsius are returned");

		Temperature celsiusValue1 = new Temperature(20.12, Temperature.Units.CELSIUS);
		assertTrue(celsiusValue1.getValue() >= 20.12-(1E-6) && celsiusValue1.getValue() <= 20.12 + (1E-6));

		Temperature celsiusValue2 = new Temperature(-45.23, Temperature.Units.CELSIUS);
		assertTrue(celsiusValue2.getValue() >= -45.23-(1E-6) && celsiusValue2.getValue() <= -45.23+(1E-6));

		Temperature celsiusValue3 = new Temperature(0.0, Temperature.Units.CELSIUS);
		assertTrue(celsiusValue3.getValue() == 0.0);

		Temperature celsiusValue4 = new Temperature(-273.15, Temperature.Units.CELSIUS);
		assertTrue("Minimum celsius degree is -273.15", celsiusValue4.getValue() == -273.15);

		Temperature celsiusValue5 = new Temperature(Double.MAX_VALUE, Temperature.Units.CELSIUS);
		assertTrue(celsiusValue5.getValue() == Double.MAX_VALUE);

		Temperature celsiusValue6 = new Temperature(-300.0, Temperature.Units.CELSIUS);
		assertTrue("Cannot go under -273.15 celsius", celsiusValue6.getValue() == -300.0);

	}



	// Test case for Kelvin
	@Test
	public void test_Kelvin_getValue (){
		
		System.out.println("Test if the correct values of Kelvin are returned");

		Temperature kelvinValue1 = new Temperature(20.12, Temperature.Units.KELVIN);
		assertTrue(kelvinValue1.getValue() == 20.12);

		Temperature kelvinValue2 = new Temperature(-45.23, Temperature.Units.KELVIN);
		assertTrue("Cannot be under 0 kelvin", kelvinValue2.getValue() < 0);

		Temperature kelvinValue3 = new Temperature(0.0, Temperature.Units.KELVIN);
		assertTrue(kelvinValue3.getValue() == 0.0);

		Temperature kelvinValue4 = new Temperature(Double.MIN_VALUE, Temperature.Units.KELVIN);
		assertTrue(kelvinValue4.getValue() == Double.MIN_VALUE);
		
		Temperature kelvinValue5 = new Temperature(Double.MAX_VALUE, Temperature.Units.KELVIN);
		assertTrue(kelvinValue5.getValue() == Double.MAX_VALUE);

	}


	// Test case for Fahrenheit
	@Test
	public void test_Fahrenheit_getValue (){
		
		System.out.println("Test if the correct values of Fahrenheit are returned");

		
		Temperature fahrenheitValue1 = new Temperature(20.12, Temperature.Units.FAHRENHEIT);
		assertTrue(fahrenheitValue1.getValue() >= 20.12-(1E-6) && fahrenheitValue1.getValue() <= 20.12 + (1E-6));

		Temperature fahrenheitValue2 = new Temperature(-45.23, Temperature.Units.FAHRENHEIT);
		assertTrue(fahrenheitValue2.getValue() >= -45.23-(1E-6) && fahrenheitValue2.getValue() <= -45.23+(1E-6));

		Temperature fahrenheitValue3 = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		assertTrue(fahrenheitValue3.getValue() <= 0.0 );

		Temperature fahrenheitValue4 = new Temperature(-459.67, Temperature.Units.FAHRENHEIT);
		assertTrue("Minimum fahrenheit degree is -459.67", fahrenheitValue4.getValue() == -459.67);
		
		Temperature fahrenheitValue5 = new Temperature(Double.MAX_VALUE, Temperature.Units.KELVIN);
		assertTrue(fahrenheitValue5.getValue() == Double.MAX_VALUE);

		Temperature fahrenheitValue6 = new Temperature(-600.0, Temperature.Units.FAHRENHEIT);
		assertTrue("Cannot go under -459.67 fahrenheit ",fahrenheitValue6.getValue() == -600.0);

	}


}