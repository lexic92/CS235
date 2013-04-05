

package cs235.mindreader;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class MindReaderImpl implements MindReader {
	private int playerScore;
	private int mindReaderScore;
	private int numberOfEntries;
	private Map<String, List<Integer>> profileMap;
	private List<String> lastFourChoices;
	private final int REQUIRED_NUM_IN_LIST = 4;
	private final int INDEX_3 = 3;

	/**
	Constructs a MindReaderImpl with 0 ints and empty maps/lists.
	*/
	public MindReaderImpl(){
		playerScore = 0;
		mindReaderScore = 0;
		numberOfEntries = 0;
		profileMap = new HashMap<String, List<Integer>>();
		lastFourChoices = new LinkedList<String>();

	}


	   /**
	     * Saves the player's profile to a file
	     * 
	     * @param filename the name of the file in which to store the profile
	     * @return true if the profile was successfully written to the file,
	     *         or false if an error occurred
	     * @throws IllegalArgumentException if filename is null
	     */
   	public boolean savePlayerProfile(String filename){
		if(filename == null){
			throw new IllegalArgumentException();
		}
		//Make File object. If FileNotFoundException occurs, return false.
		try{
			//Set up PrintWriter
			File fileObject = new File(filename);
			PrintWriter out = new PrintWriter(fileObject);
			
			//Print the number, then the pattern and Linked Lists on each line.
			out.println(numberOfEntries);
			for(String e : profileMap.keySet()){
				out.print(e); //The string already includes the space
				//after the last choice.
				//Get the iterator of the linked list corresponding to 
				//the current pattern.
				Iterator<Integer> it = (profileMap.get(e)).iterator();
				out.println(it.next() + " " + it.next()); //Print first item in 
				//list, then the next. (LinkedList items are integers.)
			}

			out.close();
			return true;
		}
		catch(java.io.FileNotFoundException e){
			return false;
		}
		catch(java.lang.NullPointerException e){
			return false;
		}
		
	}





	    /**
	     * Loads the player's profile from a file
	     * 
	     * @param filename the name of the file to be loaded
	     * @return true if the profile was successfully loaded from the file,
	     *         or false if an error occurred
	     * @throws IllegalArgumentException if filename is null
	     */
    	public boolean loadPlayerProfile(String filename){
		//Test for null filename
		if(filename == null){
			throw new IllegalArgumentException();
		}
		//If it catches a FileNotFoundException, return false.
		try{
			//Set up Scanner
			File fileObject = new File(filename);	
			Scanner in = new Scanner(fileObject);
			
			//Scan first line
			numberOfEntries = in.nextInt();
			in.nextLine();

			//Load the patterns and numbers of heads and tails, in a map format.
			loadPattern(numberOfEntries, in);
			
			in.close();
			return true;
		}
		catch(java.io.FileNotFoundException e){
			return false;
		}

	}

	/**
	Scans a player profile file, and alters the private field "profileMap" by putting entries
	on it that link patterns to a linked list of heads and tails.

	@param numberOfEntries  the first int of the file (should have been loaded from the
	loadPlayerProfile method
	@param in the Scanner that should already have been set up from loadPlayerProfile method
	to read the file
	*/
	private void loadPattern(int numberOfEntries, Scanner in){
		//Clear the old profileMap
		profileMap = new HashMap<String, List<Integer>>();

		for(int i = 0; i < numberOfEntries; i++){

			//Make a new LinkedList to go with each pattern. It won't overwrite
			//the old one because it will go out of scope each iteration.
			List<Integer> LL = new LinkedList<Integer>();
			
			//Store info from Scanner
			String pattern = in.next() + " " + in.next() + " " + in.next() + " " + in.next() + " ";
			LL.add(in.nextInt()); //Add number of heads
			LL.add(in.nextInt()); //Add number of tails

			//Add Entry to Map (private field of this class)
			profileMap.put(pattern, LL);

			//Go to next line to read next pattern.
			in.nextLine();
		}
	}



	    /**
	     * Give the player's choice to the mind reader.
	     * Compare the choice to the prediction and increment the score.
	     * Learn how to make better predictions based on the given choice.
	     *
	     * @param choice the string "heads" if the choice is heads,
	     *         or the string "tails" if the choice is tails
	     *
	     * @throws IllegalArgumentException if choice is not "heads" or "tails"
	     */
   	public void makeChoice(String choice){
		//Throw exception if choice isn't heads or tails
		if( !(choice.equals("heads")) && !(choice.equals("tails")) ){
			throw new IllegalArgumentException();
		}
		
		//Compare choice to prediction and increment score.
		String prediction = getPrediction();
		if(prediction.equals(choice)){
			mindReaderScore++;
		}
		else{
			playerScore++;
		}
		//-------------Learn how to make better predictions----------
		
		final int MAX_ELEMENTS = 4;

		//Update PlayerProfile based on most recent choice
		
		//If there are 0, 1, 2, or 3 items in lastFourChoices list,
		//then simply add on the most recent choice. Then this method
		//is complete. Nothing to add into PlayerProfile yet.
		if(lastFourChoices.size() < MAX_ELEMENTS){
			lastFourChoices.add(choice);
			return;
		}


		//Change lastFourChoices linked list into a String. 
		//(These choices don't include the current choice!!!)
		String lastFourChoicesIntoMapKey = lastFourChoices.get(0) + " " +
		lastFourChoices.get(1) + " " + lastFourChoices.get(2) + " " + 
		lastFourChoices.get(INDEX_3) + " ";

		//If the pattern already exists, increment appropriate number.
		if(profileMap.containsKey(lastFourChoicesIntoMapKey)){
			List<Integer> LL =  (LinkedList<Integer>) profileMap.get(lastFourChoicesIntoMapKey);
			if(choice.equals("heads")){
				int oldNumHeads = ((LinkedList<Integer>)LL).getFirst();
				int newNumHeads = ++oldNumHeads;
				((LinkedList<Integer>)LL).removeFirst();
				((LinkedList<Integer>)LL).addFirst(newNumHeads);
			}
			else{
				int oldNumTails = ( (LinkedList<Integer>) LL).getLast();
				int newNumTails = ++oldNumTails;
				( (LinkedList<Integer>) LL).removeLast();
				( (LinkedList<Integer>) LL).addLast(newNumTails);
			}
		}
		//If not, add a new pattern to the profileMap.
		else{
			//Set up the value for the new key
			List<Integer> LL = new LinkedList<Integer>();
			
			//Increment the value's heads or tails data
			if(choice.equals("heads")){
				
				LL.add(1); //First int is 1 for one heads choice
				LL.add(0);
			}
			else{
				LL.add(0);
				LL.add(1); //Second int is 1 for one tails choice
			}
			profileMap.put(lastFourChoicesIntoMapKey, LL);
			numberOfEntries++; //Can't forget this!! This is accurate because
			//this is the only code that puts something on the map, other than
			//in the load method.
		}

		//Lastly, update the lastFourChoices LinkedList
		((LinkedList<String>)lastFourChoices).removeFirst();
		lastFourChoices.add(choice);
		
			

	}  




	    /**
	     * Ask the mind reader for a prediction.
	     * 
	     * @return the string "heads" if the prediction is heads,
	     *         or the string "tails" if the prediction is tails
	     */
   	public String getPrediction(){
		if(lastFourChoices.size() < REQUIRED_NUM_IN_LIST){
			return "heads";
		}

		//Change lastFourChoices linked list into a String. 
		//(These choices don't include the current choice!!!)
		String lastFourChoicesIntoMapKey2 = lastFourChoices.get(0) + " " +
		lastFourChoices.get(1) + " " + lastFourChoices.get(2) + " " +
		 lastFourChoices.get(INDEX_3) + " ";

		//Make sure the key is in the map. If not, choose heads.  Don't worry about
		//adding it to the map, because makeChoice method does that.
		//Get the linked list that matches this pattern. If not, then assume
		//it hasn't been a pattern yet.
		if(profileMap.containsKey(lastFourChoicesIntoMapKey2)){
			List<Integer> LLToPredict = profileMap.get(lastFourChoicesIntoMapKey2);
			int numHeads = ( (LinkedList<Integer>) LLToPredict).getFirst(); //Should auto-unbox these.
			int numTails = ( (LinkedList<Integer>) LLToPredict).getLast();
			//If equal stats, choose heads. Or, choose the higher number.
			if(numHeads >= numTails){
				return "heads";
			}
			return "tails";
		}
		return "heads";
	}





	    /**
	     * Returns the player's score
	     *
	     * @return the player's score
	     */
   	public int getPlayerScore(){
		return playerScore;

	}




	    /**
	     * Returns the mind reader's score
	     *
	     * @return the mind reader's score
	     */
    	public int getMindReaderScore(){
		return mindReaderScore;
	}

	/**
	Returns the profileMap
	@return the profileMap
	*/
	public Map<String, List<Integer>> getProfileMap(){
		return profileMap;
	}

	/**
	Returns the numberOfEntries
	@return the numberOfEntries
	*/
	public int getNumberOfEntries(){
		return numberOfEntries;
	}
	/**
	Clears the player profile (profileMap), scores, last four choices, and number of entries.
	 Especially useful after saving and then not loading.
	*/
	public void clearMemory(){
		playerScore = 0;
		mindReaderScore = 0;
		numberOfEntries = 0;
		profileMap = new HashMap<String, List<Integer>>();
		lastFourChoices = new LinkedList<String>();
	}


}

