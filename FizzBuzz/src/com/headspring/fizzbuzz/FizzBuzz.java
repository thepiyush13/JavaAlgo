/**
 * 
 */
package com.headspring.fizzbuzz;

/**
 * @author piyush
 *
 */
public class FizzBuzz {
	//initialize constants for the library
	private static final String FIZZ="Fizz";
	private static final String BUZZ="Buzz";
	private static final String FIZZBUZZ="FizzBuzz";
	private static final String SEPERATOR=" ";
	private static final int THREE = 3;
	private static final int FIVE = 5;
	/**
	 * 
	 */
	public FizzBuzz() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public String fizzBuzz(int intFrom , int intTo){
		//initialize variables
		String strResult = "";
		String tmpResult ;
		
		// TODO input validation 
		
		
		//loop inclusive range provided to the function
		for(int i=intFrom; i<=intTo; i++){			
		//append separator for proper result display
			strResult+= calculateFizzBuzz(i) + SEPERATOR ;
		}
		
		//return value
		return strResult;
	}
	
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
	private boolean isMultipleOf(int number, int base) {	
		 return number % base == 0;		
	}


}
