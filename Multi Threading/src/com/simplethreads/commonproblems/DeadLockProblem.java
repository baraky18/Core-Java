package com.simplethreads.commonproblems;

/*
 * Deadlocks occur when thread A acquired "lock-a" and wants to acquire "lock-b", but thread B acquired "lock-b"
 * but wants to acquire "lock-a". for this problem we have 2 possible solutions:
 * 1. add timeouts to the locks and release both of them when timeout occur.
 * 2. perform consistent ordering of lock acquisition - we will see that in the example below
 */
public class DeadLockProblem {

	public class TaskTransferMoney implements Runnable{

		Integer fromAccount;
		Integer toAccount;
		/*
		 * fromAccount and toAccount will change from Thread1 to Thread2 because in Thread1 John is transferring money to Lisa
		 * and in Thread2 the opposite, we should use parameters in consistent order such as:
		 * Integer biggerAccount
		 * Integer smallerAccount
		 * that way, John's account will be always biggerAccount since 456>123
		 */
		int amount;
		
		public TaskTransferMoney(Integer fromAccount, Integer toAccount, int amount){
			this.fromAccount = fromAccount;
			this.toAccount = toAccount;
			this.amount = amount;
		}
		
		@Override
		public void run() {
			synchronized (fromAccount){
				synchronized (toAccount){
					fromAccount = fromAccount - amount;
					toAccount = toAccount + amount;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DeadLockProblem deadLockProblem = new DeadLockProblem();
		Integer lisaAccount = 123;
		Integer JohnAccount = 456;
		Thread thread1 = new Thread(deadLockProblem.new TaskTransferMoney(lisaAccount, JohnAccount, 100));
		Thread thread2 = new Thread(deadLockProblem.new TaskTransferMoney(JohnAccount, lisaAccount, 300));
		thread1.start();
		thread2.start();
	}

}
