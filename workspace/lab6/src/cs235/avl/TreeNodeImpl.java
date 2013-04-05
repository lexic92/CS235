package cs235.avl;

/**
 *  NOTE: This is an optional interface.
 *
 *  If you want to use the AVL GUI,
 *  you need to implement this interface.
 *  The GUI allows you to see what your AVL
 *  tree looks like as you add and remove nodes.
 */


//package cs235.avl;


public class TreeNodeImpl implements TreeNode {
	private Object element;
	private TreeNodeImpl left;
	private TreeNodeImpl right;
	private int height;
	
	public TreeNodeImpl(Object e){
		element = e;
		left = null;
		right = null;
		height = 0;
	}
    /**
     * Returns the data stored in the node
     * 
     * @return the data stored in the node.
     */
    public Object getData(){
    	return element;
    }

    /**
     * Returns the left child of the node or null if there is no left child
     * 
     * @return the left child of the node or null if there is no left child.
     */
    public TreeNode getLeftChild(){
    	return left;
    }

    /**
     * Returns the right child of the node or null if there is no right child
     * 
     * @return the right child of the node or null if there is no right child.
     */
    public TreeNode getRightChild(){
    	return right;
    }

    /**
     * Method complete!
     * 
     * Returns the height of the node.
     * 
     * @return the height of the node.
     */
    public int getHeight(){
    	return height;
    }
    
    /**
     * Method is complete: but I wonder if it should require
     *  TreeNodeImpl or TreeNode as a parameter.
     * 
     * Sets right child.
     * @param n the node to set it with.
     */
    public void setRightChild(TreeNodeImpl n){
    	right = n;
    }
    
    /**
     * Method is complete: but I wonder if it should require 
     * TreeNodeImpl or TreeNode as a parameter.
     * 
     * Sets left child.
     * @param n the node to set it with.
     */
    public void setLeftChild(TreeNodeImpl n){
    	left = n;

    
    }
    /**
     * Method complete!
     * 
     * Sets height
     */
    public void setHeight(int height){
    	this.height = height;
    }
    
    /**
     * Method complete!
     * 
     * Sets data.
     */
    public void setData(Object o){
    	element = o;
    }


}
