
package cs235.rsg;

import java.util.TreeMap;
import java.util.Map;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class RSGImpl implements RSG {


	private Map<String, LinkedList<LinkedList<String>>> definitionsMap;


	public RSGImpl(){
		definitionsMap = new TreeMap<String, LinkedList<LinkedList<String>>>();
	}
	    /**
	     * Load a grammar into the random sentence generator
	     * 
	     * @param filename the name of the file to be loaded
	     * @return true if the grammar was successfully loaded from the file,
	     *         or false if an error occurred
	     * @throws IllegalArgumentException if filename is null
	     */
	public boolean loadGrammar(String filename){ //LOOKS GOOD TO ME
		//Test for null filename
		if(filename == null){
			throw new IllegalArgumentException();
		}
		//If it catches a FileNotFoundException, return false.
		try{
			//Set up Scanner
			File fileObject = new File(filename);	
			Scanner in = new Scanner(fileObject);


			while(in.hasNext()){
				String test = in.next();

				if(test.equals("{")){

					//Declare stuff
					List<LinkedList<String>> listOfRules = new 
					 LinkedList<LinkedList<String>>(); //It will append "Rules"
					// (lists of words) to this list of rules.
					String angleBracketsVar;
					String wordOfRule;
					
					
					//Read the variable in angle brackets. This is the key of the map.
					angleBracketsVar = in.next();
						/**/ System.out.println(angleBracketsVar);
				
					//While it isn't the end of the definition, store a rule.
					wordOfRule = in.next();
					while( !(wordOfRule.equals("}"))){	
						
						//This needs to be a new one for each rule, so it's declared here.
						List<String> listOfWordsInRule = new 
						 LinkedList<String>(); //Make this a linked list
						
						//If it's not ";", append it to the list of words.
						while(!(wordOfRule.equals(";"))){
							listOfWordsInRule.add(wordOfRule);
							/**/ System.out.println("Added word: " + wordOfRule);
							wordOfRule = in.next();
						} 
						// The wordOfRule is ;, so it's done.
						// Add the listOfWordsInRule (which is a rule) to the listOfRules.
						((LinkedList<LinkedList<String>>) listOfRules)
						  .add((LinkedList<String>)listOfWordsInRule);
						/**/ System.out.println("Just added a rule");
					
						//Look for more rules, adding them until it sees a "}".
						wordOfRule = in.next();
					}
					//Add definition to map.
					definitionsMap.put(angleBracketsVar, (LinkedList<LinkedList<String>>) listOfRules);
					/**/System.out.println("Added definition to the map.");

                                        
					//Repeat this loop, skipping garbage until it sees "{".
				}
                                else{/**/System.out.println("GARBAGE: " + test);}
                        }
			in.close();
			return true;
		}
		catch(java.io.FileNotFoundException e){
			return false;
		}
	}

	    /**
	     * Save the current grammar to a file.
	     * 
	     * @param filename the name of the file in which to store the grammar
	     * @return true if the grammar was successfully written to the file,
	     *         or false if an error occurred
	     * @throws IllegalArgumentException if filename is null
	     */
    	public boolean saveGrammar(String filename){ //LOOKS GOOD TO ME
		if(filename == null){
			throw new IllegalArgumentException();
		}
		//Make File object. If FileNotFoundException occurs, return false.
		try{
			//Set up PrintWriter
			File fileObject = new File(filename);
			PrintWriter out = new PrintWriter(fileObject);
			
			//Go through every definition (key).
			//for each list (List<...>) of rules (List<String>)

			for(String e1 : definitionsMap.keySet()){
				out.println("{");
				out.println(e1); //Prints the key, which is angleBracketsVar.

				//Declare rules list
				List<LinkedList<String>> rulesList = definitionsMap.get(e1);

				//Go through every rule.
				for(List<String> e2 : rulesList){

					//Declare words list
					List<String> wordsList = e2;
					
					//Print each word in the rule.
					for(String e3 : wordsList){
						out.print(e3 + " ");
					}
					//Finish that line with a semicolon
					out.println(";");
				}
				//Finish this definition
				out.println("}\n");
			}
			out.close();
			return true;
		}
		catch(java.io.FileNotFoundException e){
			return false;
		}
	}

	    /**
	     * Generate a random sentence using the loaded grammar
	     * 
	     * @return a sentence generated randomly from the grammar.
	     */
    	public String generateSentence(){
		
		String generatedSentence = "";
		List<LinkedList<String>> listOfRules = definitionsMap.get("<start>");

		//Choose a random rule from <start>	
		int randomIndex = (int) (Math.random() * listOfRules.size());
		List<String> listOfWordsInRule = listOfRules.get(randomIndex);

		for(String e : listOfWordsInRule){
			if(e.charAt(0) == '<'){
				generatedSentence += generateSentenceMore(e);				
			}
			else{
				generatedSentence += e + " ";
			}
		}
		return generatedSentence;

	}
		/*
		 * Keeps generating the sentence (is able to do recursive calls)
		 *
		 * @return a sentence fragment to be added to the one in "generateSentence" method.
		 */
	private String generateSentenceMore(String key){
		List<LinkedList<String>> listOfRules = definitionsMap.get(key);
		String sentenceFragment = "";

		//Choose a random rule from <???> (whatever the key was)	
		int randomIndex = (int) (Math.random() * listOfRules.size());
		List<String> listOfWordsInRule = listOfRules.get(randomIndex);

		//Go through this rule, expanding as necessary.
		for(String e : listOfWordsInRule){
			if(e.charAt(0) == '<'){
				sentenceFragment += generateSentenceMore(e);				
			}
			else{
				sentenceFragment += e + " ";
			}
		}
		return sentenceFragment;
	}


}


















