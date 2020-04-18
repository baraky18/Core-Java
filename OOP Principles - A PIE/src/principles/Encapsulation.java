package principles;

/*
 * Encapsulation allows us to protect the data stored in a class from system-wide access. 
 * As its name suggests, it safeguards the internal contents of a class like a real-life capsule. 
 * You can implement encapsulation in Java by keeping the fields (class variables) private 
 * and providing public getter and setter methods to each of them. Java Beans are examples of fully encapsulated classes.
 */
public class Encapsulation {

	class Animal {
		private String name;
		private double averageWeight;
		private int numberOfLegs;

		// Getter methods
		public String getName() {
			return name;
		}
		public double getAverageWeight() {
			return averageWeight;
		}
		public int getNumberOfLegs() {
			return numberOfLegs;
		}

		// Setter methods
		public void setName(String name) {
			this.name = name;
		}
		public void setAverageWeight(double averageWeight) {
			this.averageWeight = averageWeight;
		}
		public void setNumberOfLegs(int numberOfLegs) {
			this.numberOfLegs = numberOfLegs;
		}
	}
}
