package io_filesystem;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.*;


public class Main {
	public static void main(String[] args)
	{
		Filesystem fs = new Filesystem(new File(System.getProperty("user.dir")));
		try
		{
			while(true)
				fs.runcmd();
		}
		catch (IOException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
