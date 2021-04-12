package casino;

public class Kezdo extends Jatekos {
	private String nev;
	
	public String toString()
	{
		return "Kezdo "+nev+": "+asztal.getKor()+". kor.";
	}
	
	public void lep()
	{
		System.out.println(this.toString());
		if(asztal.getKor()%2==0)
			asztal.emel(1);
	}
}
