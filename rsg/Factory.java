

package cs235.rsg;


public class Factory {

    /**
     * Creates and returns an object that implements the RSG interface
     *
     * @return A new object that implements the RSG interface
     */
    public static RSG createRSG() {
	RSG r = new RSGImpl();
	return r;
    }

}


