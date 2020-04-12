
public class GenericImplStringInt implements GenericInterface<String, Integer> {

	@Override
	public String performExecution(Integer element) {
		System.out.println("I got " + element.getClass() + " and returning " + String.class);
		return "";
	}

}
