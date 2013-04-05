

package cs235.rsg;


public class Test2 {

    /**
     * Creates and returns an object that implements the RSG interface
     *
     * @return A new object that implements the RSG interface
     */
    public static void main(String[] args) {
	RSG r = new RSGImpl();
	r.loadGrammar("CS-assignment-handout.g");
	for(int i = 0; i < 5; i++){
		System.out.println(r.generateSentence()+"\n\n\n");
	}
    }

}

