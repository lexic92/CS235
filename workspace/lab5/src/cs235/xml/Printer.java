package cs235.xml;

//package cs235.xml;


/**
 * The Printer interface represents an XML printer.
 */
public interface Printer {

     /**
     * Writes the document in XML format to the specified output stream.
     * 
     * @param doc the root of the document tree to be written
     * @param out the output stream to which the document should be written
     * @throws IllegalArgumentException if doc is null
     * @throws IllegalArgumentException if out is null
     */
    void print(Document doc, java.io.PrintStream out);

}


