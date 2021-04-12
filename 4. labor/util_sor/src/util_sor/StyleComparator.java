package util_sor;

import java.util.Comparator;

public class StyleComparator implements Comparator<Beer>{
	public int compare(Beer t, Beer t1) {
		return t.style.compareTo(t1.style);
	}
}
