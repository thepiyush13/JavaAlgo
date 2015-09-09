/**
 * 
 * 
 * Wrie a program to find out duplicate characters in a string.
 *
 */

import java.util.*;
import java.io.*;

public class Test{
	public static void main(String[] args){
		Test t = new Test();
		String data = "Wrie a program to find out duplicate characters in a string";
		System.out.println(t.findDups(data));
		
	}


	
	public String findDups( String MyString){
		if(MyString == null ){
			return "";
		}
		String dups = "";
		
		char[] a ;
		Map<Character,Boolean> result = new HashMap<Character,Boolean>();
		Map<Character, Boolean> b = new HashMap<Character, Boolean>();
		
		a = MyString.toCharArray();
		
		for(char elm : a){
			if(b.containsKey(elm)){
				if(result.containsKey(elm)!=true){
					result.put(elm, true);
				}
			}
			b.put(elm, true);
			
		
		}
		
		
		for(Character c : result.keySet()){
			dups= dups + c;
		}
		return dups;
		
		
		
	}
	
}