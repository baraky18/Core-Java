
public class Generics {


	public static void main(String[] args) {
		//Simple Generic class
		SimpleGenericClass<String, Integer> simplegenericClass1 = new SimpleGenericClass<String, Integer>("Barak", 3);
		simplegenericClass1.show();
		simplegenericClass1.genericMethod(2);
		simplegenericClass1.genericMethod(1.4);
		simplegenericClass1.genericMethod("Hello");
		
		//Simple Generic class with complicated implementation
		SimpleGenericClass<String, ? extends Number> simplegenericClass2 = new SimpleGenericClass<String, Integer>("Barak", 3);
		SimpleGenericClass<String, ? extends Number> simplegenericClass3 = new SimpleGenericClass<String, Double>("Barak", 3.3);
		SimpleGenericClass<String, ? super Integer> simplegenericClass4 = new SimpleGenericClass<String, Number>("Barak", 3);
		
		//Generic interface
		GenericImplStringInt genericImplStringInt = new GenericImplStringInt();
		genericImplStringInt.performExecution(3);
		GenericImplIntString genericImplIntString = new GenericImplIntString();
		genericImplIntString.performExecution("Hey");
		
		//Generic class that extends another type
		ExtendsGenericClass<Integer, String> extendsGenericClass1 = new ExtendsGenericClass<Integer, String>(1, "GGG");
		extendsGenericClass1.show();
		ExtendsGenericClass<Double, String> extendsGenericClass2 = new ExtendsGenericClass<Double, String>(1.1, "GGG");
		extendsGenericClass2.show();
//		ExtendsGenericClass<String, String> extendsGenericClass3 = new ExtendsGenericClass<String, String>("ww", "ee");//compilation error
	}

}
