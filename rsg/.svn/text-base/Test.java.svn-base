

package cs235.rsg;


public class Test {
	private static RSG r;
	private static final int NUM_ITERATIONS = 10; 

	    /**
	     * Run tests on an object that implements the RSG interface
	     */
   	public static void main(String[] args) {
		testLoadAndSave();
		testGenerateSentence();
		testIllegalArguments();
	}

	public static void testLoadAndSave(){
		r = Factory.createRSG();
		
		
		boolean didItLoadGrammar = r.loadGrammar("Poem.g");
		r.saveGrammar("savedGrammarFile.g");

		System.out.println("\n\nTEST \"saveGrammar\": \n\n\n" +
		"\n\t.\t.\t.\t. "+ 
		(didItLoadGrammar ? "SUCCESSFULLY LOADED" : "FAILED") +
		"\n\t\t\t\tsavedGrammarFile.g SHOULD CONTAIN:\n");
		printComparison();	
	
	}
		
	public static void testGenerateSentence(){
		System.out.println("\n\nTEST \"generateSentence\": \n\n\n" +
		"\n\t.\t.\t.\t. "+ "CHECK THAT THE FOLLOWING SENTENCES ARE\n\t\t\t\t" +
		"ON THE LIST OF POSSIBILITIES ON THE WEBSITE.\n\n"); 
		for(int i = 0; i < NUM_ITERATIONS; i++){
			System.out.println(r.generateSentence());
		}
		
	}

	
	public static void test3(){
		System.out.println("\n\nTEST \"whateveryou test\": \n\n\n" +
		"\n\t.\t.\t.\t. "+ "PASS OR FAIL HERE"); 	
	
	}
	public static void printComparison(){
		System.out.println("{\n"+
			"<adverb>\n"+
			"warily ;\n"+
			"grumpily ;\n"+
			"}\n"+
			"\n"+
			"{\n"+
			"<object>\n"+
			"waves ;\n"+
			"big yellow flowers ;\n"+
			"slugs ;\n"+
			"}\n"+
			"\n"+
			"{\n"+
			"<start>\n"+
			"The <object> <verb> tonight. ;\n"+
			"}\n"+
			"\n"+
			"{\n"+
			"<verb>\n"+
			"sigh <adverb> ;\n"+
			"portend like <object> ;\n"+
			"die <adverb> ;\n"+
			"}\n");
	}

	public static void testIllegalArguments(){
		//Test RSGImpl.loadGrammar()'s Illegal Argument Exception
		System.out.print("\n\n\nTEST \"Illegal Argument Exceptions\": "+
		"\n\n\tLOADGRAMMAR'S EXCEPTION: \n\t.\t.\t.\t. ");
		
		boolean loadExceptionPassed = false;
		try{r.loadGrammar(null);}  //filename is null
		catch(IllegalArgumentException e){ loadExceptionPassed = true; }
		System.out.println((loadExceptionPassed ? "PASSED" : "FAILED") + "\n");

		//Test RSGImpl.saveGrammar()'s Illegal Argument Exception
		System.out.print("\n\n\tSAVEGRAMMAR'S EXCEPTION: \n\t.\t.\t.\t. ");
		
		boolean saveExceptionPassed = false;
		try{r.saveGrammar(null);}  //filename is null
		catch(IllegalArgumentException e){ saveExceptionPassed = true; }
		System.out.println((saveExceptionPassed ? "PASSED" : "FAILED") + "\n");
	}



}


