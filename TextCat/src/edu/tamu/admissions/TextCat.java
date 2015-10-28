package edu.tamu.admissions;

import java.io.*;
import java.util.*;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

public class TextCat {
	//constants
	private static final Map<String, Boolean>  EXCLUDE_KW_LIST = createExcludeList();
	
	
	//fileToArray
	public List<String> fileToArray(String fileName){
		
		//open file
		List<String> listResult = new ArrayList<String>();
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader bfr = new BufferedReader(fr);
			String line;
			//read each line to an array
			while((line = bfr.readLine())!=null){
				//System.out.println(line);
				listResult.add(line);							
			}
			
			
			//close stuff
			bfr.close();
			fr.close();			
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}
		
		
		
		
		//return array
		return listResult;
		
	}
	
	//arrayToFile
	public boolean arrayToFile(List<String> inString, String fileName){
			try{
				File file = new File(fileName);
				FileWriter fw = new FileWriter(file);
				BufferedWriter bfw = new BufferedWriter(fw);
				for(String ins: inString){
					bfw.write(ins);
					bfw.newLine();					
				}
				
				bfw.close();
				fw.close();
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return false;
			}
			return true;
			
	}
	
	//textToKeywords
	public List<String> textToKeywords(String text){
		List<String> listResult  = new ArrayList<String>();
		List<String> listOut  = new ArrayList<String>();
		//do some cleanup first (replace multiple space to single space)
		text = text.trim().replaceAll(" +", " ");
		//split the text to array
		String[] textArray = text.split(" ");		
		//unique keywords
		Set<String> temp = new HashSet<String>(Arrays.asList(textArray));
		String[] uniqueArray = temp.toArray(new String[temp.size()]);
		
		//assign to result
		listResult = Arrays.asList(uniqueArray);
		//filter keywords 
		listOut =  filterKeywords(listResult, EXCLUDE_KW_LIST);
		return listOut;
	}
	
	//filterKeywords
	public List<String> filterKeywords(List<String> keywords, Map<String, Boolean> exclude){
		List<String> strResult  = new ArrayList<String>();
		
		ListIterator<String> itr = keywords.listIterator();
		while(itr.hasNext()){
			String keyword = itr.next();
			//remove special chars +,._ etc
			keyword = keyword.replaceAll("[^A-Za-z]+", "").toLowerCase();
			//only keep keywords that are not in exclude
			if(exclude.containsKey(keyword)!=true){
				strResult.add(keyword);
			}			
		}		
		return strResult;
	}
	
	//keywordsToCategories
	public Map<String, List<Integer>> keywordsToCategories(Map<Integer, String[]> in){
		Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
		//Collection<String[]> keywords = in.values();
		//flatten the array to 
		List<String> keywords = new ArrayList<String>();		
		for(String[] tempP: in.values()){
			for(String tempC:tempP){
				keywords.add(tempC);
			}
		}
		
		//for each keyword find how many categories are mapped
		for(String keyword: keywords){
			for(int catId: in.keySet()){
				//if array for this category has the keyword
				if(Arrays.asList(in.get(catId)).contains(keyword) ){
					//add this category to this keyword map
					List<Integer> temp = new ArrayList<Integer>();
					//if result already has other categories, just append 
					if(result.containsKey(keyword)){
						temp = result.get(keyword);
						//uniqify this array
						if(!temp.contains(catId)){
							temp.add(catId);
						}										
						result.put(keyword, temp);						
					}else{
						temp.add(catId);
						result.put(keyword, temp);
					}
				}
			}
		} 
		return result;
	} 
	//textToCategories
	public Map<Integer,Integer> textToCategories(List<String> keywords){
		Map<Integer,Integer> result = new HashMap<Integer,Integer>();
		Map<Integer, String[]> catsToKeys = categoryToKeywords();
		Map<String, List<Integer>> keysToCats  =  keywordsToCategories(catsToKeys);
		for(String keyword: keywords){
			 if(keysToCats.containsKey(keyword)){
				 for(int catId: keysToCats.get(keyword)){
					 if(result.containsKey(catId)){
						 result.put(catId, result.get(catId)+1);
					 }else{
						 result.put(catId, 1);
					 }
				 }
			 }
		}
		
		return result;
	}
	//creates exclusion kw list
	private static Map<String, Boolean> createExcludeList() {
		String[] avoidWords = new String[]{
				"a","about","above","after","again","against","all","am","an","and","any","are","arent","as","at","be","because","been","before","being","below","between","both","but","by","cant","cannot","could","couldnt","did","didnt","do","does","doesnt","doing","dont","down","during","each","few","for","from","further","had","hadnt","has","hasnt","have","havent","having","he","hed","hell","hes","her","here","heres","hers","herself","him","himself","his","how","hows","i","id","ill","im","ive","if","in","into","is","isnt","it","its","its","itself","lets","me","more","most","mustnt","my","myself","no","nor","not","of","off","on","once","only","or","other","ought","our","ours	ourselves","out","over","own","same","shant","she","shed","shell","shes","should","shouldnt","so","some","such","than","that","thats","the","their","theirs","them","themselves","then","there","theres","these","they","theyd","theyll","theyre","theyve","this","those","through","to","too","under","until","up","very","was","wasnt","we","wed","well","were","weve","were","werent","what","whats","when","whens","where","wheres","which","while","who","whos","whom","why","whys","with","wont","would","wouldnt","you","youd","youll","youre","youve","your","yours","yourself","yo"
				
		};
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        for(String avoidWord: avoidWords){
        	result.put(avoidWord,true);
        }
//        result.put( "this",true);
//        result.put( "is",true);
//        result.put( "the",true);
//        result.put( "and",true);
//        result.put( "to",true);
//        result.put( "and",true);
//        result.put( "also",true);
//        result.put( "i",true);
        return Collections.unmodifiableMap(result);
    }
	
	//creates categoryToKeywords Map
	public static Map<Integer, String[]> categoryToKeywords() {
		Map<Integer, String[]> result = new HashMap<Integer, String[]>();
		result.put( 1,new String[]{"i","me","my"}); //Narcissistic assholes :)
        result.put( 2,new String[]{"scholarship","aid","scholarships"});
        result.put( 3,new String[]{"school","university"});
        result.put( 4,new String[]{"me","aid","school"});
        result.put( 5,new String[]{"good","nice","fine"});
        result.put( 5,new String[]{"bad","worse","terrible"});
        return Collections.unmodifiableMap(result);
    }
	
	//creates categoryToKeywords Map
		public static Map<Integer, String> Categories() {
			Map<Integer, String> result = new HashMap<Integer, String>();
			result.put( 1,"About Me"); 
			result.put( 2,"Financial"); 
			result.put( 3,"School"); 
			result.put( 4,"combined"); 
			result.put( 5,"praise");
			result.put( 6,"Scold");
	        return Collections.unmodifiableMap(result);
	    }
		
	
	
	
}
