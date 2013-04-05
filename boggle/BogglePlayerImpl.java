
package cs235.boggle;

import java.util.SortedSet;
import java.util.List;
import java.util.TreeSet;
import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class BogglePlayerImpl implements BogglePlayer{

	private String[] stringArray;
	private String[][] board;
	private String s = "";
	private boolean[][] visitedBoard;
	private int N = 0; //board side length
	private SortedSet validWordsSet;
	private int minimumWordLength;
	private List l;
	private boolean found;
	
	/**
	* Loads the dictionary into a data structure for later use. 
	* 
	* @param fileName A string containing the dictionary to be opened.
	* @throws IllegalArgumentException if fileName is null
	* @throws IllegalArgumentException if fileName cannot be opened.
	*/
	public void loadDictionary(String fileName){					//Change boolean to void
		if(fileName == null){
			throw new IllegalArgumentException();
		}
		//If it catches a FileNotFoundException, then throw an IllegalArgumentException.
		try{
			//Set up Scanner
			File fileObject = new File(fileName);	
			Scanner in = new Scanner(fileObject);

			//Set up ArrayList which will later be loaded into a real array.
			List stringList = new ArrayList<String>();

			//Load all the words into the string list.
			while(in.hasNext()){
				stringList.add(in.next());
			}			
			
			//Transfer from arraylist to an actual array.
			
			//Set up array
			stringArray = new String[stringList.size()];
			
			//Go through each index
			for(int i = 0; i < stringList.size(); i++){
				stringArray[i] = ((ArrayList<String>)stringList).get(i); //tranfer
			}
			in.close();
			System.out.println("Successfully loaded dictionary.");
		}
		catch(java.io.FileNotFoundException e){
			throw new IllegalArgumentException();
		}

	}
	
	/**
	*  Determines if the given word is in the dictionary.
	*  
	*  @param wordToCheck The word to validate
	*  @return true if wordToCheck appears in dictionary, false otherwise.
	*  @throws IllegalArgumentException if wordToCheck is null.
        *  @throws IllegalStateException if loadDictionary has not been called.
	*/
	public boolean isValidWord(String wordToCheck){
		if(wordToCheck == null){
			throw new IllegalArgumentException();
		}
		//If loadDictionary has not yet been called:
		if(stringArray == null){
			throw new IllegalStateException();
		}		
		int low = 0;
		int high = stringArray.length - 1; 
		//stringArray.length is the num of elements, so one less is the last index.
		int mid;
		
		while( low <= high ){
			mid = (low + high) / 2;

			//It orders it according to Strings' compareTo method.
			if(stringArray[mid].compareTo(wordToCheck) < 0) //is mid before wordToCheck?
				low = mid + 1; // Then search stuff that's greater than mid.
			else if(stringArray[mid].compareTo(wordToCheck) > 0) //is mid after wordToCheck?
				high = mid - 1; //Then search stuff that's less than mid.
			else
				return true; //This is it, so it's in the dictionary.
		}
		return false; //Not in dictionary.
	}
	
	/**
	* Determines if there is at least one word in the dictionary with the 
	* given prefix.
	* 
	* @param prefixToCheck The prefix to validate
	* @return true if prefixToCheck appears in dictionary, false otherwise.
	* @throws IllegalArgumentException if prefixToCheck is null.
	* @throws IllegalStateException if loadDictionary has not been called.
        */
	public boolean isValidPrefix(String prefixToCheck){					
		if(prefixToCheck == null){
			throw new IllegalArgumentException();
		}
		//If loadDictionary has not yet been called:
		if(stringArray == null){
			throw new IllegalStateException();
		}
		
		
		
		prefixToCheck = prefixToCheck.toLowerCase(); //Convert to lowercase
		
		
		
		int low = 0;
		int high = stringArray.length - 1; 
		//stringArray.length is the num of elements, so one less is the last index.
		int mid = 0;
		
		
		
		while( low <= high ){
			mid = (low + high) / 2;

			//It orders it according to Strings' compareTo method.
			if(stringArray[mid].compareTo(prefixToCheck) < 0) //is mid before prefixToCheck?
				low = mid + 1; // Then search stuff that's greater than mid.
			else if(stringArray[mid].compareTo(prefixToCheck) > 0) //is mid after prefixToCheck?
				high = mid - 1; //Then search stuff that's less than mid.
			else return true; //The prefix is itself a word in the dictionary, so it is valid, definitely.
		}
		
		//See if where the prefix would be alphabetically has words that start with the prefix.
		
		int prefixLength = prefixToCheck.length();
		String dictionaryWordToCompare = stringArray[mid];
		
		if(prefixLength > dictionaryWordToCompare.length()) {
			return testPreviousWord(prefixLength, prefixToCheck, mid);
		}
		for(int i = 0; i < prefixLength; i++){
			//Compare each character of prefixToCheck and the "third-to-last hope."
		
			if ( dictionaryWordToCompare.charAt(i) == prefixToCheck.charAt(i) ){     
			}
			else{
				return testPreviousWord(prefixLength, prefixToCheck, mid);
			}
		}
		return true;
		
		
		
		
	
	}
		
	public boolean testPreviousWord(int prefixLength, String prefixToCheck, int mid){
		if((mid-1) > 0){ //If there is an index less than mid...
			//Then test if the prefix fits that word.
			String dictionaryWordToCompare = stringArray[mid-1];
			if(prefixLength > dictionaryWordToCompare.length()) {
				//if the prefix isn't valid here, test the last hope.
				return testNextWord(prefixLength, prefixToCheck, mid);
			}
			for(int i = 0; i < prefixLength; i++){
				//Compare each character of prefixToCheck and the "second-to-last hope."
			
				if ( dictionaryWordToCompare.charAt(i) == prefixToCheck.charAt(i) ){     
				}
				else{
					//if the prefix isn't valid here, test the last hope.
					testNextWord(prefixLength, prefixToCheck, mid);
				}
			}
		}
		return testNextWord(prefixLength, prefixToCheck, mid);
	}
	
	
	public boolean testNextWord(int prefixLength, String prefixToCheck, int mid){
		if((mid + 1) < stringArray.length){ //If the index is not too big
			//Then test if the prefix fits that word.
			String dictionaryWordToCompare = stringArray[mid+1];
			if(prefixLength > dictionaryWordToCompare.length()) {
				return false;
			}
			for(int i = 0; i < prefixLength; i++){
				//Compare each character of prefixToCheck and the "last hope."
		
				if ( dictionaryWordToCompare.charAt(i) == prefixToCheck.charAt(i) ){     
				}
				else{
					//If something didn't match before all of the prefix was tested,
					//then not all the prefix is there in the word. So prefix doesn't
					//exist.
					return false;
				}
			}
			return true;
		}
		return false; //because there is no more hope.
	}
	/**
	*  Stores the incoming array of Strings in a fashion that will
	*       make it convenient to find words.
	* 
	*  @param letterArray Each string in this array corresponds to 
	*       a die on the Boggle board. The die are in order left to 
	*       right, top to bottom. The size of letterArray = Row X Col.
	*       Note that the Strings inside may be longer than one 
	*       character. Also note that the board might not be 4x4.
	*  @throws IllegalArgumentException if letterArray is null, or is 
	*       not square (i.e. it's the square-root of the length is not 
	*       a whole number).
	*/
	public void setBoard(String[] letterArray){
		if(letterArray == null){
			throw new IllegalArgumentException();
		}
		//Square root of the length is not a whole number 
		//(has decimal places that aren't 0).
		if((Math.sqrt(letterArray.length) % 1 ) != 0){
			throw new IllegalArgumentException();
		}

		N = (int) Math.sqrt(letterArray.length); //Side length of the box
		int letterArrayLength = letterArray.length;

		//initialize boards
		board = new String[N][N];
		visitedBoard = new boolean[N][N];
		
		int i = 0;
		//go through each row...
		for(int row = 0; row < N; row++){
			//and go through each column of each row...
			for(int column = 0; column < N; column++){
				board[row][column] = letterArray[i++]; 
				// and rotate through THAT order, going across a 
				// row first and then changing the column, when 
				// filling in the stuff from letterArray.
			}
		}

		
		//Initialize all visitedBoard to "not visited", or "false".
		//go through each row...
		for(int row = 0; row < N; row++){
			//and go through each column of each row...
			for(int column = 0; column < N; column++){
				visitedBoard[row][column] = false; 
				// and rotate through THAT order, going across a 
				// row first and then changing the column, when 
				// filling in "false."
			}
		}
	}
	
	/**
	*  Retrieves all the words in the Boggle board that appear in the 
	*       dictionary.
	*   
	*  @param minimumWordLength The minimum allowed length for 
	* 	strings that will be stated as being on the board.
	*  @return java.util.SortedSet which contains all the words found 
	* 	from the boggle board that appear in the dictionary.
	*  @throws IllegalArgumentException if minimumWordLength < 1
        *  @throws IllegalStateException if loadDictionary has not been called.
	*/
	public SortedSet getAllValidWords(int minimumWordLength){
		if(minimumWordLength < 1){
			throw new IllegalArgumentException();
		}
		//If loadDictionary has not yet been called:
		if(stringArray == null){
			throw new IllegalStateException();
		}
		this.minimumWordLength = minimumWordLength;
		
		validWordsSet = new TreeSet<String>(); //Clear set of valid words

		
		//Find possible words starting at each dice of the board.

		//go through each row...
		for(int row = 0; row < N; row++){
			//and go through each column of each row...
			for(int column = 0; column < N; column++){
				recursiveMethod(row, column, s); 
				// this will go through all possible combinations of words
				// starting at that dice until it runs out of "dice," 
				// adding valid words to the set.
			}
		}
		return validWordsSet; // a tree set that implements sorted set.


	}

	public void recursiveMethod(int x, int y, String s){
		if(x < 0 || x >= N || y < 0 || y >= N ){
			return;
		}
		if(visitedBoard[x][y]){
			return;
		}
		//If the index is inside the board and if it is not visited...
		
		s += board[x][y].toLowerCase(); // add this dice's string to the word
		if(!isValidPrefix(s)){ //Don't continue searching if not valid prefix.
			return;
		}
		//if it's a valid prefix...

		visitedBoard[x][y] = true; //Mark this dice as visited.

		if(isValidWord(s) && s.length() >= minimumWordLength){
			validWordsSet.add(s);  //If it's a valid word, add it.
		}
		//... then add any further combinations.
		recursiveMethod(x-1,	 y-1,	s);    //Row above
		recursiveMethod(x,	 	y-1,	s);
		recursiveMethod(x+1,	 y-1,	s);
		
		recursiveMethod(x-1, 	 y,	s);    //Left
		recursiveMethod(x+1,	 y,	s);	  //Right

		recursiveMethod(x-1, 	 y+1,	s);
		recursiveMethod(x, 	 	y+1,	s);	  //Row beneath
		recursiveMethod(x+1, 	 y+1,	s);
		
		//Mark this dice (or each recursive call's dice) to unvisited, because at this point,
		//the search for words at that starting point is over. Now they will all be available
		//and set to "false" for the next starting-point (called in the getAllValidWords
		//method).
	
		visitedBoard[x][y] = false;
		
		
	}
	
	/**
	*  Determines if the given word is in on the Boggle board. If so, 
	* 	it returns the path that makes up the word.
	*  
	*  @param wordToCheck The word to validate
	*  @return java.util.List containing java.lang.Integer objects with 
	* 	the path that makes up the word on the Boggle board. If word
	* 	is not on the boggle board, return null.
	*  @throws IllegalArgumentException if wordToCheck is null.
        *  @throws IllegalStateException if setBoard has not been called.
	*/
	public List isOnBoard(String wordToCheck){
		//If loadDictionary has not yet been called:
		if(wordToCheck == null){
			throw new IllegalArgumentException();
		}
		//If board has not been set, throw exception.
		if(board == null){
			throw new IllegalStateException();
		}
		
		//SET UP STUFF
		l = new LinkedList<Integer>(); //Clear the list of indexes
		String s = ""; //Clear the currentString (to compare to)
		
		//Look for this word starting at each dice of the board.

		//go through each row...
		for(int row = 0; row < N; row++){
			//and go through each column of each row...
			for(int column = 0; column < N; column++){
				isOnBoardRecursive(row, column, wordToCheck, s); 
				// this will go through all possible combinations of words
				// starting at that dice until it runs out of "dice."
			}
		}
		if(!found){
			return null;
		}
		found = false; //Sets it up all ready for the next time.
		return l;


	}

	public void isOnBoardRecursive(int x, int y, String wordToCheck, String s){
		//Base Cases proving that this is not the path to the wordToCheck:
		if(x < 0 || x >= N || y < 0 || y >= N ){
			return; //Out of bounds
		}
		if(visitedBoard[x][y] || found){
			return; //Already visited this space
		}
		//If the index is inside the board and if it is not visited...
		
		//If wordToCheck starts with this prefix...
		String test = s + board[x][y].toLowerCase();
		if(!wordToCheck.startsWith(test)){
			return; //Doesn't change s.
		}
		
		//-----------------------------------------------------------------------
		//Stuff to do when this is part of the path and it passed the tests:
		//-----------------------------------------------------------------------
		
		
		s += board[x][y].toLowerCase(); // add this dice's string to the word
	
		//Calculate the index.
		int thisIndexThatItsAdding = N*x + y;
		l.add(x*N + y); // add this dice's index to the list of indexes
		
		//If this is the end of the word, then stop.
		if(s.equals(wordToCheck)){
			found = true;
			return;
		}
		
		visitedBoard[x][y] = true; //Mark this dice as visited.
		
		isOnBoardRecursive(x-1,	 y-1,	wordToCheck,	s);		//Row above
		
		isOnBoardRecursive(x,	 y-1,	wordToCheck,	s);
		
		isOnBoardRecursive(x+1,	 y-1,	wordToCheck,	s);
		
		isOnBoardRecursive(x-1,  y,		wordToCheck,	s);		//Left
		  		
	
		isOnBoardRecursive(x+1,	 y,		wordToCheck,	s);		//Right
												

		isOnBoardRecursive(x-1,  y+1,	wordToCheck,	s);  	//Row beneath
		
		isOnBoardRecursive(x, 	 y+1,	wordToCheck,	s);
												
		isOnBoardRecursive(x+1,  y+1,	wordToCheck,	s);
		
		
		//Mark this dice (or each recursive call's dice) to unvisited, because at this point,
		//the search for words at that starting point is over. Now they will all be available
		//and set to "false" for the next starting-point (called in the getAllValidWords
		//method).
		if(!found){
			((LinkedList<Integer>)l).removeLast();
		}
		
		visitedBoard[x][y] = false;
	}
	
	/**
	* An optional method that gives a user-defined boggle board to the GUI.
	* 
	* @return a String array in the same form as the input to setBoard().
	*/
	public String[] getCustomBoard(){
		return new String[1];
	}
	
	
	
	/*
	public void printDictionary(){
		if(stringArray == null){
			System.out.println("String array is null.");
		}
		for(String e : stringArray){
			System.out.print(e);
		}
		
	}*/
				
}
	
