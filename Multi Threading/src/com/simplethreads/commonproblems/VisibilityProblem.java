package com.simplethreads.commonproblems;

/*
 * since every thread has it's own caching, it doesn't always checks the value of the global parameter (flag),
 * so, sometimes the while loop will never stop. so the way to overcome that is to define the flag as volatile
 * and that will ensure that the flag will be loaded to the thread's cache every time it's used
 */
public class VisibilityProblem {

	volatile boolean flag = true;
	
	public class Task1 implements Runnable{
		@Override
		public void run() {
			while(flag){
				System.out.println("I am still in the loop");
			}
			System.out.println("I left the loop");
		}
	}
	
	public class Task2 implements Runnable{
		@Override
		public void run() {
			flag = false;
		}
	}
	
	public static void main(String[] args) {
		VisibilityProblem visibilityProblem = new VisibilityProblem();
		Thread thread1 = new Thread(visibilityProblem.new Task1());
		Thread thread2 = new Thread(visibilityProblem.new Task2());
		thread1.start();
		thread2.start();
	}

}
