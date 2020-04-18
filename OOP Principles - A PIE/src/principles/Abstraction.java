package principles;

/*
 * Abstraction aims to hide complexity from the users and show them only the relevant information. 
 * For example, if you want to drive a car, you don’t need to know about its internal workings. 
 * The same is true of Java classes. You can hide internal implementation details by using abstract classes or interfaces. 
 * On the abstract level, you only need to define the method signatures (name and parameter list) 
 * and let each class implement them in their own way.
 */
public class Abstraction {

	public static void main(String[] args) {
		Abstraction abstraction = new Abstraction();
		Animal myBird = abstraction.new Bird();
		myBird.label();
		myBird.move();
		myBird.eat();
		Animal myFish = abstraction.new Fish();
		myFish.label();
		myFish.move();
		myFish.eat();
	}
	
	abstract class Animal {
		// abstract methods
		abstract void move();
		abstract void eat();

		// concrete method
		void label() {
			System.out.println("Animal's data:");
		}
	}

	class Bird extends Animal {
		void move() {
			System.out.println("Moves by flying.");
		}
		void eat() {
			System.out.println("Eats birdfood.");
		}	 
	}

	class Fish extends Animal {
		void move() {
			System.out.println("Moves by swimming.");
		}
		void eat() {
			System.out.println("Eats seafood.");
		}
	}
}
