/**
 * 
 * 
 * Write a program to get a line with max word count from the given file.
 *
 */

import java.util.*;
import java.io.*;

public class Test{
	public static void main(String[] args){
		Test t = new Test();
		String fileName = "H:\\FACTORY\\chi.txt";
		System.out.println(t.maxWordCount(fileName));
		
	}


	
	public String maxWordCount( String fileName){
		if(fileName == null ){
			return "";
		}
		FileReader fr ;
		BufferedReader br ;		
		int maxCount=0;
		int tempCount;
		String maxLine = "";
		try{
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!=null){
				tempCount = line.toCharArray().length;
				if(tempCount > maxCount){
					maxCount = tempCount;
					maxLine = line;
				}

				
				
			}
			br.close();
			fr.close();
		
		
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
		
		return maxLine;

	}
	
}