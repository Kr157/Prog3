package casino;

//import casino.Jatekos;
import java.util.Random;

public class Asztal {
	private Jatekos jatekosok[] = new Jatekos[10];
	private double tet;
	private int kor;
	private double goal;
	private int db;
	
	void ujJatek(){
		tet = 0;
		kor = 0;
		Random rand = new Random();
		goal = rand.nextDouble() * 100;
	}
	void addJatekos (Jatekos j) {
		if (db == 10) {
			System.out.println("Az asztal megtelt");
		}
		if (db < 10) {
			db++;
			jatekosok[db-1] = j;
			j.setAsztal(this);
			
		}
	}
	int getKor() {
		return kor;
	}
	void emel(double d) {
		tet = tet + d;
	}
	void kor() {
		
		if (db == 0) 
			throw (new NincsJatekos("Nincs j�t�kos az asztaln�l!"));
		
		for(int i = 0; i < db; i++) {
			jatekosok[i].lep();
		
		
		if(tet > goal*1.1) {
			System.out.println("Vesztett!\nA c�l�rt�k: " + goal + " volt.\nA j�t�k v�get �rt!");
			break;
		}
		if((tet > goal) && (tet < goal*1.1)){
			System.out.println("Nyertes: " + jatekosok[i] + "\nA c�l�rt�k: " + goal + " volt.\nA j�t�k v�get �rt!");
			break;
		}
		}
	}
	double getTet() {
		return tet;
	}
	

}
