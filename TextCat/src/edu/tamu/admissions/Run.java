package edu.tamu.admissions;

import edu.tamu.admissions.TextCat; 

import java.io.*;
import java.util.*;
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//genKws();
		
		TextCat myTextCat = new TextCat();
		List<String> fileArray = myTextCat.fileToArray("res/input_comments.txt");
		Map<Integer, String> cats  = myTextCat.Categories();
		System.out.println("commentId,{categoryId:matchCount}");
		for(String line:fileArray){			
			String[] lineArray = line.split("\\|");
			String commentId = lineArray[0];
			String out = commentId+",";
			String comment = lineArray[1];
			List<String> comKeywords = myTextCat.textToKeywords(comment);
			Map<Integer,Integer> comToCats = myTextCat.textToCategories(comKeywords);
			
			for(int catId:comToCats.keySet()){
				//out+="{"+catId+":"+comToCats.get(catId)+"}";
				out+= cats.get(catId)+"("+comToCats.get(catId)+")";
			}
			System.out.println(out);
		}
		
		
		
		/* Map<Integer, String[]> a = myTextCat.categoryToKeywords();
		 Map<String, List<Integer>> b  =  myTextCat.keywordsToCategories(a);
		 for(String s: b.keySet()){
			 System.out.print(s+":");
			 List<Integer> c = b.get(s);
			 for(int d: c){
				 System.out.print(d+",");
			 }
			 System.out.println("");
		 }
		//printArray(b);
		//myTextCat.arrayToFile(r, "res/output_comments.txt");
		*/
		
		//printArray(b);
		
		
	}
	
	//misc tools
		public static void printArray(List<String> in){
			for(String s : in ){
				System.out.println(s);
			}
			
		}
		
		public static void genKws(){
			TextCat myTextCat = new TextCat();
			List<String> fileArray = myTextCat.fileToArray("res/input_comments.txt");
			String combined="";
			for(String line:fileArray){			
				combined+=line;				
			}
			List<String> comKeywords = myTextCat.textToKeywords(combined);
			printArray(comKeywords);
		}
		
		

}
