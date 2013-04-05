package cs235.xml;

//package cs235.xml;


/**
 * The Text interface represents a text node in an XML document tree.
 */
public interface Text extends Node {

    /**
     * @return the text string stored in this node
     */
    String getText();
    
    /**
     * Sets the text string stored in this node.
     * 
     * @param text the text string to be stored in this node
     * @throws IllegalArgumentException if text is null
     */
    void setText(String text);

}


