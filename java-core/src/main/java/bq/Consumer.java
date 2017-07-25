package bq;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue<Long> queue;

	Consumer(BlockingQueue<Long> q) {
		queue = q;
	}

	public void run() {
	     try {
	       while (true) { consume(queue.take()); }
	     } catch (InterruptedException ex) { }
	   }

	void consume(Object x) {System.out.println(x);}
}
