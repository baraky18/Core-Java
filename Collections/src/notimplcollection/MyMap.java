package notimplcollection;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

	public static void main(String[] args) {
		/*
		 * Map is the only interface collection that doesn't extends the Collection interface
		 */
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "yo");
		map.put(2, "hi");
		map.put(4, "hello");
		System.out.println("my map is: " + map.entrySet());
		System.out.println("hash code is: " + map.hashCode());
		System.out.println("size is: " + map.size());
	}

}
