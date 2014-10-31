import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;
import java.util.ListIterator;


public class LinkLists {

	
	public static void main(String[] args) {
		
		LinkedList myll = GetRandLL();
		print(myll);
		one(myll);
		
		
	}
	
	
	//nth node from end of a linked list
	static void one(LinkedList ll){
		int  node = 5;
		LinkedList<Integer> l1 = ll;
		LinkedList<Integer> l2 = ll;
		ListIterator<Integer> p1 = l1.listIterator();
		ListIterator<Integer> p2 = l2.listIterator();
		
		for(int  i = 0;i<node-1 ;i++){
			p2.next();
		}
		
		
		while(p2.hasNext()){
			p1.next();
			p2.next();
		}
		
		print("found the value"+p1.previous());
		
		
		
	}
	
	
	
	public static void print(Object item){
		System.out.println(item);
		
	}
	
	public static LinkedList<Integer> GetRandLL(){
		LinkedList<Integer> rndll = new LinkedList<Integer>();
		Integer i=20;
		while(i!=0){
			rndll.add((int) ( Math.random()*(40-20) ));			
			i--;
		}
		
		
		return rndll;
	}
	
}





