package com.simplethreads.commonproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockVsSyncProblem {

	private static Lock lock = new ReentrantLock();
	
	public class Task1 implements Runnable{

		@Override
		public void run() {
			if(lock.tryLock()){
				try{
					System.out.println("I am in!");
				}
				finally{
					lock.unlock();//if for some reason, we fail with exception, we can unlock the lock in the finally block
				}				  //we cannot do that when using synchronized instead of using lock
			}
			else{//if the thread didn't acquire the lock, it can do another activity. if we had used synchronized, it would have gotten blocked
				System.out.println("Doing other activity");
			}
		}
	}
	
	public static void main(String[] args) {
		LockVsSyncProblem lockVsSyncProblem = new LockVsSyncProblem();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i=0; i<100; i++) {
			service.execute(lockVsSyncProblem.new Task1());
		}
	}

}
