
public class Consumer extends Thread{
	private Fifo storage;
	private String message;
	private int sleepTime;
	
	public Consumer(Fifo f, String s, int n)
	{
		storage = f;
		message = s;
		sleepTime = n;
	}
	
	
	public void run()
	{
		while(true)
		{
			try {
				 System.out.println("consumed " + message + " " + 
									storage.get() + " " +
									System.currentTimeMillis()% 100000);
				 sleep(sleepTime);
			} catch (InterruptedException ex) {
				
			}
		}
	}

}
