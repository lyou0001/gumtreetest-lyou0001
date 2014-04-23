package com.test.app.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling files
 * 
 * @author Lisa
 *
 */
public class FileManager {

	public static File openFile(final String path) {
		File f = new File(path);
		return f;
	}
	
	public static void readFile(final File f) {
		List<String> lines = new ArrayList<String>();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(f));
			String curLine = null;
			
			while ((curLine = br.readLine()) != null) {
				lines.add(curLine);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error when trying to read file " + f.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading line in file.");
			e.printStackTrace();
		} finally {
			if (br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
				
	}
	
}
