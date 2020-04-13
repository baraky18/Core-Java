package com.threadpool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

	public class Task implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread name: " + Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		CachedThreadPoolExample cachedThreadPoolExample = new CachedThreadPoolExample();
		//creates a cached pool of threads for a short lived tasks
		ExecutorService service = Executors.newCachedThreadPool();
		//submitting the tasks for execution by the threads
		for(int i=0; i<100; i++){
			service.execute(cachedThreadPoolExample.new Task());
		}
	}
}
