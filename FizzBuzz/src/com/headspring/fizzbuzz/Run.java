/* FizzBuzz for HeadSpring
 * Copyright (c) 
 */

package com.headspring.fizzbuzz;


/** 
 * This is the runner class for FizzBuzz Class 
 * @version 1.10 20 Oct 2015
 * @author Piyush Tripathi 
 */
public class Run {
	/**
	 * This method initializes and runs the FizzBuzz Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a new instance of FizzBuzz
		FizzBuzz myFizzBuzz  = new FizzBuzz();
		
		//call function to calculate value
		String strResult = myFizzBuzz.fizzBuzz(1,100);
		
		//print value
		System.out.println(strResult);
	}

}
