package com.xuqian.game.thread.syn;

import java.util.Random;

public class TicketRunnable implements Runnable{
	private Ticket ticket;
	private Random random;
	public TicketRunnable(Ticket ticket) {
		this.ticket = ticket;
		random = new Random();
	}
	
	public void run() {
		for (int i=0; i < 5; i++) {
			synchronized (ticket) {
				try {
					int count =  random.nextInt(10) + 1;
	                boolean success = ticket.buyTicket(count);
	                System.out.println(String.format("%s������%d��Ʊ,��Ʊ%s��,��ʣ��%d��Ʊ,�ܹ�����%d��Ʊ, ��Ʊ��%d",
	                        Thread.currentThread().getName(), count, success ? "�ɹ�" : "ʧ��",
	                        ticket.getCount(),ticket.getBuyedCount(),ticket.getAllCount()));
	                if (!success){
	                    break;
	                }
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
