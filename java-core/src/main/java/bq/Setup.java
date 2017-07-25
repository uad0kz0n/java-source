package bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Setup {
	private static BlockingQueue<Long> queue = new ArrayBlockingQueue<>(3);

	public static void main(String[] args) {
		Consumer c1 = new Consumer(queue);	 
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		Producer p1 = new Producer(queue);
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		new Thread(p1).start();
		
		 
	}

}
