package main;

import cache.MyLruCache;

public class Main {

	public static void main(String[] args) throws java.lang.Exception {
		MyLruCache lruCache = new MyLruCache();
		lruCache.put(1, 1);
		lruCache.put(10, 15);
		lruCache.put(15, 10);
		lruCache.put(10, 16);
		lruCache.put(12, 15);
		lruCache.put(18, 10);
		lruCache.put(13, 16);

		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(10));
		System.out.println(lruCache.get(15));

	}
}
