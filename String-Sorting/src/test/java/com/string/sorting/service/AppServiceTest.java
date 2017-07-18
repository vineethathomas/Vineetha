package com.string.sorting.service;

import com.string.sorting.config.AppConfig;
import com.string.sorting.model.Name;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by Vineetha on 18/07/2017.
 * Test class to test all functionalities
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class AppServiceTest {

    private static String fileName = "names.txt";

    @Autowired
    private AppService appService;


    /**
     * To test readFromFile method in AppService
     * @throws IOException
     */

    @Test
    public void testReadFromFile() throws IOException {
        System.out.println("sort names:  "+ fileName);
        assertEquals(createList(), appService.readFromFile(fileName));
    }

    /**
     * To test sortByLastName method in AppService
     */
    @Test
    public void testSortByLastName() {

        assertEquals(createSortedList(), appService.sortByLastName(createList()));

    }
    /**
     * To test writeToFile method in AppService
     * @throws IOException
     */
    @Test
    public void testWriteToFile() throws IOException {

        appService.writeToFile(createSortedList(), fileName);
        File file = new File("names-sorted.txt");

        //Checks whether the new file created or not
        assertTrue(file.exists());

        List<Name> names = null;
        if (file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            names = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                Name name = new Name();
                String[] nameSplitted = line.split(", ");
                name.setFirstName(nameSplitted[1]);
                name.setLastName(nameSplitted[0]);
                names.add(name);

            }
        } else {
            // fails if the sorted file not created
            fail("File not created or the given file  doesn't exist");
        }

        //Checks whether the created file contains the names in expected sorted order
        assertEquals(names, createSortedList());

        // Uncomment the below code to delete the created file, if required.
        // deleteFile(f);

    }

    /**
     * To create initial data for testing
     */
    private List<Name> createList() {
        List<Name> names = new ArrayList<>();
        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();
        Name name4 = new Name();

        name1.setFirstName("THEODORE");
        name1.setLastName("BAKER");
        name2.setFirstName("ANDREW");
        name2.setLastName("SMITH");
        name3.setFirstName("MADISON");
        name3.setLastName("KENT");
        name4.setFirstName("FREDRICK");
        name4.setLastName("SMITH");


        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        return names;
    }

    /**
     * To create sorted data for testing
     */
    private List<Name> createSortedList() {
        List<Name> names = new ArrayList<>();
        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();
        Name name4 = new Name();

        name1.setFirstName("THEODORE");
        name1.setLastName("BAKER");
        name3.setFirstName("ANDREW");
        name3.setLastName("SMITH");
        name2.setFirstName("MADISON");
        name2.setLastName("KENT");
        name4.setFirstName("FREDRICK");
        name4.setLastName("SMITH");


        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        return names;
    }

    /**
     * To delete the created file, if not required
     */
    private void deleteFile(File file) {
    file.delete();
    }




}
