import java.util.LinkedList;

public class Producer extends Thread {
	private static int MAX_SIZE = 2;
	private final LinkedList<Integer> list = new LinkedList<>();
	private int item = 0;

	@Override
	public void run() {
		try {
			while (true) {
				produce();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void produce() throws InterruptedException {
		while (list.size() == MAX_SIZE) {
			System.out.println("Production Line full");
			wait();
		}
		System.out.println("Produced item number " + item);
		list.add(item++);
		notify();
		Thread.sleep(1000);
	}

	public synchronized int consume() throws InterruptedException {
		notify();
		while (list.isEmpty()) {
			wait();
		}

		int temp = list.removeFirst();
		//Thread.sleep(1000);
		return temp;
	}
}
