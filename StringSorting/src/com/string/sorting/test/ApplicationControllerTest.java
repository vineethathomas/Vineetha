package com.string.sorting.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.string.sorting.controller.ApplicationController;

public class ApplicationControllerTest {

	@Test
	public void testReadFile() throws IOException {
		ApplicationController controller = new ApplicationController();
		controller.readFile();
		//fail("Not yet implemented");
	}

}
