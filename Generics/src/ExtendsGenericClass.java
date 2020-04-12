
public class ExtendsGenericClass <T extends Number, U>{

	private T obj1;
	private U obj2;
	
	//generic constructor
	public ExtendsGenericClass(T o1, U o2){
		obj1 = o1;
		obj2 = o2;
	}
	
	public void show(){
		System.out.println(obj1);
		System.out.println(obj2);
	}
}
