package cache;

import java.util.HashMap;

/*
 * several observations:
 * 1. this cache supports only get and put methods
 * 2. the collection (HashMap) and the data structure (linked list) are both members of the cache
 * 3. the collection (HashMap) and the data structure (linked list) are updated simultaneously in put method
 * 4. Node object hold a key in addition to the HashMap to support a situation that the cache is full and
 * 	  we need to remove the tail from the HashMap 
 */
public class MyLruCache {

	HashMap<Integer, Node> hashmap;
	Node head;
	Node tail;
	int LRU_SIZE = 4; // Here i am setting 4 to test the LRU cache implementation, it can make be dynamic

	public MyLruCache() {
		hashmap = new HashMap<Integer, Node>();
	}

	public int get(int key){
		if (hashmap.containsKey(key)){ // Key Already Exist, just update the
			Node node = hashmap.get(key);
			remove(node);
			addAtTop(node);
			return node.data;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (hashmap.containsKey(key)){ // Key Already Exist, just update the value and move it to top
			Node node = hashmap.get(key);
			node.data = value;
			remove(node);
			addAtTop(node);
		} else {
			Node newNode = new Node();
			newNode.previous = null;
			newNode.next = null;
			newNode.data = value;
			newNode.key = key;
			if (hashmap.size() > LRU_SIZE){ // We have reached maxium size so need to make room for new element.
				hashmap.remove(tail.key);
				remove(tail);				
				addAtTop(newNode);

			} else {
				addAtTop(newNode);
			}
			hashmap.put(key, newNode);
		}
	}

	private void addAtTop(Node node){
		node.next = head;
		node.previous = null;
		if (head != null)
			head.previous = node;
		head = node;
		if (tail == null)
			tail = head;
	}

	private void remove(Node node) {
		if (node.previous != null){
			node.previous.next = node.next;
		} else {
			head = node.next;
		}
		if (node.next != null){
			node.next.previous = node.previous;
		} else {
			tail = node.previous;
		}
	}
	
	class Node {
		int data;
		int key;
		Node previous;
		Node next;
	}
}