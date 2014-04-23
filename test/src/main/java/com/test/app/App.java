package com.test.app;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

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
					Person p = new Person(info[0].trim(), info[1].trim(), new SimpleDateFormat("dd/MM/yy").parse(info[2].trim()));
					persons[i] = p;
    			} catch (ParseException e) {
					System.out.println("Error converting " + info[2] + " to a date");
					e.printStackTrace();
				}
    		}
    	}
    	
    	//answer first question
    	question1(persons);
    	
    	//answer second question
    	question2(persons);
    	
    	//answer third question
    	question3(persons);
    }
    
    private static void question1(Person[] persons) {
    	System.out.println("How many males are in the address book?");
    	
    	int count=0;
    	
    	for (Person p : persons) {
    		if (p!=null && p.getGender().toLowerCase().equals("male")) {
    			count++;
    		}
    	}
    	
    	System.out.println("There are " + count + " males in the address book.");
    }
    
    private static void question2(Person[] persons) {
    	
    	System.out.println("\nWho is the oldest?");
    	
    	Person oldest = null;
    	int oldestYear = 2014;
    	
    	Calendar cal = Calendar.getInstance();
    	
    	for(Person p : persons) {
    		if (p!=null) {
	    		cal.setTime(p.getDob());
	    		int year = cal.get(Calendar.YEAR);
	    		
	    		if (year < oldestYear) {
	    			oldestYear = year;
	    			oldest = p;
	    		}
    		}
    	}
    	
    	if (oldest!=null) {
    		System.out.println(oldest.getName() + " is the oldest person.");
    	} else {
    		System.out.println("No one could be found");
    	}
    	
    }
    
    private static void question3(Person[] persons) {
    	
    	System.out.println("\nHow many days are there between Bill and Paul?");
    	
    	Person bill = null;
    	Person paul = null;
    	
    	for (Person p : persons) {
    		if (p.getName().startsWith("Bill")) {
    			bill = p;
    		} else if (p.getName().startsWith("Paul")) {
    			paul = p;
    		}
    	}
    	
    	if (bill!=null && paul!=null) {
    		DateTime dt1 = null;
    		DateTime dt2 = null;
    		
    		if (bill.getDob().after(paul.getDob())) {
    			dt1 = new DateTime(paul.getDob());
    			dt2 = new DateTime(bill.getDob());
    		} else {
    			dt1 = new DateTime(bill.getDob());
    			dt2 = new DateTime(paul.getDob());
    		}
    		
    		int days = Days.daysBetween(dt1, dt2).getDays();
    		System.out.println("There are " + days + " days between Bill and Paul."); 
    	} else {
    		System.out.println("Could not find Bill or Paul.");
    	}
    }
    
}
