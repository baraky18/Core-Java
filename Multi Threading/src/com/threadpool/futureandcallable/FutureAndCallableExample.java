package com.threadpool.futureandcallable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableExample {

	int index = 0;
	//Callable interface was created for threads to be able to return something
	public class Task implements Callable<Integer>{
		@Override
		public Integer call() throws Exception {
			index++;
			Thread.sleep(500);
			System.out.println("Thread name: " + Thread.currentThread().getName());
			return index;
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureAndCallableExample futureAndCallableExample = new FutureAndCallableExample();
		//creates a pool of threads
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//creating an array of futures that gets Integer, that would be able to get the int that's returned from the tasks
		ArrayList<Future<Integer>> allFutures = new ArrayList<Future<Integer>>();
		
		//submitting the tasks for execution by the threads
		for(int i=0; i<10; i++){
			//submit is meant for calling Tasks that are implementing Callable interface
			Future<Integer> future = service.submit(futureAndCallableExample.new Task());
			System.out.println(future.get());//this is blocking the main thread, since the thread is waiting till all of the tasks are executed
			allFutures.add(future);
		}
		
		System.out.println("I am finished!");
	}
}
