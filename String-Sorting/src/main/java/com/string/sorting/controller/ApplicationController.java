package com.string.sorting.controller;

import java.io.IOException;
import java.util.List;

import com.string.sorting.config.AppConfig;
import com.string.sorting.model.Name;
import com.string.sorting.service.AppService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
/**
 * Created by Vineetha on 18/07/2017.
 * Controller class to do the actual functionality
 * Testcase AppServiceTest.java is provided to test it instead
 */
public class ApplicationController {

	static final Logger logger = Logger.getLogger(ApplicationController.class);
	private static String fileName = "names.txt";

	/**
	 * Main to test the whole functionality: Reading from file, sorting and writing to new file
	 * Test cases are available to test it in junit.
	 * @param  args
	 * @throws IOException
	 */

	public static void main(String args[]) throws IOException {

		logger.debug("----------Inside main method -----------");
		System.out.println("sort names:  "+ fileName);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppService appService = (AppService) context.getBean("appService");

		List<Name> names = appService.readFromFile(fileName);
		appService.writeToFile(appService.sortByLastName(names), fileName);

		context.close();

	}

}

