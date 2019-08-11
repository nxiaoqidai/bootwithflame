package concurrencyTest;

import java.util.List;

public class ComsumerProducerTest0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Producer0 implements Runnable {
	private final List taskQueue;
	private final int MAX_SIZE;

	public Producer0(List taskQueue, int MAX_SIZE) {
		this.taskQueue = taskQueue;
		this.MAX_SIZE = MAX_SIZE;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			synchronized (taskQueue) {

			}
		}

	}

}