package bq;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<Long> queue;

	Producer(BlockingQueue<Long> q) {
		queue = q;
	}

	public void run() {
	     try {
	       while (true) { queue.put(produce()); }
	     } catch (InterruptedException ex) { }
	   }

	Long produce() { 
		
		return System.currentTimeMillis();
	}
}
