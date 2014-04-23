package com.test.app;

import java.io.File;
import java.util.List;

import com.test.app.filemanager.FileManager;

/**
 * Main class
 *
 */
public class App  {
	
    public static void main( String[] args ) {
        
    	//Open file
    	File addressBook = FileManager.openFile("AddressBook");
    	
    	//Get lines
    	List<String> lines = FileManager.readFile(addressBook);
    	
    	for(String l : lines) {
    		System.out.println(l);
    	}
    }
    
}
