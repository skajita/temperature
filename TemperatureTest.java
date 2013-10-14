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
	 * 1. getUnits() : Tests if getUnits() method can return all KELVIN, CELSIUS and FAHRENHEIT units
	 * 2. getValue()
	 * 3. convertFrom...() 
	 */


	/* Test the method getUnits() */

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
	

}