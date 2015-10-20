/**
 * 
 */
package com.headspring.fizzbuzz;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

/**
 * @author piyush
 *
 */
public class FizzBuzzTest {
	@Test	
	public void testFizzBuzzComplete() {
		Map<Integer,String> testVals = new HashMap<Integer,String>();
        testVals.put(1, "1");
        testVals.put(2, "2");
        testVals.put(3, "Fizz");
        testVals.put(4, "4");
        testVals.put(5, "Buzz");
        testVals.put(6, "Fizz");
        testVals.put(7, "7");
        testVals.put(10, "Buzz");
        testVals.put(15, "FizzBuzz");
        testVals.put(30, "FizzBuzz");
        
        
		FizzBuzz FizzBuzzTest = new FizzBuzz();	
		
		for(Integer given : testVals.keySet()){
			String expected = testVals.get(given);	
			assertEquals(FizzBuzzTest.calculateFizzBuzz(given), expected);	
		}
		    
	}
	
	@Test	
	public void testFizzBuzzCalculate() {
		int[] notMultipleOfThreeAndFive = {1, 2, 4, 7, 11, 13, 14};
		int[] multipleOfThree = {3, 6, 9, 12, 18, 21, 24};
		int[] multipleOfFive = {5, 10, 20, 25, 35, 40, 50};
		int[] multipleOfThreeAndFive = {15, 30, 45, 60};
        
        
		FizzBuzz FizzBuzzTest = new FizzBuzz();	
		
		for(int elm : notMultipleOfThreeAndFive){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), Integer.toString(elm));	
		}
		
		for(int elm : multipleOfThree){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), "Fizz");	
		}
		
		for(int elm : multipleOfFive){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), "Buzz");	
		}
		
		for(int elm : multipleOfThreeAndFive){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), "FizzBuzz");	
		}
		    
	}

	
}
