package casino;

//import casino.Asztal;

abstract public class Jatekos {
	protected Asztal asztal;
	protected int id;
	protected static int sum=0;
	
	abstract public void lep();
	public Jatekos()
	{
		id=sum++;
	}
	public void setAsztal(Asztal asztals)
	{
		asztal=asztals;
	}
        

}
