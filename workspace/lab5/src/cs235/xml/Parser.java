package cs235.xml;

//package cs235.xml;


/**
 * The Parser interface represents an XML parser.
 */
public interface Parser {

    /**
     * Parses the XML document contained in the specified input stream
     * and returns a document tree that represents the document.
     * 
     * @param in an input stream containing an XML document
     * @return the root node of document tree
     * @throws IllegalArgumentException if in is null
     * @throws IOException if an input error occurs while parsing the XML document
     * @throws XMLException if the XML document being parsed is not in valid XML format
     */
    Document parse(java.io.InputStream in) throws java.io.IOException, XMLException;

}


