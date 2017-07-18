package com.string.sorting.service;

import java.io.IOException;
import java.util.List;

import com.string.sorting.model.Name;

/**
 * Created by Vineetha on 18/07/2017.
 * Service interface for business logic
 */
public interface AppService {

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	List<Name> readFromFile(String fileName) throws IOException;
	/**
	 * Method to sort by Last name
	 *@param names
	 *@return nameList
	 *@throws IOException
	 * */
	List<Name> sortByLastName(List<Name> names);

	/**
	 * Method to write to file
	 *@param fileName, sortedNames
	 *@throws IOException
	 * */

	void writeToFile(List<Name> sortedNames, String fileName);

}
