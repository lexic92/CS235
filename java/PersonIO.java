

package cs235.java;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;


public class PersonIO {
    
    /**
     * Saves an array of Person objects to a file
     * 
     * @param people the array of Person objects to be stored in the file
     * @param fileName the name of the file in which to store the Person objects
     * @return true if the Person objects were successfully written to the file,
     *     or false if an error occurred
     * @throws IllegalArgumentException if people and/or fileName is null
     */
    public static boolean save(Person[] people, String fileName) {
	if(fileName == null || people == null){
		throw new IllegalArgumentException();
	}

	//Make File object. If FileNotFoundException occurs, return false.
	try{
		File fileObject = new File(fileName);
		PrintWriter out = new PrintWriter(fileObject);
		out.println(people.length);
		//Print each person into the file.
		for(Person p : people){
			
			out.println(p);
		}
		out.close();
		return true;

	}
	catch(java.io.FileNotFoundException e){
		return false;
	}
    }

    /**
     * Loads the Person objects stored in the specified file and returns them in an array
     * 
     * @param fileName the name of the file to be loaded
     * @return an array of Person objects in the same order that they appear in the file.
     *      If the file cannot be opened or the contents of the file are invalid, null is returned
     * @throws IllegalArgumentException if fileName is null
     */
    public static Person[] load(String fileName) {
	//Test for null fileName
	if(fileName == null){ 
		throw new IllegalArgumentException();
	}
	
	//If it catches a FileNotFoundException, return null.
	try{
		//Make File object
		File fileObject = new File(fileName);	
	
		//Set up scanner
		Scanner fileScanner = new Scanner(fileObject);
	
		//Set up array
		int numberOfObjectsInFile = fileScanner.nextInt();
		fileScanner.nextLine(); //Advance to the next line, 
		//since nextInt does not do that automatically.

		Person[] people = new Person[numberOfObjectsInFile];

		//Fill array with people in the same order that they appear in the file.
		for(int i = 0; i < numberOfObjectsInFile; i++){
			String testString = fileScanner.nextLine();
			if(testString.equals("student")){
				String id = fileScanner.nextLine();
				String name = fileScanner.nextLine();
				String major = fileScanner.nextLine();
				double gpa = Double.parseDouble(fileScanner.next());	
				fileScanner.nextLine(); //moving it forward because I don't 
				//think it will take a whole line as a double.
				people[i] = new StudentImpl(id, name, major, gpa);
			}
			if(testString.equals("employee")){
				String id = fileScanner.nextLine();	
				String name = fileScanner.nextLine();	
				String office = fileScanner.nextLine();
				people[i] = new EmployeeImpl(id, name, office);
			}
			fileScanner.nextLine(); //Take account of the single blank line.
		}
		//Return the array
		fileScanner.close();
		return people;
	}
	catch(java.io.FileNotFoundException e){
		return null;
	}
    }

}


