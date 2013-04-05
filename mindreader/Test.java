

package cs235.mindreader;

import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

public class Test {
	private static MindReaderImpl mindReader1;
	private static boolean successfullyWritten1;
	private static boolean successfullyWritten2;
	private static final int ENTRIES_IN_LOADINPUT_TXT = 4;
	
    /**
     * Run tests on an object that implements the MindReader interface
     */
   	public static void main(String[] args) {
		testFactory();
		testSavePlayerProfile1();
		testSavePlayerProfile2();
		testSavePlayerProfile3();
		testLoadPlayerProfile();
		testIllegalArguments();

    	}

	public static void testFactory(){
		MindReader factoryMadeMindReader = Factory.createMindReader();

		System.out.println("\n\nTEST \"Factory.createMindReader()\": \n\n\tMindReader "
		+"IS INSTANCE OF MindReaderImpl\n" +"\n\t.\t.\t.\t." + 
		(factoryMadeMindReader instanceof MindReaderImpl ? "PASSED" : "FAILED"));
	}
		
	public static void testSavePlayerProfile1(){
		//clean slate
		mindReader1 = new MindReaderImpl(); 
	
		//Choices in Online list A
		mindReader1.makeChoice("tails"); //1
		mindReader1.makeChoice("heads");
		mindReader1.makeChoice("tails"); //2
		mindReader1.makeChoice("heads");	
		mindReader1.makeChoice("tails"); //3
		mindReader1.makeChoice("heads");
		mindReader1.makeChoice("tails"); //4
		mindReader1.makeChoice("heads");

		successfullyWritten1 = mindReader1.savePlayerProfile("pattern1.txt"); 
		//file should contain:
		// 2
		// tails heads tails heads 0 2
		// heads tails heads tails 2 0
		mindReader1.clearMemory();

		System.out.println("\n\nTEST \"savePlayerProfile\": \n\n\tSUCCESSFULLY"
		+" SAVED PROFILE BASED ON 8 MAKECHOICE METHODS\n" +"\n\t.\t.\t.\t. "+
		"pattern1.txt SHOULD CONTAIN:( any order)\n\t\t\t\t2\n\t\t\t\ttails " +
		"heads tails heads 0 2\n\t\t\t\theads tails heads tails 2 0");
	}

	public static void testSavePlayerProfile2(){

		//Choices in Online list B
		mindReader1.makeChoice("tails"); //1
		mindReader1.makeChoice("tails");
		mindReader1.makeChoice("heads"); //2
		mindReader1.makeChoice("heads"); 
		mindReader1.makeChoice("tails"); //3
		mindReader1.makeChoice("tails");
		mindReader1.makeChoice("heads"); //4
		mindReader1.makeChoice("heads");

		successfullyWritten2 = mindReader1.savePlayerProfile("pattern2.txt"); 
		//file should contain:
		// 4
		// heads tails tails heads 1 0
		// heads heads tails tails 1 0
		// tails heads heads tails 0 1
		// tails tails heads heads 0 1

		mindReader1.clearMemory();
		
		System.out.println("\n\tSUCCESSFULLY SAVED PROFILE BASED ON 8 OTHER MAKECHOICE "
		+ "METHODS\n" +"\n\t.\t.\t.\t. pattern2.txt SHOULD CONTAIN: ( any order)"+
		"\n\t\t\t\t4\n\t\t\t\t"+
		  "heads tails tails heads 1 0" +"\n\t\t\t\theads heads tails tails 1 0\n\t" +
		"\t\t\ttails heads heads tails 0 1" + "\n\t\t\t\ttails tails heads heads 0 1");
	}

	public static void testSavePlayerProfile3(){

		mindReader1.loadPlayerProfile("input.txt");
		mindReader1.savePlayerProfile("output.txt"); 
		//output.txt should contain:
		//2
		//heads tails tails heads 1 0
		//heads heads tails tails 1 0	


		System.out.println("\n\tSUCCESSFULLY LOADED input.txt AND SAVED IT\n" +
		"\n\t.\t.\t.\t. output.txt SHOULD CONTAIN:( any order)\n\t\t\t\t2\n\t"+
		"\t\t\theads tails "+
		"tails heads 1 0\n\t\t\t\theads heads tails tails 1 0");

		System.out.println("\n\tSUCCESSFULLY WRITTEN: \n\n\t.\t.\t.\t. " + 
		((successfullyWritten1 && successfullyWritten2) ? "PASSED" : "FAILED"));
		System.out.println();

	}

	public static void testLoadPlayerProfile(){
		//Clean slate
		mindReader1 = new MindReaderImpl();
		
		//Simply try the loadPlayerProfile method, and see if it returns true.
		boolean successfullyLoaded = mindReader1.loadPlayerProfile("loadInput.txt");
		
		//Find out if the keys are what they are expected to be.
		Map<String, List<Integer>> profileMap = mindReader1.getProfileMap();
		Set<String> keySet = profileMap.keySet();

		//Returns true if the keySet correctly stored the keys. Yes, there should
		//be a space after each string.
		boolean correctKeys = keySet.contains("heads heads tails tails ") && 
				keySet.contains("heads tails tails heads ") &&
				keySet.contains("tails heads heads tails ") &&
				keySet.contains("tails tails heads heads ");

		//For each key, put all the values together in a string. 
		//(They're ints, so they'll be spaced out.) Since it's a set, and an unknown
		//order, then use this string of values to compare and make sure that all the
		//values were stored.  (We can assume they are stored to the correct key, based
		//on how hard this game is to beat.)
		String valuesString = "";
		Iterator<String> keysIt = keySet.iterator();

		for(int i = 0; i < mindReader1.getNumberOfEntries(); i++){		
			List<Integer> list = profileMap.get(keysIt.next());
			valuesString = valuesString + ( (LinkedList<Integer>) list).getFirst() +
			 " " + ( (LinkedList<Integer>) list).getLast() + "  ";
		}

		//Print Results
		System.out.println("\n\n\nTEST \"loadPlayerProfile\": \n\n\tMADE IT THROUGH"
		+" THE METHOD\n " +
		"\n\t.\t.\t.\t. " + (successfullyLoaded ? "PASSED" : "FAILED") + "\n");

		System.out.println("\tKEYS ARE ACCURATE " +
		"\n\n\t.\t.\t.\t. " + (correctKeys ? "PASSED" : "FAILED") + "\n");

		System.out.println("\tVALUES ARE ACCURATE " +
		"\n\n\t.\t.\t.\t. " + "SEE IF THE FOLLOWING LINE CONTAINS TWO \"1 0\"s and TWO"+
		 "\"0 1\"s"+ "\n" +"\t\t\t\t" + valuesString +"\n");

		System.out.println("\tNUMBER OF ENTRIES IS ACCURATE\n" +
		"\n\t.\t.\t.\t. " + (mindReader1.getNumberOfEntries() == 
		ENTRIES_IN_LOADINPUT_TXT ? "PASSED" : "FAILED"));
	}

	public static void testIllegalArguments(){
	
		//Test MindReaderImpl.savePlayerProfile()'s Illegal Argument Exception
		System.out.print("\n\n\nTEST \"Illegal Argument Exceptions\": "+
		"\n\n\tSAVEPLAYERPROFILE'S EXCEPTION: \n\t.\t.\t.\t. ");
		
		boolean saveExceptionPassed = false;
		try{mindReader1.savePlayerProfile(null);}  //filename is null
		catch(IllegalArgumentException e){ saveExceptionPassed = true; }
		System.out.println((saveExceptionPassed ? "PASSED" : "FAILED") + "\n");

		//Test MindReaderImpl.loadPlayerProfile()'s Illegal Argument Exception
		System.out.print("\n\n\tLOADPLAYERPROFILE'S EXCEPTION: \n\t.\t.\t.\t. ");
		
		boolean loadExceptionPassed = false;
		try{mindReader1.loadPlayerProfile(null);}  //filename is null
		catch(IllegalArgumentException e){ loadExceptionPassed = true; }
		System.out.println((loadExceptionPassed ? "PASSED" : "FAILED") + "\n");

		//Test MindReaderImpl.makeChoice()'s Illegal Argument Exception
		System.out.print("\n\n\tMAKECHOICE'S EXCEPTION: \n\t.\t.\t.\t. ");
		
		boolean makeChoiceExceptionPassed = false;
		try{mindReader1.makeChoice("headss");}  //choice is not "heads" or "tails"
		catch(IllegalArgumentException e){ makeChoiceExceptionPassed = true; }
		System.out.println((makeChoiceExceptionPassed ? "PASSED" : "FAILED") + "\n");



	}

}


