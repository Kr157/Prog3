package casino;

public class Robot extends Jatekos {
	
	public String toString()
	{
		return "Robot "+id+": "+asztal.getKor()+". kör.";
	}
	
	public void lep()
	{
		System.out.println(this.toString());
	}

}
