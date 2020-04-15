package com.simplethreads.commonproblems;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * since incrementing an integer value is actually 2 actions (1. read the value 2. add 1 to the value), 
 * it can cause a sync problem in the following scenario (even if the global parameter is volatile):
 * 1. thread 1 reads the value (which is 1)
 * 2. thread 2 reads the value (which is 1)
 * 3. thread 1 adds 1 to the value (which is 2)
 * 4. thread 2 adds 1 to the value (which is 2, but should be 3)
 * so, to solve this issue, we need to make the method incrementValue() as synchronized or to make the integer as atomic integer
 */
public class SyncProblem {

	volatile int value = 1;
	AtomicInteger secondValue = new AtomicInteger(1);
	
	public synchronized int incrementValue(){
		value++;
		return value;
	}
	
	public class Task1 implements Runnable{
		@Override
		public void run() {
			System.out.println("Thread1: " + incrementValue());
			System.out.println("Thread1: " + secondValue.incrementAndGet());
		}
	}
	
	public class Task2 implements Runnable{
		@Override
		public void run() {
			System.out.println("Thread2: " + incrementValue());
			System.out.println("Thread2: " + secondValue.incrementAndGet());
		}
	}
	
	public static void main(String[] args) {
		SyncProblem syncProblem = new SyncProblem();
		Thread thread1 = new Thread(syncProblem.new Task1());
		Thread thread2 = new Thread(syncProblem.new Task2());
		thread1.start();
		thread2.start();
	}

}
