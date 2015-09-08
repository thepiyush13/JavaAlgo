import java.util.*;

public class Test{
	public static void main(String[] args){
			int[] intArray = new int[50];
					for(int i =0;i<50;i++){
								intArray[i] = i;
										}
												
														Test t = new Test();
																Integer result = t.findDuplicate(intArray,0);
																		System.out.println(result);
																				
																						
																							}

																								public Integer findDuplicate(int[] sourceArray, int findValue){
																										if(findValue==0 || sourceArray.length==0){
																													return findValue;
																															}
																																	
																																			Map<Integer,Boolean>  h = new HashMap<Integer, Boolean>();
																																					
																																							for(int i = 0; i<sourceArray.length;i++){
																																										h.put(i, true);
																																												}
																																														
																																																if(h.containsKey(findValue)){
																																																			return findValue;
																																																					}
																																																							else{
																																																										return null;
																																																												}
																																																													
																																																														}
																																																															
																																																															}
