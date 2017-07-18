package com.string.sorting.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApplicationController {
	
	/*
	 * Method to read file
	 * 
	 * */
	public void readFile() throws IOException {
		FileInputStream inputStream=null;
		try{
		// Getting ClassLoader obj
		   ClassLoader classLoader = this.getClass().getClassLoader();
		   // Getting resource(File) from class loader
		   File configFile=new File(classLoader.getResource("names.txt").getFile());
		   
		   inputStream = new FileInputStream(configFile);
		   BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		   String line;
		   while ((line = reader.readLine()) != null) {
		   System.out.println(line);
		   }
		 
		   reader.close();
		   
		   
		}catch(FileNotFoundException e) {
			
		}
		
	}

}
