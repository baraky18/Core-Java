
	public class SimpleGenericClass<T, U>{
		private T obj1;
		private U obj2;
		
		//generic constructor
		public SimpleGenericClass(T o1, U o2){
			obj1 = o1;
			obj2 = o2;
		}
		
		public void show(){
			System.out.println(obj1);
			System.out.println(obj2);
		}
		
		//generic method
		public <M> void genericMethod(M element){
			System.out.println("the element is " + element.getClass().getName());
		}
	}
