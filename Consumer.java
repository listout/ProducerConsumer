public class Consumer extends Thread {
	private Producer producer;

	public Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int item = producer.consume();
				System.out.println(
						"Item " + item + " consumed by " + Thread.currentThread().getName());
				System.out.println();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
