package com.xuqian.game.thread.syn;

import java.util.ArrayList;
import java.util.List;

public class main {
	
	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads = new ArrayList<Thread>();
		Ticket ticket = new Ticket();
		for (int i=0; i <20; i++){
			threads.add(new Thread(new TicketRunnable(ticket)));
		}
		for (Thread thread:threads) {
			thread.start();
		}
	}
}
