

package cs235.hash;


public class Factory {

    /**
     * Creates and returns an object that implements the java.util.Set interface
     *
     * @return A new object that implements the java.util.Set interface
     */
    public static java.util.Set createSet() {

	return new SetImpl();

    }

    /**
     * Creates and returns an object that implements the java.util.Map interface
     *
     * @return A new object that implements the java.util.Map interface
     */
    public static java.util.Map createMap() {

	return new MapImpl();

    }

}


