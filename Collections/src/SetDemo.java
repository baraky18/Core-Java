import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();

		hashSet.add("John");
		hashSet.add("Jack");
		hashSet.add("Jennie");
		hashSet.add("Jim");
		hashSet.add("John");
		hashSet.add("Jeff");
		hashSet.add("John");
		
		//1. data is unique - no redundancy
		//2. data is unordered in output due to hashing
		System.out.println("set is: " + hashSet);
		
		//iterating using an iterator
		System.out.println("set using iterator is: ");
		Iterator<String> itr1 = hashSet.iterator();
		while(itr1.hasNext()){
			String str = itr1.next();
			System.out.println(str);
		}
		
		//-------------------------------------------------------------------------------
		//data is unordered but it's alphabetically sorted
		TreeSet<String> treehSet = new TreeSet<String>();

		treehSet.add("John");
		treehSet.add("Jack");
		treehSet.add("Becky");
		treehSet.add("Jim");
		treehSet.add("John");
		treehSet.add("Albert");
		treehSet.add("John");
		
		//1. data is unique - no redundancy
		//2. data is unordered in output due to hashing
		System.out.println("set is: " + treehSet);
		
		//iterating using an iterator
		System.out.println("set using iterator is: ");
		Iterator<String> itr2 = treehSet.iterator();
		while(itr2.hasNext()){
			String str = itr2.next();
			System.out.println(str);
		}
	}

}
