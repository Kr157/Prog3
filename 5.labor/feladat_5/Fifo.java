import java.util.LinkedList;

public class Fifo {
	protected LinkedList<String> s;
	{
		s = new LinkedList<String>();
	}
	
	public synchronized void put(String e) throws InterruptedException
	{
		while(s.size()>=10)
			this.wait();
		s.add(e);
		this.notify();
		System.out.println("produced "+e+" "+
							System.currentTimeMillis() % 100000);
	}
	
	public synchronized String get() throws InterruptedException
	{
		while(s.size()<=0)
			this.wait();
		String ret=s.get(0);
		s.remove(ret);
		this.notify();
		return ret;
	}


}
