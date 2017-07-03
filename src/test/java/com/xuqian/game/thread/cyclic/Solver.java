package com.xuqian.game.thread.cyclic;

import java.util.concurrent.CyclicBarrier;

public class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;
	
	class Worker implements Runnable {
		int myRow;
		
		public Worker() {
			
		}

		public void run() {
		
		}
		
	}
	
	public Solver(float[][] matrix) {
		
	    data = matrix;
	    N = matrix.length;
	    barrier = new CyclicBarrier(N,
	            new Runnable() {
	                public void run() {
//	                    mergeRows(...);
	                }
	            });
//	    for (int i = 0; i < N; ++i)
//	        new Thread(new Worker(i)).start();

//	    waitUntilDone();
	}
	

	
}
