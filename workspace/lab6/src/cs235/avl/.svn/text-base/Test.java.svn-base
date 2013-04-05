package cs235.avl;

import java.util.Set;
import java.util.Iterator;

//package cs235.avl;


public class Test {
	public static final int EIGHT = 8;
    /**
     * Run tests on AVL trees.
     */
    public static void main(String[] args) {
    	testSizeAddContainsClear();
    	testRemove();
    	testIterator();
    }
    public static void part1(Set s){
     	System.out.print("Testing Set.size() returns zero: ");
    	System.out.println(s.size() == 0 ? "PASSED\n\n" : "FAILED\n\n");
    	
    	System.out.println("Testing Set.contains() returns false for each item in List A: ");
    	System.out.println("(List A: [fungible, tautology, epiphany, fisticuffs, "+
    			"enigma, alabaster, debacle, bogus])\n");
    	System.out.println("fungible: "+ (s.contains("fungible") ? "FAILED" : "PASSED"));
    	System.out.println("tautology: "+ (s.contains("tautology") ? "FAILED" : "PASSED"));
    	System.out.println("epiphany: "+ (s.contains("epiphany") ? "FAILED" : "PASSED"));
    	part1_2(s);
    }
    public static void part1_2(Set s){
    	System.out.println("fisticuffs: "+ (s.contains("fisticuffs") ? "FAILED" : "PASSED"));
    	System.out.println("enigma: "+ (s.contains("enigma") ? "FAILED" : "PASSED"));
    	System.out.println("alabaster: "+ (s.contains("alabaster") ? "FAILED" : "PASSED"));
    	System.out.println("debacle: "+ (s.contains("debacle") ? "FAILED" : "PASSED"));
    	System.out.println("bogus: "+ (s.contains("bogus") ? "FAILED" : "PASSED"));
    }
    public static void part2(Set s){
    	System.out.print("Testing if Set.size() returns 8: ( just added the 8 words from list A) ");
    	System.out.println(s.size() == EIGHT ? "PASSED\n\n" : "FAILED\n\n");
    	
    	System.out.println("Testing Set.contains() returns true for each item in List A: ");
    	System.out.println("(List A: [fungible, tautology, epiphany, fisticuffs, enigma,"+
    			" alabaster, debacle, bogus])\n");
    	System.out.println("fungible: "+ (s.contains("fungible") ? "PASSED" : "FAILED"));
    	System.out.println("tautology: "+ (s.contains("tautology") ? "PASSED" : "FAILED"));
    	System.out.println("epiphany: "+ (s.contains("epiphany") ? "PASSED" : "FAILED"));
    	part2_2(s);
    }
    public static void part2_2(Set s){	
    	System.out.println("fisticuffs: "+ (s.contains("fisticuffs") ? "PASSED" : "FAILED"));
    	System.out.println("enigma: "+ (s.contains("enigma") ? "PASSED" : "FAILED"));
    	System.out.println("alabaster: "+ (s.contains("alabaster") ? "PASSED" : "FAILED"));
    	System.out.println("debacle: "+ (s.contains("debacle") ? "PASSED" : "FAILED"));
    	System.out.println("bogus: "+ (s.contains("bogus") ? "PASSED" : "FAILED"));
    }
    
    public static void testSizeAddContainsClear(){
    	System.out.println("\n-------------TESTING SIZE, ADD, CONTAINS,"+
    			"AND CLEAR METHODS----------------------------\n");
    	
    	Set s = SetFactory.createSet();
    	
    	part1(s);
    	
    	System.out.println("\n-----------------------------------------\n");
    	
    	s.add("fungible");
    	s.add("tautology");
    	s.add("epiphany");
    	s.add("fisticuffs");
    	
    	s.add("enigma");
    	s.add("alabaster");
    	s.add("debacle");
    	s.add("bogus");
    	
       	part2(s);
    	
    	s.clear();
    	
     	System.out.print("\n\nTesting Set.size() returns 0: ( just called clear method) ");
    	System.out.println(s.size() == 0 ? "PASSED" : "FAILED\n\n");
    	
    }
    public static void testRemove(){
    	Set s = SetFactory.createSet();
    	
    	System.out.println("\n\n------------TESTING REMOVE--------------------\n");
    	
    	//Add items in List A.
    	s.add("fungible");s.add("tautology");s.add("epiphany");s.add("fisticuffs");
    	s.add("enigma");s.add("alabaster");s.add("debacle");s.add("bogus");
    	
    	//Add items in List B.
    	s.add("heresy");s.add("bombastic");s.add("sentient");s.add("blitzkrieg");
    	s.add("infernal");s.add("euphoric");s.add("plethora");s.add("azure");
    	
    	removeSomeMore(s);
    	
    	System.out.println("\n\nTesting Set.size() returns 8: ");
    	System.out.println("(Just added 8 items from List A,\n"+
    			"added 8 items from List B,\n"+
    			"removed the 8 List A items,\n"+
    			"and removed 8 non-added List C items.)\n");
    	
    	System.out.println(s.size() == EIGHT ? "PASSED" : "FAILED\n\n");
    	part3(s);
    	part4(s);
    }
    
    public static void removeSomeMore(Set s){
    	//Remove items in List A.
    	s.remove("fungible");s.remove("tautology");s.remove("epiphany");s.remove("fisticuffs");
    	s.remove("enigma");s.remove("alabaster");s.remove("debacle");s.remove("bogus");
    	
    	//Remove items in List C.
    	s.remove("cacophony");s.remove("lollygag");s.remove("luscious");s.remove("yurt");
    	s.remove("macabre");s.remove("soporific");s.remove("ergo");s.remove("pedantic");
    }
    public static void part3(Set s){
    	
    	//Check that "contains" returns "false" for each item in List A.
    	System.out.println("Testing Set.contains() returns FALSE for each item in "+
    			"List A: (Look for each line to say \"PASSED\".)");
    	System.out.println("(List A: [fungible, tautology, epiphany, fisticuffs, "+
    			"enigma, alabaster, debacle, bogus])\n");
    	System.out.println("fungible: "+ (s.contains("fungible") ? "FAILED" : "PASSED"));
    	System.out.println("tautology: "+ (s.contains("tautology") ? "FAILED" : "PASSED"));
    	System.out.println("epiphany: "+ (s.contains("epiphany") ? "FAILED" : "PASSED"));
    	part3_2(s);
    	
    	
    }
    public static void part3_2(Set s){
    	System.out.println("fisticuffs: "+ (s.contains("fisticuffs") ? "FAILED" : "PASSED"));
    	System.out.println("enigma: "+ (s.contains("enigma") ? "FAILED" : "PASSED"));
    	System.out.println("alabaster: "+ (s.contains("alabaster") ? "FAILED" : "PASSED"));
    	System.out.println("debacle: "+ (s.contains("debacle") ? "FAILED" : "PASSED"));
    	System.out.println("bogus: "+ (s.contains("bogus") ? "FAILED" : "PASSED"));
    }
    public static void part4(Set s){
    	//Check that "contains" returns "true" for each item in List B.
    	
    	System.out.println("\n\nTesting Set.contains() returns true for each item in List B: ");
    	System.out.println("(List B: [heresy, bombastic, sentient, blitzkrieg,"+
    			" infernal, euphoric, plethora, azure])\n");
    	System.out.println("heresy: "+ (s.contains("heresy") ? "PASSED" : "FAILED"));
    	System.out.println("bombastic: "+ (s.contains("bombastic") ? "PASSED" : "FAILED"));
    	System.out.println("sentient: "+ (s.contains("sentient") ? "PASSED" : "FAILED"));
    	part4_2(s);
    }
    public static void part4_2(Set s){
    	System.out.println("blitzkrieg: "+ (s.contains("blitzkrieg") ? "PASSED" : "FAILED"));
    	System.out.println("infernal: "+ (s.contains("infernal") ? "PASSED" : "FAILED"));
    	System.out.println("euphoric: "+ (s.contains("euphoric") ? "PASSED" : "FAILED"));
    	System.out.println("plethora: "+ (s.contains("plethora") ? "PASSED" : "FAILED"));
    	System.out.println("azure: "+ (s.contains("azure") ? "PASSED" : "FAILED"));
    }
    public static void testIt1(Set s){
    	//Add items in List A.
    	s.add("fungible");s.add("tautology");s.add("epiphany");s.add("fisticuffs");
    	s.add("enigma");s.add("alabaster");s.add("debacle");s.add("bogus");
    	
    	System.out.println("\n\nTesting s.iterator() iterates over ListA in this order: ");
    	System.out.println("[epiphany, debacle, fungible, alabaster,\n"+
    			"enigma, fisticuffs, tautology, bogus]\n"+
    			"\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it = s.iterator();
    	while(it.hasNext()){
    		String string = (String) it.next();
    		System.out.print(string + "\n ");
    	}
    	
    }
    public static void testIt2(Set s){

    	System.out.println("\n\n--------------------------------\n");
    	//Add items in List B.
    	s.add("heresy");s.add("bombastic");s.add("sentient");s.add("blitzkrieg");
    	s.add("infernal");s.add("euphoric");s.add("plethora");s.add("azure");
    	
    	System.out.println("\n\nJust added the items in List B.  Expected order: \n");
    	System.out.println("[epiphany, bogus, heresy, azure,\n"+
    			"debacle, fisticuffs, sentient, alabaster,\n"+
    			"blitzkrieg, bombastic, enigma, euphoric,\n"+
    			"fungible, infernal, tautology, plethora]\n\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it2 = s.iterator();
    	while(it2.hasNext()){
    		String string = (String) it2.next();
    		System.out.print(string + "\n ");
    	}
    	
    }
    public static void testIt3(Set s){
    	System.out.println("\n\n--------------------------------\n");
    	//Remove items in List A.
    	s.remove("fungible");s.remove("tautology");s.remove("epiphany");s.remove("fisticuffs");
    	s.remove("enigma");s.remove("alabaster");s.remove("debacle");s.remove("bogus");
    	
    	System.out.println("\n\nJust removed the items in List A.  Expected order: \n");
    	System.out.println("[euphoric, blitzkrieg, plethora, azure\n"+
    			"bombastic, heresy, sentient, infernal]\n\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it3 = s.iterator();
    	while(it3.hasNext()){
    		String string = (String) it3.next();
    		System.out.print(string + "\n ");
    	}
    }
    public static void testIt4(Set s){
    	System.out.println("\n\n--------------------------------\n");
    	//Add items in List C.
    	s.add("cacophony");s.add("lollygag");s.add("luscious");s.add("yurt");
    	s.add("macabre");s.add("soporific");s.add("ergo");s.add("pedantic");
    	
    	System.out.println("\n\nJust added the items in List C.  Expected order: \n");
    	System.out.println("[euphoric, blitzkrieg, lollygag, azure,\n"+
    			"cacophony, infernal, plethora, bombastic,\n"+
    			"ergo, heresy, macabre, soporific,\n"+
    			" luscious, pedantic, sentient, yurt]\n\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it4 = s.iterator();
    	while(it4.hasNext()){
    		String string = (String) it4.next();
    		System.out.print(string + "\n ");
    	}
    }
    public static void testIt5(Set s){
    	System.out.println("\n\n--------------------------------\n");
    	//Remove items in List B.
    	s.remove("heresy");s.remove("bombastic");s.remove("sentient");s.remove("blitzkrieg");
    	s.remove("infernal");s.remove("euphoric");s.remove("plethora");s.remove("azure");
    	
    	System.out.println("\n\nJust removed the items in List B.  Expected order: \n");
    	System.out.println("[lollygag, cacophony, soporific, ergo,\n"+
    			"macabre, yurt, luscious, pedantic]\n\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it5 = s.iterator();
    	while(it5.hasNext()){
    		String string = (String) it5.next();
    		System.out.print(string + "\n ");
    	}
    }
    public static void testIt6(Set s){
    	System.out.println("\n\n--------------------------------\n");
      	//Add items in List A.
    	s.add("fungible");s.add("tautology");s.add("epiphany");s.add("fisticuffs");
    	s.add("enigma");s.add("alabaster");s.add("debacle");s.add("bogus");
    	
    	System.out.println("\n\nJust added the items in List A.  Expected order: \n");
    	System.out.println("[lollygag, ergo, soporific, cacophony,\n"+
    			"fungible, macabre, yurt, alabaster,\n"+
    			"enigma, fisticuffs, luscious, pedantic,\n"+
    			"tautology, bogus, debacle, epiphany]\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it6 = s.iterator();
    	while(it6.hasNext()){
    		String string = (String) it6.next();
    		System.out.print(string + "\n ");
    	}
    }
    public static void testIt7(Set s){
    	System.out.println("\n\n--------------------------------\n");
    	//Add items in List B.
    	s.add("heresy");s.add("bombastic");s.add("sentient");s.add("blitzkrieg");
    	s.add("infernal");s.add("euphoric");s.add("plethora");s.add("azure");
    	
    	System.out.println("\n\nJust added the items in List B.  Expected order: \n");
    	System.out.println("[lollygag, cacophony, soporific, bogus,\n"+
    			"ergo, macabre, yurt, azure,\n"+
    			"bombastic, enigma, fungible, luscious,\n"+
    			"plethora, tautology, alabaster, blitzkrieg,\n"+
    			"debacle, epiphany, fisticuffs, heresy,\n"+
    			"pedantic, sentient, euphoric, infernal]\n\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it7 = s.iterator();
    	while(it7.hasNext()){
    		String string = (String) it7.next();
    		System.out.print(string + "\n ");
    	}
    }
    public static void testIt8(Set s){
    	System.out.println("\n\n--------------------------------\n");
    	//Remove items in List C.
    	s.remove("cacophony");s.remove("lollygag");s.remove("luscious");s.remove("yurt");
    	s.remove("macabre");s.remove("soporific");s.remove("ergo");s.remove("pedantic");
    	
    	System.out.println("\n\nJust removed the items in List C.  Expected order: \n");
    	System.out.println("[euphoric, debacle, plethora, bogus,\n"+
    			"enigma, fungible, sentient, azure,\n"+
    			"bombastic, epiphany, fisticuffs, heresy,\n"+
    			"tautology, alabaster, blitzkrieg, infernal]\n\n"+
    			"MAKE SURE IT'S THE SAME AS THE FOLLOWING:");
    	
    	//Print out each element in the order that the iterator iterates.
    	Iterator it8 = s.iterator();
    	while(it8.hasNext()){
    		String string = (String) it8.next();
    		System.out.print(string + "\n ");
    	}
    	
    }
    public static void testIterator(){
    	System.out.println("\n\n------------TESTING ITERATOR--------------------\n");
    	
    	Set s = SetFactory.createSet();
    	
    	testIt1(s);
    	testIt2(s);
    	testIt3(s);
    	testIt4(s);
    	testIt5(s);
    	testIt6(s);
    	testIt7(s);
    	testIt8(s);
    	
    }
}


