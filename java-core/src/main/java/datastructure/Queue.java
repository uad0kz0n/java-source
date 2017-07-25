/*
 * Queue
 *
 * This class provides a simple thread-safe FIFO queue.
 *
 * Make sure the code works, is thread-safe, and is simple, clear and
 * very readable.  Please do not change any of the provided code.
 */
package datastructure;

public class Queue extends Object {

	/* TODO: Add your fields here. */
	private Node front;	//front node
	private Node rear;	//rear node

	/* Creates a new Queue object. */
	public Queue() {
		/* TODO: Implement this method. */
		this.front = null;
		this.rear = null;

	}

	/* Puts an object at the end of the queue. */
	public void putObject(Object object) {
		/* TODO: Implement this method. */
		final Node node = new Node(object);
		synchronized (this) {
			// if the queue is empty
			if (front == null) {
				rear = node;
				front = node;
			} else {
				rear.nextNode = node;
				rear = node;
			}
	//		System.out.println(node.data +" is enqueued.");
		}

	}

	/*
	 * Gets an object from the beginning of the queue. The object is removed
	 * from the queue. If there are no objects in the queue, returns null.
	 */
	public Object getObject() {
		/* TODO: Implement this method. */
		//use synchronized block to control member variable
		synchronized (this) {
			// if the queue is empty
			if (front == null) {
			//	System.out.println("null is dequeued.");
				return null;
				
			}
			Object item = front.data;
			front = front.nextNode;

			if (front == null) {
				rear = null;
			}
		//	System.out.println(item +" is dequeued.");
			return item;
		}
	}

	private static class Node {
		// Single linked list. consist of data and a point
		Object data;
		Node nextNode;

		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}
}
