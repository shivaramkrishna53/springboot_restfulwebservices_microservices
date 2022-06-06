package com.nt.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
        File f=new File("E:\\shiva java developer full stack\\in_28_mins_practise\\springboot_projects\\Project\\src\\main\\java\\com\\nt\\filehandling\\abc.txt");
        if(f.createNewFile())
        System.out.println("The file is created at::"+f.getAbsolutePath()+" location successfully");
        else
    		System.out.println("File not created!!!");
        
        System.out.println("The file name is:"+f.getName());
        System.out.println("Is the file readble::"+f.canRead());
        System.out.println("Is the file writable"+f.canWrite());
        System.out.println("Does the file exists::"+f.exists());
        System.out.println("Length of the file in bytes::"+f.length());
        FileWriter fw=new FileWriter(f);
        fw.write("hellow");
        fw.write("world");
       
        
        
        fw.write("asdfjkl");
        fw.close();
        System.out.println("Length of file is:"+f.length());
        
  
      
      System.out.println("read from one file and write to another file");
      
      File f2=new File("E:\\shiva java developer full stack\\in_28_mins_practise\\springboot_projects\\Project\\src\\main\\java\\com\\nt\\filehandling\\defg.txt");
      f2.createNewFile();
      Scanner sc=new Scanner(f);
      FileWriter fwr=new FileWriter(f2);
      while(sc.hasNext())
      {
    	  fwr.write(sc.nextLine());
    	  
      }
      sc.close();
      fwr.close();
      if(f.exists())
    	  f.delete();
   
    	}
    	
    	catch(IOException io)
    	{
    		System.out.println(io.getMessage());
    	}
    	}
}
