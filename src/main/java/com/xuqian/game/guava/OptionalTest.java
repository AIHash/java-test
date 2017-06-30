package com.xuqian.game.guava;

import com.google.common.base.Optional;

public class OptionalTest {

	public Integer sum(Optional<Integer> a,Optional<Integer> b) {
		
		System.out.println("First parameter is present: " + a.isPresent());
	    System.out.println("Second parameter is present: " + b.isPresent());
	    Integer value1 = a.or(new Integer(0));
	    Integer value2 = b.get();
	    
	    return value1 + value2;    
	}

	public static void main(String[] args) {
		OptionalTest optionalTest = new OptionalTest();
		
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		
		Optional<Integer> a = Optional.fromNullable(value1);
		Optional<Integer> b = Optional.of(value2);
		
		System.out.println(optionalTest.sum(a, b));
	}
}
