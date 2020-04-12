import java.util.PriorityQueue;

public class QueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=10; i>0; i--){
			queue.add(i);
		}
		
		//Queue: (Front) 10 9 8 7 6 5 4 3 2 1 (Rear)
		//PriorityQueue sorts the data for us
		//Queue: (Front) 1 2 3 4 5 6 7 8 9 10 (Rear) -> sorted queue
		
		//Peeking: obtaining the head of the queue
		//Polling: removing the head of the queue
		
		System.out.println("The queue is: " + queue.toString());
		System.out.println("Queue size is: " + queue.size());
		System.out.println("Head of queue is: " + queue.peek());
		queue.poll();
		System.out.println("Head of queue after polling is: " + queue.peek());
		System.out.println("Queue size after polling is: " + queue.size());
	}

}
