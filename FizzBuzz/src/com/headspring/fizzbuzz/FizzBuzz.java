/* FizzBuzz for HeadSpring
 * Copyright (c) 
 */
package com.headspring.fizzbuzz;

/** 
 * This is the main class for FizzBuzz Calculation 
 * @version 1.10 20 Oct 2015
 * @author Piyush Tripathi 
 */
public class FizzBuzz {
	/* Initialize constants for the library */
	private static final String FIZZ="Fizz";
	private static final String BUZZ="Buzz";
	private static final String FIZZBUZZ="FizzBuzz";
	private static final String SEPERATOR=" ";
	private static final int THREE = 3;
	private static final int FIVE = 5;

	/**
	 * This method combines various numbers and string and returns the final output
	 * @param intFrom
	 * @param intTo
	 * @return String containing numbers and conditional strings
	 */
	public String fizzBuzz(int intFrom , int intTo){
		//initialize variables
		String strResult = "";
		
		
		/* TODO input validation  */ 
		
		
		//loop inclusive range provided to the function
		for(int i=intFrom; i<=intTo; i++){			
		//append separator for proper result display
			strResult+= calculateFizzBuzz(i) + SEPERATOR ;
		}
		
		//return value
		return strResult;
	}
	
	/**
	 * This method takes a number and returns related string
	 * @param number
	 * @return fizz, buzz, fizzbuzz or the number
	 */
	public String calculateFizzBuzz(int number){
		String strResult  = "";
		if(number==0){
			strResult+= number;
		}
		else if(isMultipleOf(number,THREE) && isMultipleOf(number,FIVE)){				
			strResult =  FIZZBUZZ;
		}else if(isMultipleOf(number,FIVE)){
			strResult =  BUZZ;				
		}else if(isMultipleOf(number,THREE)){
			strResult = FIZZ;
		}else{
			strResult+=number;
		}		
		return strResult;
		
	}
	/**
	 * This method checks if the number is multiple of base
	 * @param number the number to be checked
	 * @param base the base number
	 * @return true if multiple, false otherwise
	 */
	private boolean isMultipleOf(int number, int base) {	
		 return number % base == 0;		
	}


}
