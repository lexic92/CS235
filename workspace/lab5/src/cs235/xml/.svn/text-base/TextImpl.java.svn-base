package cs235.xml;

public class TextImpl extends NodeImpl implements Text {
	private String text;
	
	/**
	 * COMPLETED
	 * @param text
	 */
	public TextImpl(String text){
		this.text = text;
	}
	
	/**
	 * COMPLETED
	 */
	@Override
	public String getText() {
		return text;
	}

    /**
     * Sets the text string stored in this node.
     * 
     * @param text the text string to be stored in this node
     * @throws IllegalArgumentException if text is null
     */
	@Override
	public void setText(String text) {
		if(text == null){
			throw new IllegalArgumentException();
		}
		this.text = text;
	}
	
	
	@Override
	public NodeType getType() {
		// TODO Auto-generated method stub
		return NodeType.TEXT_NODE;
	}
	
	
	

}
