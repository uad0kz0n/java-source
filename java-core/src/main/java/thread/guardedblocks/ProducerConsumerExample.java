package thread.guardedblocks;

//https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
public class ProducerConsumerExample {
	public static void main(String[] args) {
		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
