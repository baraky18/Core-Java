package com.simplethreads.commonproblems;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * since blocking queue is responsible for synchronizing between threads, this implementations becomes very easy 
 */
public class ProducerConsumerWithBlockingQueue {

	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public class Producer implements Runnable{

		@Override
		public void run() {
			queue.add(1);
			System.out.println("1 was added");
		}
	}

	public class Consumer implements Runnable{

		@Override
		public void run() {
			try{
				queue.take();
				System.out.println("1 was taken");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ProducerConsumerWithBlockingQueue producerConsumerWithBlockingQueue = new ProducerConsumerWithBlockingQueue();
		for (int i=0; i<100; i++) {
			Thread producerThread = new Thread(producerConsumerWithBlockingQueue.new Producer());
			Thread consumerThread = new Thread(producerConsumerWithBlockingQueue.new Consumer());
			producerThread.start();
			consumerThread.start();
		}
	}
}
