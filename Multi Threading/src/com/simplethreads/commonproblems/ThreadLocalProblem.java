package com.simplethreads.commonproblems;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalProblem {

	/*
	 * if we would like to use an object like SimpleDateFormat in every task and we need to instantiate it in every task - 
	 * it's very not efficient in terms of CPU. on the other hand, if we will set this object as global, we would have to sync it,
	 * and this is very expensive since many threads will wait. so the middle rode is to instantiate the object for every thread.
	 * we do this with ThreadLocal object
	 */
	ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>(){

		@Override
		public SimpleDateFormat get(){
			return super.get();
		}

		@Override
		protected SimpleDateFormat initialValue(){
			return new SimpleDateFormat("yyyy-MM-dd-HH:MM:SS");
		}
	};

	public class Task1 implements Runnable{

		@Override
		public void run() {
			final SimpleDateFormat simpleDateFormat = df.get();
			String str = simpleDateFormat.format(new Date());
			System.out.println("Thread is: " + Thread.currentThread().getName() + " date is: " + str);
		}
	}

	public static void main(String[] args) {
		ThreadLocalProblem threadLocalProblem = new ThreadLocalProblem();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i=0; i<100; i++){
			service.execute(threadLocalProblem.new Task1());
			if(i==99){
				threadLocalProblem.df.remove();//it's important to remove the ThreadLocal if it's no longer required
			}
		}
	}
}
