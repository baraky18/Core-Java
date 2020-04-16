import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import pojo.Lion;

public class Main {

	public static void main(String[] args){

		Class reflectClass = Lion.class;

		System.out.println("name of class is: " + reflectClass.getName());

		System.out.println("class is public? " + Modifier.isPublic(reflectClass.getModifiers()));

		System.out.println("interfaces are: " + reflectClass.getInterfaces()[0]);

		System.out.println("super class is: " + reflectClass.getSuperclass());

		Method[] classMethods = reflectClass.getMethods();

		for (Method method : classMethods) {
			System.out.println("Method name is: " + method);
		}

		Constructor constructor1 = null;
		Constructor constructor2 = null;
		Object newInstance = null;

		try {
			Constructor[] constructors = reflectClass.getConstructors();
			if(constructors[0].getParameterCount() == 2){
				constructor1 = constructors[0];
				constructor2 = constructors[1];
			}
			else{
				constructor1 = constructors[1];
				constructor2 = constructors[0];
			}
			Class[] construct1Params = constructor1.getParameterTypes();
			for (Class classTmp : construct1Params) {
				System.out.println("param of constructor1 is: " + classTmp);
			}
			
			Class[] construct2Params = constructor2.getParameterTypes();
			for (Class classTmp : construct2Params) {
				System.out.println("param of constructor2 is: " + classTmp);
			}

			//this is a way to create an object in reflection
			newInstance = constructor1.newInstance("random string", 12);
			System.out.println(((Lion)newInstance).numOfChildren());
		}

		catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SecurityException e) {
			e.printStackTrace();
		}
		
		Field privateStringName = null;

		Field[] allFields = newInstance.getClass().getDeclaredFields();
		for (Field field : allFields) {
			System.out.println("field is: " + field);
			try {
				//this is a way to access a private field using reflection
				privateStringName = newInstance.getClass().getDeclaredField(field.getName());
				privateStringName.setAccessible(true);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			break;
		}
		

		Method privateStringMethod = null;
		Method[] allMethods = newInstance.getClass().getDeclaredMethods();
		for (Method method : allMethods) {
			if(Modifier.isPrivate(method.getModifiers()) && method.getName().contains("speak")){
				//this is a way to access a private method using reflection
				System.out.println("method is: " + method);
				privateStringMethod = method;
				privateStringMethod.setAccessible(true);
				try {
					//this is a way to execute a method with no arguments in reflection
					String returnType = (String) privateStringMethod.invoke(newInstance, null);
					System.out.println("return type is: " + returnType);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Modifier.isPrivate(method.getModifiers()) && method.getName().contains("speed")){
				System.out.println("method is: " + method);
				privateStringMethod = method;
				privateStringMethod.setAccessible(true);
				Object[] paramsValues = new Object[]{new Integer(80)};
				try {
					String returnType = (String) privateStringMethod.invoke(newInstance, paramsValues);
					System.out.println("return type is: " + returnType);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}





	}
}
