package ossze;

import java.util.Scanner;
import calc.Calculator;
import echo.Echo;

public class sum {
	public static void main(String[] args) 
	{
		int a[] = new int[100];
		int sum = 0;
		Calculator c = new Calculator();
		Scanner beolvas = new Scanner(System.in);
		for(int i = 0; i < a.length; i++) {
			System.out.println("írj be egy számot! Ha nincs több, akkor '0'-át.");
			a[i] = beolvas.nextInt();
			if (a[i] == 0) break;
			sum = c.add(sum, a[i]);
		}
		beolvas.close();
		Echo e = new Echo();
		int sumEcho = e.number(sum);
		System.out.println("sumEcho=" + sumEcho);
	}
}