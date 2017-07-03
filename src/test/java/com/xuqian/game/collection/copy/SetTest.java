package com.xuqian.game.collection.copy;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		String a = "hello";
		String b = "hello";
		
		String s = new String("hello");
		String s1 = new String("hello");
		
		set.add(a);
		set.add(s);
		set.add(s1);
		set.add(b);
		
		System.out.println("size = " + set.size());
		for (String ss : set) {
			System.out.println(ss);
		}
		
	}
}
