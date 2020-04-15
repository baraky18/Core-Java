package com.simplethreads.commonproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/*
 * if there's a service that we know it's slow and we want to restrict access to we use Semaphore.
 * when using Semaphores, we define the number of threads allowed to the Semaphore at the same time
 * and acquiring a place in the Semaphore before the service is executed and release a place in the Semaphore after the service is done
 */
public class RestrictAccessProblem {

	public class Task1 implements Runnable{

		private Semaphore semaphore;
		public Task1(Semaphore semaphore){
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			semaphore.acquireUninterruptibly();;
			System.out.println("Thread is: " + Thread.currentThread().getName() + " Slow IO service");
			semaphore.release();
			if(semaphore.availablePermits() == 0){
				System.out.println("I am blocked");
			}
		}
	}

	public static void main(String[] args) {
		RestrictAccessProblem restrictAccessProblem = new RestrictAccessProblem();
		Semaphore semaphore = new Semaphore(3);
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i=0; i<100; i++) {
			service.execute(restrictAccessProblem.new Task1(semaphore));
		}
	}
}
