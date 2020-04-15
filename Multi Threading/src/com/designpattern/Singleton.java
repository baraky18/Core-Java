package com.designpattern;

public class Singleton {

	public static Singleton INSTANCE = null;
	
	
	public Singleton getSingleton(){
		if(INSTANCE == null){
			/*
			 * if threads are coming here and the singleton is created, they will return the instance, if not, 
			 * they will continue to synchronized
			 */
			synchronized(this){
				/*
				 * several threads can come to this point, only one will go into to the if statement and will create the instance
				 * after it will create the instance, another thread will continue to the if statement and will not create the instance
				 */
				if(INSTANCE == null){
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}
	
	private Singleton(){
		//will create expensive operations
	}
}
