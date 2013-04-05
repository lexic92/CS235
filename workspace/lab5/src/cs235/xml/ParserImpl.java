package cs235.xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;



public class ParserImpl implements Parser {
	private TokenizerImpl t;
	private Document doc;
	private Node current;
	private Stack<String> stack = new Stack<String>();
	/**
	 * CONSTRUCTOR
	 */
	public ParserImpl(){
		doc = new DocumentImpl();
	}
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
	@Override
	public Document parse(InputStream in) throws IOException, XMLException {
		if(in == null){
			throw new IllegalArgumentException();
		}
		//Initialize stuff
		t = new TokenizerImpl(in);
		doc = new DocumentImpl(); //Clear it for a new parsing.
		current = doc;
		
	
		//PROCESS NEXT TOKEN
		
		t.nextToken();
		TokenType currentToken = t.getTokenType();	
		
		while(currentToken != TokenType.EOF){
		
			//This means it is an element, not text.
			if(currentToken == TokenType.START_TAG){
				element();
			}
			else if(currentToken == TokenType.TEXT){
				text();
			}
			else if(currentToken == TokenType.END_TAG){
				endTag();
			}
			t.nextToken();
			currentToken = t.getTokenType();
			
		}
		
		//Check for too many start tags.
		if(stack.size() != 0){
			throw new XMLException();
		}
		
			//If it reaches this point, assume that in processNextToken(),
			//currentToken == TokenType.EOF
			return doc;
	}
	
	/**
	 * INCOMPLETE
	 * @throws IOException 
	 * @throws XMLException 
	 */
	public void element() throws XMLException, IOException{
		//When a 'START_TAG' is read, create a new 'Element' node,
		//[Make an element impl with the tag name.]
		String startTag = t.getTagName();
		Element e = new ElementImpl(startTag);
		
		//Add the attributes to e.
		int numAttributes = t.getAttributeCount();
		for(int i = 0; i < numAttributes; i++){
			e.setAttribute(t.getAttributeName(i), t.getAttributeValue(i));
		}
		//append it as a child of the current node,
		//[Works if current is "Document."]
		current.appendChild(e);
		
		//and change the current node to be the new 'Element' node. 
		current = e;
		
		//ALSO: Add it's start tag to the stack.
		stack.add(startTag);
		
	}
	/**
	 * INCOMPLETE
	 * @throws IOException 
	 * @throws XMLException 
	 */
	public void text() throws XMLException, IOException{
		//When a 'TEXT' token is read, create a new 'Text' node,
		//]Make a text impl with the text.]
		Text textNode = new TextImpl(t.getText());
		
		//and append it as a child of the current node.
		current.appendChild(textNode);
		
	}
	/**
	 * INCOMPLETE
	 * @throws XMLException 
	 * @throws IOException 
	 */
	public void endTag() throws XMLException, IOException{
		//When an 'END_TAG' is read, check for balanced tags,
		String endTag = t.getTagName();
		
		//too many end tags would try to pop off something that isn't there.
		if(stack.size() == 0){
			throw new XMLException();
		}
		
		//The most recently added start tag should be the same as the end tag.
		if(!stack.pop().equals(endTag)){
			throw new XMLException();
		}
		
		//and change the current node to be the parent of the current node. 
		current = current.getParent();
		
	}

}
