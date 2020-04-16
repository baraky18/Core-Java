package pojo;

import intf.Animal;

public class Lion extends BigCat implements Animal{

	private String name;
	private int age;
	
	public Lion(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public Lion(Lion lion){
		this.name = lion.getName();
		this.age = lion.getAge();
	}
	
	private String speak(){
		return "Rrrrrrrrrrrr";
	}
	
	private String speed(int kmPerHour){
		return "Oooo, it's fast bro'";
	}
	
	@Override
	public int numOfChildren(){
		return 3;
	}
	
	@Override
	public void sayThis(String sayThis) {
		System.out.println(sayThis);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
