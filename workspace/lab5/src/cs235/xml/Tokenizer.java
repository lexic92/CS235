package cs235.xml;
//package cs235.xml;


public interface Tokenizer {

     /**
     * Constructs a Tokenizer object
     * 
     * The constructor is listed here so you will know how to call it.
     * Note: it's commented out because interfaces don't have constructors.
     */
     //TokenizerImpl(InputStream in);
       
    /**
     * Reads the next token from the XML file
     * 
     * @return The type of the token that was read from the file.
     *         If there are no more tokens in the file, EOF is returned.
     * @throws IOException if an I/O error occurs
     * @throws XMLException if the file contains invalid XML
     */
    TokenType nextToken() throws java.io.IOException, XMLException;

    /**
     * Returns the type of the current token (the one last read by nextToken)
     * 
     * @return The type of the current token.
     *          If nextToken has never been called, BOF is returned.
     */
    TokenType getTokenType();

    /**
     * Returns the element name associated with the current tag token
     * 
     * @return the element name associated with the current tag token
     * @throws IllegalStateException if the current token type is not
     *          START_TAG or END_TAG  
     */  
    String getTagName();

    /**
     * Returns the value of the named attribute.
     * 
     * @return the value of the named attribute.
     *          If the tag doesn't have an attribute with the specified
     *          name, null is returned.
     * @throws IllegalStateException if the current token type is not
     *          START_TAG
     */  
    String getAttributeValue(String name);

    /**
     * Returns the number of attributes
     * 
     * @return the number of attributes
     * @throws IllegalStateException if the current token type is not
     *          START_TAG
     */  
    int getAttributeCount();

    /**
     * Returns the name of the attribute at the specified index
     * 
     * @return the name of the attribute at the specified index
     * @throws IllegalStateException if the current token type is not
     *          START_TAG
     * @throws IllegalArgumentException if there is no attribute at
     *          the specified index
     */
    String getAttributeName(int i);

    /**
     * Returns the value of the attribute at the specified index
     * 
     * @return the value of the attribute at the specified index
     * @throws IllegalStateException if the current token type is not
     *          START_TAG
     * @throws IllegalArgumentException if there is no attribute at
     *          the specified index
     */
    String getAttributeValue(int i);
    
    /**
     * Returns the string associated with the current text token
     * 
     * @return the string associated with the current text token
     * @throws IllegalStateException if the current token type is not TEXT
     */
    String getText();

}


