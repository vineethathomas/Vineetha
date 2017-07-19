package com.string.sorting.service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.string.sorting.controller.ApplicationController;
import com.string.sorting.model.Name;
import org.apache.log4j.Logger;

/**
 * Created by Vineetha on 18/07/2017.
 * Implementation class for AppService Interface
 */
public class AppServiceImpl implements AppService {
	//Regex pattern for splitting
	private static final String REGEX = ", ";
	static final Logger logger = Logger.getLogger(ApplicationController.class);

     /**
	 *Method to read the file
	 *@param fileName
	 *@return names
	 *@throws IOException
	 * */
    @Override
	public List<Name> readFromFile(String fileName) throws IOException {
		FileInputStream inputStream;
		List<Name> names = null;
		try{

			ClassLoader classLoader = this.getClass().getClassLoader();
			File file=new File(classLoader.getResource(fileName).getFile());

			inputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;

			names = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				Name name = new Name();
				String[] nameSplitted = line.split(REGEX);
				name.setFirstName(nameSplitted[1]);
				name.setLastName(nameSplitted[0]);
				names.add(name);

			}

			reader.close();
		}catch(FileNotFoundException e) {
			logger.error("Error in readFromFile method", e);
		}
		return names;
	}

	/**
	 * Method to sort by Last name
	 *@param names
	 *@return nameList
	 *@throws IOException
	 * */

	public List<Name> sortByLastName(List<Name> names) {

		List<Name> nameList = names.stream().sorted(Comparator.comparing(Name::getLastName)).collect(Collectors.toList());
		return nameList;
	}


	/**
	 * Method to write to file
	 *@param fileName, sortedNames
	 *@throws IOException
	 * */

	public void writeToFile(List<Name> sortedNames, String fileName) {

		try {
			String newFileName = fileName.split(".txt")[0]+"-sorted.txt";
			File file = new File(newFileName);
			Path filePath = Paths.get(file.getName());
			List<String> names = new ArrayList<String>();
			for(Name name: sortedNames){
				 names.add(name.getLastName()+REGEX+name.getFirstName());
				 System.out.println(name.getLastName()+REGEX+name.getFirstName());
			}

			Files.write(filePath, names, Charset.forName("UTF-8"));
			System.out.println("Finished: Created file  "+ newFileName);
		} catch (IOException e) {
			logger.error("Error in writeToFile method", e);
		}


	}


}
