package com.simplethreads.commonproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithoutBlockingQueueProblem {

	MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<Integer>(10);
	public class MyBlockingQueue<T>{

		private Queue<T> queue;
		private int max;
		private Lock lock = new ReentrantLock();
		private Condition notEmpty = lock.newCondition();
		private Condition notFull = lock.newCondition();

		public MyBlockingQueue(int size){
			this.max = size;
			this.queue = new LinkedList<T>();
		}

		public void put(T i) {
			lock.lock();
			try{
				while(queue.size() == max){
					notFull.await();
					/*
					 * when thread is awaiting it releases the lock automatically. this can lead to a situation that
					 * 2 threads are waiting in this point. when "notFull" condition is signaling that the queue is not full,
					 * then one of the threads that's waiting here will acquire the lock again and will proceed with the rest of the method.
					 * all of the others will wait at the same point. after that thread is done with the code, in the finally block the lock is 
					 * unlocked and another thread will acquire lock and will continue the code.
					 */
				}					
				queue.add(i);
				notEmpty.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
		}

		public T take() {
			T t = null;
			lock.lock();
			try{
				while(queue.size() == 0){
					notEmpty.await();
				}
				t = queue.remove();
				notFull.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
			return t;
		}
	}

	public class Producer implements Runnable{

		@Override
		public void run() {
			myBlockingQueue.put(1);
			System.out.println("1 was added");
		}
	}

	public class Consumer implements Runnable{

		@Override
		public void run() {
			myBlockingQueue.take();
			System.out.println("1 was taken");
		}
	}

	public static void main(String[] args) {
		ProducerConsumerWithoutBlockingQueueProblem producerConsumerWithoutBlockingQueueProblem = 
				new ProducerConsumerWithoutBlockingQueueProblem();
		for (int i=0; i<100; i++) {
			Thread producerThread = new Thread(producerConsumerWithoutBlockingQueueProblem.new Producer());
			Thread consumerThread = new Thread(producerConsumerWithoutBlockingQueueProblem.new Consumer());
			producerThread.start();
			consumerThread.start();
		}
	}

}
