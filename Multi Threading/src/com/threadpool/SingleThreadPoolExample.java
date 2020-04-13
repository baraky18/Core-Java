package com.threadpool;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


//we are using this thread pool to make sure that tasks will be executed in a specific order
public class SingleThreadPoolExample {

	public class Task implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread name: " + Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		SingleThreadPoolExample singleThreadPoolExample = new SingleThreadPoolExample();
		//creates a pool of 1 thread
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//submitting the tasks for execution by the thread
		for(int i=0; i<100; i++){
			service.execute(singleThreadPoolExample.new Task());
		}
	}
}
