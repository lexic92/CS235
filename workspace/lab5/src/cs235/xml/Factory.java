package cs235.xml;
//package cs235.xml;


public class Factory {

    /**
     * COMPLETED
     * 
     * Creates and returns an object that implements the Parser interface.
     * This is useful for parsing an existing XML document.
     * 
     * @return a new object that implements the Parser interface
     */
    public static Parser createParser() {
    	return new ParserImpl();
    }

    /**
     * COMPLETED
     * 
     * Creates and returns an object that implements the Printer interface.
     * This is useful for creating new XML documents.
     * 
     * @return a new object that implements the Printer interface
     */
    public static Printer createPrinter() {
    	return new PrinterImpl();
    }

    /**
     * Creates a new document node.
     *
     * @return a new object that implements the Document interface
     */
    public static Document createDocument() {
    	return new DocumentImpl();
    }
	
    /**
     * Creates a new element node.
     *
     * @param tagName the name of the element
     * @return the new element node
     * @throws IllegalArgumentException if tagName is null
     */
    public static Element createElement(String tagName) {
    	return new ElementImpl(tagName);
    }

    /**
     * Creates a new text node.
     *
     * @param text the text string to be stored in the new node
     * @return the new text node
     * @throws IllegalArgumentException if text is null
     */
    public static Text createText(String text) {
    	return new TextImpl(text);
    }
	
}


