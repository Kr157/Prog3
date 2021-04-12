package util_sor;

import java.util.Comparator;

public class NameComparator implements Comparator<Beer>{
	public int compare(Beer t, Beer t1) {
		return t.name.compareTo(t1.name);
	}
}
