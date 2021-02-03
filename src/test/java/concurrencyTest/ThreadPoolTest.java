package concurrencyTest;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	private static ExecutorService pool = Executors.newFixedThreadPool(4);

	public static void main(String[] abc) {
//		System.out.println("ri");
//		ProductBuffer buffer = new ProductBuffer(new ArrayDeque<String>(8), 8);
//		new Thread(new Producer(buffer)).start();
//		new Thread(new Consumer(buffer)).start();

	}

}

class ProductBuffer {
	private Queue buffer;
	int maxSize;
	private boolean release = false;

	public boolean isRelease() {
		return release;
	}

	public void setRelease(boolean release) {
		this.release = release;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public ProductBuffer(Queue queue, int maxSize) {
		this.buffer = queue;
		this.maxSize = maxSize;
	}

	public void offer(Object o) {
		buffer.offer(o);
	}

	public Object remove() {
		return buffer.remove();
	}

	public int size() {
		return buffer.size();
	}
}

class Producer implements Runnable {
	ProductBuffer buffer;

	public Producer(ProductBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		int id = 1;
		while (!buffer.isRelease()) {
			synchronized (buffer) {
				buffer.offer("Product" + id++);
				if (buffer.size() >= buffer.getMaxSize()) {
					notifyAll();
					System.out.println("Producer mission completed!");
					buffer.setRelease(true);
					break;
				}
			}

		}
	}

}

class Consumer implements Runnable {
	ProductBuffer buffer;

	public Consumer(ProductBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (buffer) {
				if (!buffer.isRelease()) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String product = (String) buffer.remove();
					if (product == null) {
						System.out.println("Products have been all consumed");
						break;
					}
					System.out.println("Consumer consumes " + product);
				}
			}
		}

	}

}