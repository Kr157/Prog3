package util_sor;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Beer>{
	public int compare(Beer t, Beer t1) {
		if(t.strength==t1.strength)
			return 0;
		else if(t.strength<t1.strength)
			return -1;
		else 
			return 1;
	}
}
