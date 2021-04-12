
public class Application {
	public static void main(String[] args)throws InterruptedException {
		Fifo storage = new Fifo();
		Thread threads1 = new Thread();
		threads1 = new Thread(new Producer(storage, "producer", 30));
		Thread threads2 = new Thread();
		threads2 = new Thread(new Consumer(storage, "consumer", 500));
		threads1.start();
		threads2.start();
	}
}
