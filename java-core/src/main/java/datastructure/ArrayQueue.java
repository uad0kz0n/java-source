/*
 * Queue
 *
 * This class provides a simple thread-safe FIFO queue.
 *
 * Make sure the code works, is thread-safe, and is simple, clear and
 * very readable.  Please do not change any of the provided code.
 */

package datastructure;

/* PS: Do not use any imports from the standard library.  Else it
 * would be way too easy using standard classes. ;-)
 */
//implements CircularQueue
public class ArrayQueue extends Object {
	/* TODO: Add your fields here. */

	private int front;
	private int rear;
	private int queueSize;
	private Object items[];
	private final static int DEFAULT_QUEUE_SIZE = 100;

	/* Creates a new Queue object. */
	public ArrayQueue() {
		/* TODO: Implement this method. */
		this(DEFAULT_QUEUE_SIZE);

	}

	public ArrayQueue(int queueSize) {
		/* TODO: Implement this method. */
		this.front = 0;
		this.rear = 0;
		this.queueSize = queueSize;
		this.items = new Object[queueSize];
	}

	/* Puts an object at the end of the queue. */
	public void putObject(Object object) {
		/* TODO: Implement this method. */
		synchronized (this) {
			while (isFull()) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
			rear = (rear + 1) % (queueSize);
			items[rear] = object;
			System.out.println(object + " is enqueued.");
			notifyAll();

		}
	}

	/*
	 * Gets an object from the beginning of the queue. The object is removed
	 * from the queue. If there are no objects in the queue, returns null.
	 */
	public Object getObject() {
		/* TODO: Implement this method. */
		synchronized (this) {
			while (isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			front = (front + 1) % queueSize;
			// notify threads what tried to putObject
			System.out.println(items[front] + " is dequeued.");
			notifyAll();
			return items[front];

		}

	}

	private boolean isEmpty() {
		return (front == rear);
	}

	private boolean isFull() {
		return ((rear + 1) % this.queueSize == front);
	}

}
