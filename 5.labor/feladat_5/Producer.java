
public class Producer extends Thread{
	private String message;
	private Fifo t;
	private int sleeptime;
	
	public Producer(Fifo s, String m, int n) {
		t = s;
		message = m;
		sleeptime = n;
	}
	
	
	public void go() throws InterruptedException {
		int i=0;
		while(true) {
			t.put(message + " " + i++);
			try {
				sleep(sleeptime);
			}
			catch (InterruptedException ex) {
				
			}
		}
	}
	
	public void run()
	{
		try {
			this.go();
		} catch (InterruptedException ex) {
			
		}
	}

}
