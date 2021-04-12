package io_filesystem;

import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;

public class Filesystem {
	File dir;
	Filesystem (File f)
	{
		this.dir = f;
	}
	
	Scanner beolvas = new Scanner(System.in);
	void runcmd() throws IOException
	{
		String line = beolvas.nextLine();
		String cmd[] = line.split(" ");
		switch (cmd[0])
		{
		case "exit":
			exit(cmd);
			break;
		case "pwd":
			pwd(cmd);
			break;
		case "cd":
			cd(cmd);
			break;
		case "ls":
			ls(cmd);
			break;
		case "mkdir":
			mkdir(cmd);
			break;
		case  "cp":
			cp(cmd);
			break;
		case "head":
			head(cmd);
			break;
		}
	}
	
	private void exit(String[] cmd)
	{
		System.exit(0);
	}
	
	private void pwd(String[] cmd) throws IOException
	{
		System.out.println(dir.getCanonicalPath());
	}
	
	private void cd(String[] cmd)
	{
		if(cmd[1].equals(".."))
			dir = dir.getParentFile();
		else 
			dir = new File(dir, cmd[1]);
	}
	
	private void ls(String[] cmd) throws IOException
	{
		if(cmd.length>1 && cmd[1].equals("-l"))
		{
			for(File file: dir.listFiles())
			{
				System.out.println(file.getName()+ " " +file.length()+ " " +Files.probeContentType(file.toPath()));
			}
		}
		
		for(File file: dir.listFiles())
		{
			System.out.println(file.getName());
		}

	}
	
	private void mkdir(String[] cmd)
	{
		File newdir=new File(dir, cmd[1]);
		newdir.mkdir();
	}
	
	private void cp(String[] cmd) throws FileNotFoundException, IOException
	{
		FileInputStream fin=new FileInputStream(cmd[1]);
		FileOutputStream fout=new FileOutputStream(cmd[2]);
		int c;
		while((c=fin.read())!=-1)
		{
			fout.write(c);
		}
		fin.close();
		fout.close();
	}
	
	private void head(String[] cmd) throws FileNotFoundException, IOException
	{
		int n=10;
		File f;
		if(cmd[1].equals("-n"))
		{
			n=Integer.parseInt(cmd[2]);
			f=new File(dir, cmd[3]);
			n = Integer.parseInt(cmd[3]);
		}
		else
			f=new File(dir, cmd[1]);
		BufferedReader in=new BufferedReader(new FileReader(f));
		for(int i=0;i<n;i++)
			System.out.println(in.readLine());
		in.close();		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
