

package cs235.boggle;

import java.util.SortedSet;
import java.util.List;

public class Test {
	public static final int FOUR = 4;
    /**
     * Run tests on an object that implements the BogglePlayer interface
     */
    	public static void main(String[] args) {
		testDictionary();
		testIllegalArguments();
		testGetAllValidWords();
		testIsOnBoard();
		
    	}
	public static void testDictionary(){
		BogglePlayer b = BoggleFactory.createBogglePlayer();
		
		//Possible add-on tests: test isValidPrefix without having loaded 
		//the dictionary. Check for IllegalStateException.

		b.loadDictionary("dictionary.txt");
		//((BogglePlayerImpl)b).printDictionary();

		//---------------Test BogglePlayerImpl.isValidWord()-------------------------

		//Test word that's in the dictionary
		System.out.print("\n\n\nTEST \"ISVALIDWORD\": "+
		"\n\n\tWORD THAT IS IN DICTIONARY RETURNS TRUE:\n\t.\t.\t.\t. ");
		boolean testIsValidWordOne = b.isValidWord("abuse"); //Expect True.
		System.out.println((testIsValidWordOne ? "PASSED" : "FAILED") + "\n");
		
		//Test word that's not in the dictionary
		System.out.print("\n\n\nTEST \"ISVALIDWORD\": "+
		"\n\n\tWORD THAT IS NOT IN DICTIONARY RETURNS FALSE:\n\t.\t.\t.\t. ");
		boolean testIsValidWordTwo = b.isValidWord("aa"); //Expect False.
		System.out.println((testIsValidWordTwo ? "FAILED" : "PASSED") + "\n");




		//-----------------Test BogglePlayerImpl.isValidPrefix()-------------------------

		//Test prefix that's in the dictionary
		System.out.print("\n\n\nTEST \"ISVALIDPREFIX\": "+
		"\n\n\tPREFIX THAT IS IN DICTIONARY RETURNS TRUE:\n\t.\t.\t.\t. ");
		boolean testIsValidPrefixOne = b.isValidPrefix("aba"); //Expect True.
		System.out.println((testIsValidPrefixOne ? "PASSED" : "FAILED") + "\n");
		
		//Test prefix that's not in the dictionary
		System.out.print(
		"\n\n\tPREFIX THAT IS NOT IN DICTIONARY RETURNS FALSE:\n\t.\t.\t.\t. ");
		boolean testIsValidPrefixTwo = b.isValidPrefix("az"); //Expect False.
		System.out.println((testIsValidPrefixTwo ? "FAILED" : "PASSED") + "\n");
	}



	public static void testIllegalArguments(){
		BogglePlayer b = BoggleFactory.createBogglePlayer();

		//Test BogglePlayerImpl.loadDictionary()'s Illegal Argument Exceptions
		System.out.print("\n\n\nTEST \"LOADDICTIONARY'S Illegal Argument Exceptions\": "+
		"\n\n\tFILENAME IS NULL: \n\t.\t.\t.\t. ");
		
		boolean loadOnePassed = false;
		try{b.loadDictionary(null);}  //filename is null
		catch(IllegalArgumentException e){ loadOnePassed = true; }
		System.out.println((loadOnePassed ? "PASSED" : "FAILED") + "\n");

		System.out.print("\n\n\tFILENAME IS NONEXISTENT: \n\t.\t.\t.\t. ");
		
		boolean loadTwoPassed = false;
		try{b.loadDictionary("akldfjasdfio");}  //filename is nonexistent (assumingly)
		catch(IllegalArgumentException e){ loadTwoPassed = true; }
		System.out.println((loadTwoPassed ? "PASSED" : "FAILED") + "\n");

	}
	public static void testGetAllValidWords(){ //NOT DONE YET
		
		//Set up boggle player object, declare stuff
		BogglePlayer b = BoggleFactory.createBogglePlayer();
		b.loadDictionary("dictionary.txt");
		int minimumWordLength = FOUR;
		String[] letterArray = {"H", "E", "B", "E", "Z", "K", "T", "S", "T"};
		String[] anotherLetterArray = {"U", "G", "I", "A", "O", "H", "S", 
		"S", "T", "U", "E", "T", "Y", "N", "T", "W"};

		//Test 1 for getAllValidWords
		
		b.setBoard(letterArray);
		SortedSet set1 = b.getAllValidWords(minimumWordLength);

		System.out.print("\n\nTEST \"getAllValidWords\": \n\n\t\t"+
		"Test #1: Check that these lines are the same--> \n\n" +
		"\n\t\tExpected: [beet, seek, test, zest] \n \t\tActual: ");
		for(Object e : set1.toArray()){
			System.out.print(e + " ");
		}
		System.out.println("");
		//end of test
		

		//Test 2 for getAllValidWords

		b.setBoard(anotherLetterArray);
		SortedSet set2 = b.getAllValidWords(minimumWordLength);

		System.out.println("\n\n\t\t"+
		"Test # 2: Check that these lines are the same--> \n\n" +
		"\n\t\tExpected:  [ashen, ashes, assent, asset, enthusiast, gist, gout,\n"+
   		"\t\thiss, house, hunt, issue, nest, newt, oust, sash, sent,\n"+
   		"\t\tshot, shout, shun, shunt, shut, sigh, sight, stew,\n"+
		   "\t\ttent, tenth, test, then, thesis, this, thug, thus,\n"+
		   "\t\ttogs, tough, toughen, tout, tune, twenty, went, west]\n"+
		 "\n \t\tActual: ");
		for(Object e : set2.toArray()){
			System.out.println("\t\t" + e);
		}
		System.out.println("");
		//end of test

	}
	public static void testIsOnBoard(){
		//Set up boggle player object, declare stuff
		BogglePlayer b = BoggleFactory.createBogglePlayer();
		b.loadDictionary("dictionary.txt");
		String[] letterArray = {"H", "E", "B", "E", "Z", "K", "T", "S", "T"};
		b.setBoard(letterArray);
		//Test isOnBoard for Behest
		List behestList = b.isOnBoard("behest");
		
		System.out.print("\n\n\nTEST \"ISONBOARD\":\n");
		System.out.print("\n\n\t\t"+
				"Test # 1: Check the path for \"Behest\":" +
				"\n\t\tExpected: [2, 1, 0, 3, 7, 8]"+
		   		"\n\t\tor [2, 1, 0, 3, 7, 6]" +
				 "\n\t\tActual: ");
		for(Object e : behestList){
			System.out.print(e + " ");
		}
	
		
		//Test isOnBoard for skeet
		List skeetList = b.isOnBoard("skeet");
		
		System.out.print("\n\n\t\t"+
				"Test # 2: Check the path for \"skeet\":" +
				"\n\t\tExpected: [7, 5, 1, 3, 6]"+
				 "\n\t\tActual: ");
		for(Object e : skeetList){
			System.out.print(e + " ");
		}
		
		//Test isOnBoard for jim
		List jimList = b.isOnBoard("jim");
		
		System.out.print("\n\n\t\t"+
				"Test # 1: Check the path for \"jim\":" +
				"\n\t\tExpected: null"+
				 "\n\t\tActual: ");
		System.out.println(jimList == null ? "null" : "not null, so it failed.");
		
		
	}
}












