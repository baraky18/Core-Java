import java.util.ArrayList;
import java.util.Iterator;

public class ListsDemo {

	public class Student{
		int id;
		String name;
	}
	
	public static void main(String[] args) {
		ListsDemo coleections = new ListsDemo();
		Student student = coleections.new Student();
		student.id = 1;
		student.name = "Mike";
		
		//listString can only store String objects
		ArrayList<String> listString = new ArrayList<String>();

		//listObject can store any type of object
		ArrayList listObject = new ArrayList();
		
		//1. add data to the list (notice that ArrayList supports redundancy which means same item more than once in the same list
		listString.add("John");
		listString.add("Jemma");
		listString.add("Jennie");
		listString.add("Jim");
		listString.add("John");
		listString.add("Jack");
		
		listObject.add("John");
		listObject.add(1);
		listObject.add(2.2);
		listObject.add('A');
		listObject.add(student);
		listObject.add('A');
		
		System.out.println("listString is: " + listString);
		System.out.println("listObject is: " + listObject);
		
		//2. get element from the list
		String name = listString.get(2);
		System.out.println("name is: " + name);
		
		Object o = listObject.get(2);
		System.out.println("object is: " + o);
		
		//3. update element in list
		listString.set(1, "Jeff");
		System.out.println("listString is now: " + listString);
		
		//4. remove an element from the list
		listString.remove(2);
		System.out.println("listString after remove is: " +listString);
		
		//5. iterate in the ArrayList
		System.out.println("iterating in for loop in the ArrayList:");
		for (String str : listString) {
			System.out.println(str);
		}
		
		System.out.println("iterating in itearator in the ArrayList:");
		Iterator<String> itr1 = listString.iterator();
		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
		
		System.out.println("iterating and removing in itearator in the ArrayList:");
		Iterator<String> itr2 = listString.iterator();
		while(itr2.hasNext()){
			String str = itr2.next();
			if(str.equalsIgnoreCase("John")){
				itr2.remove();
			}
		}
		System.out.println("listString is now: " + listString);
	}
	

}
