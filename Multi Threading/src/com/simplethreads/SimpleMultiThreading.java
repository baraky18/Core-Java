package com.simplethreads;

public class SimpleMultiThreading {

	class Hi extends Thread{
		
		public void run(){
			for(int i=0; i<5; i++){
				System.out.println("Hi");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//since Java is a polymorphism language it's possible to extends only one class, but implementing multiple interfaces - so it's better
	class Hello implements Runnable{
		
		public void run(){
			for(int i=0; i<5; i++){
				System.out.println("Hello");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Thread states:
		 * New - thread is ready after I initialized it
		 * Terminated/ Dead - thread is finish with it's tasks
		 * Running - thread is currently performing an action (for example it's printing right now)
		 * Runnable - thread is waiting for the chance to get executed by the system (for example: when "Hi" is printed, "Hello" thread is runnable and "Hi" thread is running
		 * Blocked/ Waiting - thread is waiting for some other thread to complete execution
		 */
		SimpleMultiThreading simpleMultiThreadingExtends = new SimpleMultiThreading();
		Hi hi = simpleMultiThreadingExtends.new Hi();
		Hello hello = simpleMultiThreadingExtends.new Hello();
		hi.start();
		Thread helloThread = new Thread(hello);
		helloThread.start();
		hi.join();//only after "hi" thread is done, we will execute the rest of the main thread 
		helloThread.join();//only after "hello" thread is done, we will execute the rest of the main thread 
		for(int i=0; i<5; i++){
			System.out.println("Hola");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
