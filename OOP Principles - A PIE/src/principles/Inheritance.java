package principles;

/*
 * Inheritance makes it possible to create a child class that inherits the fields and methods of the parent class. 
 * The child class can override the values and methods of the parent class, however it’s not necessary. 
 * It can also add new data and functionality to its parent. Parent classes are also called superclasses or base classes, 
 * while child classes are known as subclasses or derived classes as well. 
 * Java uses the extends keyword to implement the principle of inheritance in code.
 */
public class Inheritance {

	public static void main(String[] args) {	
		Inheritance inheritance = new Inheritance();
		Eagle myEagle = inheritance.new Eagle();

		System.out.println("Name: " + myEagle.name); 			
		System.out.println("Reproduction: " + myEagle.reproduction);
		System.out.println("Outer covering: " + myEagle.outerCovering);
		System.out.println("Lifespan: " + myEagle.lifespan); 		
		myEagle.flyUp();
		myEagle.flyDown(); 		
	}
	
	class Bird {
		public String reproduction = "egg";
		public String outerCovering = "feather";

		public void flyUp() {
			System.out.println("Flying up...");
		}
		public void flyDown() {
			System.out.println("Flying down...");
		}
	}

	class Eagle extends Bird {
		public String name = "eagle";
		public int lifespan = 15;
	}
}
