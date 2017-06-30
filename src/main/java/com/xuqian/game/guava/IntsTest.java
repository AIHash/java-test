package com.xuqian.game.guava;

import java.util.List;

import com.google.common.primitives.Ints;

public class IntsTest {
	
	private void TestInts() {
		int[] intArr = {1,2,3,4,5,6,7,8,9};
		
		List<Integer> objArr = Ints.asList(intArr);
		System.out.println(objArr.toString());
		
		
		
	}

}
