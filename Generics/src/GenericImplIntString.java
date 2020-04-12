
public class GenericImplIntString implements GenericInterface<Integer, String> {

	@Override
	public Integer performExecution(String element) {
		System.out.println("I got " + element.getClass() + " and returning " + Integer.class);
		return 2;
	}

}
