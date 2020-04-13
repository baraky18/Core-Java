package com.threadpool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

	public class Task implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread name: " + Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		FixedThreadPoolExample fixedThreadPoolExample = new FixedThreadPoolExample();
		//creates a pool of threads
		//false if we are performing many IO operations, true if we are performing CPU intensive operations
		ExecutorService service = Executors.newFixedThreadPool(getPoolNumber(false));
		//submitting the tasks for execution by the threads
		for(int i=0; i<100; i++){
			service.execute(fixedThreadPoolExample.new Task());
		}
		

	}
	
	public static int getPoolNumber(boolean isCpuIntensiveOperations){
		if(isCpuIntensiveOperations){//if we are performing CPU intensive operations, we should find out the number of cores in the CPU and create a pool from that number
			return Runtime.getRuntime().availableProcessors();
		}
		return 100;//if we are performing DB requests, HTTP requests, IO operations, it's best to create high number of pool size, since threads are waiting and we need other threads to take other tasks
	}
}
