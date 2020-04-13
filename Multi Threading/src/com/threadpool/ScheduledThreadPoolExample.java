package com.threadpool;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

	public class Task implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread name: " + Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		ScheduledThreadPoolExample scheduledThreadPoolExample = new ScheduledThreadPoolExample();
		//creates a pool of threads
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		//submitting the tasks for execution by the threads
		for(int i=0; i<100; i++){
			//(usually it will be 1 of the 3 methods, not all 3 together like so)
			
			//task to run after 10 seconds delay
			service.schedule(scheduledThreadPoolExample.new Task(), 10, TimeUnit.SECONDS);
			
			//task with initial delay of 15 seconds and runs repeatedly every 10 seconds
			service.scheduleAtFixedRate(scheduledThreadPoolExample.new Task(), 15, 10, TimeUnit.SECONDS);
			
			//task with initial delay of 15 seconds and runs repeatedly 10 seconds after previous task completes
			service.scheduleWithFixedDelay(scheduledThreadPoolExample.new Task(), 15, 10, TimeUnit.SECONDS);
		}
	}
}
