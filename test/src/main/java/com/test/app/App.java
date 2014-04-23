package com.test.app;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.test.app.filemanager.FileManager;
import com.test.app.objects.Person;

/**
 * Main class
 *
 */
public class App  {
	
    public static void main( String[] args ) {
        
    	Person[] persons;
    	
    	//Open file
    	File addressBook = FileManager.openFile("AddressBook");
    	
    	//Get lines
    	List<String> lines = FileManager.readFile(addressBook);
    	
    	persons = new Person[lines.size()];
    	
    	//Convert lines to Persons
    	for(int i=0; i<lines.size(); i++) {
    		String[] info = lines.get(i).split(",");
    		
    		if (info.length < 3) {
    			System.out.println("Could not get all info for " + lines.get(i));
    		} else {
    			try {
					Person p = new Person(info[0], info[1], new SimpleDateFormat("dd/MM/yy").parse(info[2]));
					persons[i] = p;
    			} catch (ParseException e) {
					System.out.println("Error converting " + info[2] + " to a date");
					e.printStackTrace();
				}
    		}
    	}
    	
    	for (Person p : persons) {
    		System.out.println("Name : " + p.getName());
    	}
    }
    
}
