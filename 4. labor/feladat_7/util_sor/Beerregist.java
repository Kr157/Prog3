package util_sor;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Beerregist {
	static ArrayList<Beer> storage=new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Beer elso = new Beer("Soproni", "ipa", 5.0);
		Beer masodik = new Beer("Soproni", "apa", 5.2);
		System.out.printf(elso.toString() +"\n"+ masodik.toString());
		Scanner beolvas = new Scanner(System.in);		
		while(true)
		{
			String line = beolvas.nextLine();
			String cmd[] = line.split(" ");
			System.out.println(cmd[0]+" "+cmd.length);
			switch (cmd[0])
			{
			case "exit":
				exit(cmd);
				break;
			case "add":
				add(cmd);
				break;
			case "list":
				list(cmd);
				break;
			case "load":
				load(cmd);
				break;
			case "save":
				save(cmd);
				break;
			case "search":
				search(cmd);
				break;
			case "find":
				find(cmd);
				break;
			case "delete":
				delete(cmd);
				break;
			}
		}
	}
	protected static void exit(String[] cmd)
	{
		System.exit(0);
	}
	
	protected static void add(String[] cmd)
	{
		storage.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
	}
	
	protected static void list(String[] cmd)
	{
		if (cmd.length>1)
		{
			Comparator<Beer> cmp=null;
			switch(cmd[1])
			{
				case "name":
					cmp=new NameComparator();
					break;
				case "style":
					cmp=new StyleComparator();
					break;
				case "strength":
					cmp=new StrengthComparator();
					break;
				default:
					break;
			}
			Collections.sort(storage, cmp);
		}
		for(Beer element: storage)
			System.out.println(element);
	}
	
	protected static void load(String[] cmd) throws ClassNotFoundException , IOException
	{
		ObjectInputStream is=new ObjectInputStream(new FileInputStream(cmd[1]));
		storage=(ArrayList<Beer>)is.readObject();
		is.close();
	}
	
	protected static void save(String[] cmd) throws FileNotFoundException, IOException
	{
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(cmd[1]));
		os.writeObject(storage);
		os.close();
	}
	
	protected static void search(String[] cmd)
	{
		int db=0;
		for(Beer element: storage)
			if(element.getName().equals(cmd[1]))
			{
				System.out.println(element);
				db++;
			}
		if (db==0)
		{
			System.out.println("No Found");
		}
	}
	
	protected static void find(String[] cmd)
	{
		int db=0;
		for(Beer element: storage)
			if(element.getName().contains(cmd[1]))
			{
				System.out.println(element);
				db++;
			}
		if (db==0)
		{
			System.out.println("No Found");
		}
	}
	
	protected static void delete(String[] cmd)
	{
		storage.remove(Collections.binarySearch(storage, new Beer(cmd[1], null, 0), new NameComparator()));
	}
	
	
}
