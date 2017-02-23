package com.heqaing.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Test_clazz {

	public static void main(String[] args) throws IOException {
		int count = 1000000;
		int limit = 10000;
		Random random = new Random();
		int[] arr = new int[count];
		long t0 = System.nanoTime();
		for(int i=0;i<count;i++){
			arr[i] = random.nextInt(limit);
		}
		long tt = System.nanoTime();
		System.out.println(tt-t0);
		System.out.println("随机数产生完毕...");
		long t1 = System.nanoTime();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<count;i++){
			set.add(arr[i]);
		}
		long t2 = System.nanoTime();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<count;i++){
			if(list.contains(arr[i])) continue;
			list.add(arr[i]);
		}
		long t3 = System.nanoTime();
		System.out.println("HashSet  :"+(t2-t1));
		System.out.println("ArrayList:"+(t3-t2));
		
	}
}
