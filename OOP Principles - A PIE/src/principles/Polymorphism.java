package principles;

/*
 * Polymorphism refers to the ability to perform a certain action in different ways. 
 * In Java, polymorphism can take two forms: method overloading and method overriding. 
 * Method overloading happens when various methods with the same name are present in a class. 
 * When they are called they are differentiated by the number, order, and types of their parameters. 
 * Method overriding occurs when the child class overrides a method of its parent.
 */
public class Polymorphism {

	/*
	 * overloading
	 */
	class Bird1 {
		public void fly() {
			System.out.println("The bird is flying.");
		}
		public void fly(int height) {
			System.out.println("The bird is flying " + height + " feet high.");
		}
		public void fly(String name, int height) {
			System.out.println("The " + name + " is flying " + height + " feet high.");
		}
	}
	
	/*
	 * overriding
	 */
	public static void main(String[] args) {
		Polymorphism polymorphism = new Polymorphism();
		Animal myAnimal = polymorphism.new Animal();
		myAnimal.eat();

		Bird2 myBird = polymorphism.new Bird2();
		myBird.eat();
	}
	
	class Animal {
		public void eat() {
			System.out.println("This animal eats insects.");
		}
	}

	class Bird2 extends Animal {

		public void eat() {
			System.out.println("This bird eats seeds.");
		}

	}
}
