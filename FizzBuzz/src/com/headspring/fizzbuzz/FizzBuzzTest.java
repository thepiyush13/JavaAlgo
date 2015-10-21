/* FizzBuzz for HeadSpring
 * Copyright (c) 
 */
package com.headspring.fizzbuzz;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

/** 
 * This is the Junit Test class for FizzBuzz Class 
 * @version 1.10 20 Oct 2015
 * @author Piyush Tripathi 
 */
public class FizzBuzzTest {
	/**
	 * This Junit test case inputs few elements and expects correct strings
	 */
	/**
	 * 
	 */
	@Test	
	public void testFizzBuzzComplete() {
		
		//Create test value map
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
        
        // new instance of class
		FizzBuzz FizzBuzzTest = new FizzBuzz();	
		
		//test each value
		for(Integer given : testVals.keySet()){
			String expected = testVals.get(given);	
			assertEquals(FizzBuzzTest.calculateFizzBuzz(given), expected);	
		}
		    
	}
	
	/**
	 * This Junit test case tests fizzbuzz calculate function for various inputs 
	 */
	@Test	
	public void testFizzBuzzCalculate() {
		int[] notMultipleOfThreeAndFive = {1, 2, 4, 7, 11, 13, 14};
		int[] multipleOfThree = {3, 6, 9, 12, 18, 21, 24};
		int[] multipleOfFive = {5, 10, 20, 25, 35, 40, 50};
		int[] multipleOfThreeAndFive = {15, 30, 45, 60};
        
        
		FizzBuzz FizzBuzzTest = new FizzBuzz();	
		
		//Test for Numbers that are not Multiple Of Three And Five
		for(int elm : notMultipleOfThreeAndFive){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), Integer.toString(elm));	
		}
		
		//Test for Numbers that are multiple Of Three
		for(int elm : multipleOfThree){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), "Fizz");	
		}
		
		//Test for Numbers that are multiple Of Five
		for(int elm : multipleOfFive){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), "Buzz");	
		}
		
		
		//Test for Numbers that are multiple Of Three And Five
		for(int elm : multipleOfThreeAndFive){				
			assertEquals(FizzBuzzTest.calculateFizzBuzz(elm), "FizzBuzz");	
		}
		    
	}

	
}
