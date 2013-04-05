package cs235.avl;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class SetImpl implements java.util.Set, Tree{
	private int size;
	private TreeNodeImpl root;
	/**
	 * This method is complete! (I think. Unless there's something wrong w/ it.
	 * 
	 * Constructs a new AVL Tree with a size of 0 and no root,
	 * ready to be added to.
	 */
	public SetImpl(){
		size = 0;
		root = null;
	}
	

	//Any specific class cast exceptions?
	@Override
	/**  
	 * This method is complete! (I think. Unless there's something wrong w/ it.
	 * 
	 * Insert e.
	 *
	 * @return true if this set did not already contain the specified element.
	 */
	
	public boolean add(Object e){
		//If the object is null (and this set doesn't take nulls), throw exception.
		if(e == null){
			throw new NullPointerException();
		}
		//If the class of e prevents it from being added to this set, throw exception.
		if(!(e instanceof Object)){  //Change to whatever class you want later on
			throw new ClassCastException();
		}
		//If this element is already present, return false.
		if(this.contains(e)){
			return false;
		}
		//----------------------------------------------------
		
		root = (TreeNodeImpl) add(e, root);
		
		//If the size has reached the maximum, then leave it alone (don't want it to accidentally
		//go to Zero or something!
		if(!(size == Integer.MAX_VALUE)){
			size++;
		}
		
		
		return true;
		
		
		
	}
	
	/**
	 * This method is complete! (I think. Unless there's something wrong w/ it.
	 * 
	 * Internal method to add to a subtree.
	 * @param e the item to insert.
	 * @param node the node that roots the tree.
	 * @return the new root.
	 * @throws IllegalArgumentException if e is already present.
	 */
	
	private TreeNode add(Object e, TreeNode node) {
		Comparable castedElement = (Comparable) e; //Change comparable!!!!!!!!!!!!!!!!!!!!!!
		
		//If the tree is empty, create a one-node tree.
		//Or: //If this is an empty leaf, then no comparisons needed.
		if(node == null){
			node = new TreeNodeImpl(e);
			return node; //Don't want to update this one's height because it 
			//automatically is given a height of 0.
		}
		
		//If e is "smaller" than the item in "node", call "add" recursively on the left subtree.
		else if(castedElement.compareTo( node.getData() ) < 0){ 
			((TreeNodeImpl) node).setLeftChild((TreeNodeImpl) add(e, node.getLeftChild()));
		}
		
		//If e is "larger" than the item in "node", call "add" recursively on the right subtree.
		else if(castedElement.compareTo( node.getData()) > 0){
			((TreeNodeImpl) node).setRightChild((TreeNodeImpl) add(e, node.getRightChild()));
		}
		
		//If e matches the item in "node", ... This should never happen anyway.
		else{
			throw new IllegalArgumentException("Duplicate Item: " + e.toString()); //Duplicate
		}
		//Each recursive call should only reach this point once the node has 
		//finally been added. Then each node
		//going up to the root on the path will reach this. So, their heights should be updated here.
		node = Balance(node);
		
		((TreeNodeImpl)node).setHeight(updateHeight((TreeNodeImpl)node)); 
		//Set the added-node's height (and the parents' heights as the recursive call comes out)
		//with the NEW and ACCURATE height.
		
		return node;
	}
	private static int updateHeight(TreeNodeImpl node){
		//return 1 plus Math.max(n.left.height, n.right.height)
		return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}
	
	private boolean test1(TreeNode node){
		return ( 	node.getLeftChild() == null && node.getRightChild() 
				!= null && node.getRightChild().getHeight() > 0		) ||
				(	node.getLeftChild() != null && node.getRightChild() != null &&
					(node.getRightChild().getHeight() - node.getLeftChild().getHeight() > 1	));
	}
	private boolean test2(TreeNode node){
		return (node.getRightChild() == null && node.getLeftChild() != null 
				&& node.getLeftChild().getHeight() > 0) ||
				(	node.getLeftChild() != null && node.getRightChild() != null 
				&& (node.getLeftChild().getHeight() - node.getRightChild().getHeight() > 1	));
	}
	
	private TreeNode Balance(TreeNode node){
		//Neither child is null, or only one child is null
		//Right subtree is 2 more than left (it is at least 1, and left is -1.)
		if(test1(node)){
				
				return balancePartOne(node);
		}
		//Left subtree is 2 more than right (it is at least 1, and right is -1.)
		else if(test2(node)){
			
				return balancePartTwo(node);
		}
		//They are balanced just fine: both children are null (and therefore equal)
		else{// This can be assumed: if(node.getLeftChild() 
			 //== null && node.getRightChild() == null)
			return node;
		}
	}
	private TreeNode balancePartOne(TreeNode node){
		//Entering the check for double-rotate
		TreeNode subtreeNode = node.getRightChild();
		
		//RIGHT-LEFT COMPARE
		//If subtree node has 2 children, and left is higher than right.
		//*This mean it went right-left!*
		if(subtreeNode.getLeftChild() != null && subtreeNode.getRightChild() 
				!= null && subtreeNode.getLeftChild().getHeight() > 
				subtreeNode.getRightChild().getHeight()){
			return doubleRotateLeft(node);
		}
		
		//RIGHT-LEFT NOT COMPARE
		//If subtree node has 1 child: the left: which means it's higher than 
		//the right by default. *right-left!*
		else if(subtreeNode.getLeftChild() != null && subtreeNode.getRightChild() == null){
			return doubleRotateLeft(node);
		}
		
		//RIGHT-RIGHT
		else {
			return singleLeftRotation(node);
		}
	}
		
		
	private TreeNode balancePartTwo(TreeNode node){	
			//Entering the check for double-rotate
			TreeNode subtreeNode = node.getLeftChild();
			
			
			//LEFT-RIGHT COMPARE
			//If subtree node has 2 children, and right is higher than left.  
			//*This mean it went left-right!*
			if(subtreeNode.getRightChild() != null && subtreeNode.getLeftChild() 
					!= null && subtreeNode.getRightChild().getHeight() > 
					subtreeNode.getLeftChild().getHeight()){
				return doubleRotateRight(node);
			}
			
			//LEFT-RIGHT NOT COMPARE
			//If subtree node has 1 child: the right: which means it's higher 
			//than the left by default. *left-right!*
			else if(subtreeNode.getRightChild() != null && subtreeNode.getLeftChild() == null){
				return doubleRotateRight(node);
			}
			
			//LEFT-LEFT
			else{
				return singleRightRotation(node);
			}
	}
	
	 //Is this tree allowed to have null elements??? This is vital information!!!
	/**
	 * This method is complete! (I think. Unless there's something wrong w/ it.)
	 * 
	 * Returns true if this set contains the object. 
	 * More formally, returns true if and only if this set
	 * contains an element e such that (o == null ? e==null : o.equals(e)).
	 * 
	 * @param o the tested object (to see if it's contained)
	 * @return true if this set contains "o"
	 */
	@Override
	public boolean contains(Object o) {
		//If the find method returns null, then it is not contained.
		//If the find method returns a node, then it is contained (true).
		return find(o, root) == null ? false : true;
	}
	/**
	 * This method is complete! (I think. Unless there's something wrong w/ it.)
	 * 
	 * Internal method to find an item in a subtree. (If it's there, then it is contained!)
	 * 
	 * @param e the item to search for.
	 * @param node the node that roots the tree
	 * @return the node that contains the matched item.
	 */
	private TreeNode find(Object e, TreeNode node){
		
		Comparable castedElement = (Comparable) e; //Change comparable!!!!!!!!!!!!!!!!!!!!!!
		
		//As long as a null link has not been reached...
		while(node != null)
		{	
			//We either need to branch left...
			if(castedElement.compareTo(node.getData()) < 0){
				node = node.getLeftChild();
			}
			//or right...
			else if(castedElement.compareTo(node.getData()) > 0){
				node = node.getRightChild();
			}
			//or we have a match.
			else{
				return node; //Match
			}
		}
		return null; //Not found.
	}
	
	/**
	 * This method is complete!
	 * 
	 * Returns the number of elementsif(size > Integer.MAX_VALUE){
	 in this set.
	 * If this set contains more than Integer.MAX_VALUE elements,
	 * returns Integer.MAX_VALUE.
	 */
	@Override
	public int size() {
		//Integer.MAX_VALUE thing is taken care of in "add" method.
		return size;
	}
	/**
	 * This method is complete!
	 * 
	 * Removes all of the elements from this set.
	 */
	@Override
	public void clear() {
		size = 0;
		root = null; //This is how the "set" becomes empty, by not being able
		//to find anything or reference anything.
		
	}
	
	
	
	/**
	 * Method complete!
	 * 
	 * Remove an element from the tree.
	 * @param o the element to remove.
	 * @return true if this set contained the element 
	 * (and the set is now different).
	 */
	@Override
	public boolean remove(Object o) {
		try{
			//Update the tree by assigning the new tree to the root.
			root = (TreeNodeImpl) remove(o, root);
			size--; //Can't forget this.
			return true;
		}
		//If the remove was unsuccessful, return false.
		catch(NullPointerException e){
			return false;
		}
		
		
	}

	/**
	 * Internal method to remove the minimum item from a subree.
	 * @param nodethe ndoe that roots the tree.
	 * @return the new root.
	 * @throws NullPointerException if "node" is empty.
	 */
	
	
	/*private TreeNode removeMin(TreeNode node){
		//If the tree (of root "node") is empty, then removeMin fails.
		if(node == null){
			throw new NullPointerException();
		}
		//Otherwise, if "node" has a left child, then recursively remove the
		//minimum item in the left subtree.
		else if(node.getLeftChild() != null){
			((TreeNodeImpl) node).setLeftChild((TreeNodeImpl) removeMin(node.getLeftChild()));
			if(node.getLeftChild()!=null)
				((TreeNodeImpl)node).setHeight(updateHeight((TreeNodeImpl)node));
			return node;
		}
		//Reaching this point means that this is the minimum node, and "node"
		//is the root of a subtree that has no left child.
		//If we set "node" to "node.right", then it is basically removed, and it's
		//right child takes the parents' place (and the left is forgotten, which
		//is okay because it doesn't exist).
		else{
			return node.getRightChild();
		}
	
	
	}*/
	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param node the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	
	private TreeNode findMin(TreeNode node){
		//If this node is null, then return it (which is null).
		if(node != null){
			//if this node has a left child, then keep replacing it with its left child,
			//in this loop, until it has no left child.  If it has no left child, then
			//that is the minimum node, so return it.
			while(node.getLeftChild() != null){
				node = node.getLeftChild();
			}
		}
		return node;  //This is the minimum node in this subtree.
	}
	
	/**
	 * Complete, I think, but not certain.
	 * 
	 * Internal method to remove from a subtree.
	 * @param o the item to remove
	 * @param node the node that roots the tree.
	 * @return the new root.
	 * @throws NullPoitnerException if the item "o" is not found.
	 */
	
	private TreeNode remove(Object o, TreeNode node){
		//If the tree is empty, remove is unsuccessful.
		if(node == null){
			throw new NullPointerException();
		}
		//If we do not have a match, then recursively call remove for either the left
		//or right subtree. (depending on where the object is.)
		if(((Comparable)o).compareTo(node.getData()) < 0){
			((TreeNodeImpl) node).setLeftChild((TreeNodeImpl) remove(o, node.getLeftChild()));
		}
		else if(((Comparable)o).compareTo(node.getData()) > 0){
			((TreeNodeImpl) node).setRightChild((TreeNodeImpl) remove(o, node.getRightChild()));
		}
		
		//Reaching this point means we found the node that needs to be removed.
		
		//If it has two children...
		else if(node.getLeftChild() != null && node.getRightChild() != null){ //Two children
			//Replace the data with the right subtree's minimum node's data.
			((TreeNodeImpl)node).setData(findMin(node.getRightChild()).getData()); 
			
			//Remove the right subtree's minimum.
			((TreeNodeImpl) node).setRightChild((TreeNodeImpl)remove(node.getData(),node.getRightChild()));
			//(TreeNodeImpl) removeMin(node.getRightChild()));
			
			
		}
		//If it has one child...  (This also covers the leaf case, 
		//because it will point to null afterwards.)
		else{
			//If the child is a left child, then make the pointer to THIS node ACTUALLY point to its
			//left child (pointing over it, basically "removing it" that way).
			//If only a right child, then same thing, but point over THIS node to the right child.
			node = node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild();
		}
		
		//WHEN LEAVING THIS METHOD (THE OBJECT HAS BEEN REMOVED) THIS WILL RECURSE OUT OF EVERYTHING
		//FROM THE REMOVED ITEM TO THE PARENT. 
		//SO, REBALANCE AND UPDATE HEIGHTS.
		if(node != null){
			((TreeNodeImpl)node).setHeight(updateHeight((TreeNodeImpl)node));
			node = Balance(node);
			((TreeNodeImpl)node).setHeight(updateHeight((TreeNodeImpl)node)); 
		}
		//Set the added-node's height (and the parents' heights as the recursive call comes out)
		//with the NEW and ACCURATE height.
		
		
		return node;
	
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		 return new LevelOrder(root);

	}
	
	
	
	
	
	
	@Override
	public boolean removeAll(Collection c) {
		 throw new UnsupportedOperationException();
	}
	@Override
	public boolean retainAll(Collection c) {
		 throw new UnsupportedOperationException();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException();
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException();
	}
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException();
	}
	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException();
	}
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
    /**
     * This method is complete! (I think)
     * 
     * Gets the height of "this" node.
     * @param node the node you want the height of.
     * @return the height (-1 if null, or else the height.)
     */
    public static int getHeight(TreeNode node){
		if(node == null){
			return -1;
		}
		else{
			return ((TreeNodeImpl)node).getHeight();
		}
	}
    
    
    
    
    
    
	/**
	 * Method complete
	 * @param node the subtree to single-rotate-right
	 * @return the root of the newly rotated subtree
	 */
	private static TreeNode singleRightRotation(TreeNode node){ //(k2) //"rotate with left child"
		TreeNode temp = node.getLeftChild();//temp = node.left; //k1 = k2.left;
		((TreeNodeImpl)node).setLeftChild((TreeNodeImpl) temp.getRightChild());
		//node.left = temp.right; //k2.left = k1.right;
		((TreeNodeImpl)temp).setRightChild((TreeNodeImpl)node); //temp.right = node; //k1.right = k2;
		
		//Update these heights because they are changed.
		((TreeNodeImpl)node).setHeight(updateHeight((TreeNodeImpl)node));
		((TreeNodeImpl)temp).setHeight(updateHeight((TreeNodeImpl)temp)); 
	
		
		//Set the added-node's height (and the parents' heights as the recursive call comes out)
		//with the NEW and ACCURATE height.
		
		return temp; //return temp; //return k1
	}
	/**
	 * Method complete
	 * @param node the subtree to single-rotate-left
	 * @return the root of the newly rotated subtree
	 */
	private static TreeNode singleLeftRotation(TreeNode node){ //(k1) //"rotate with right child"
		TreeNode temp = node.getRightChild();//temp = node.right; //k2 = k1.right;
		((TreeNodeImpl)node).setRightChild((TreeNodeImpl) temp.getLeftChild()); 
		//node.right = temp.left; //k1.right = k2.left;
		((TreeNodeImpl)temp).setLeftChild((TreeNodeImpl)node); //temp.left = node; //k2.left = k1;
		
		//Update these heights because they are changed.
		((TreeNodeImpl)node).setHeight(updateHeight((TreeNodeImpl)node));
		((TreeNodeImpl)temp).setHeight(updateHeight((TreeNodeImpl)temp)); 
		
		//Set the added-node's height (and the parents' heights as the recursive call comes out)
		//with the NEW and ACCURATE height.
		
		return temp; //return temp; //return k2
	}
	/**
	 * Method complete
	 * @param node the subtree to double-rotate-right
	 * @return the root of the newly rotated subtree
	 */
	private static TreeNode doubleRotateRight(TreeNode node){ //(k3)  double rotate "with left child"
		((TreeNodeImpl)node).setLeftChild((TreeNodeImpl) singleLeftRotation(node.getLeftChild()));
		return singleRightRotation(node);
	}
	/**
	 * Method complete
	 * @param node the subtree to double-rotate-left
	 * @return the root of the newly rotated subtree
	 */
	private static TreeNode doubleRotateLeft(TreeNode node){ //(k1) double rotate "with right child"
		((TreeNodeImpl)node).setRightChild((TreeNodeImpl) singleRightRotation(node.getRightChild()));
		return singleLeftRotation(node);
	}
	
	
	
	
	
	
    /**
     * This inner class iterates over the tree that was
     * used to get a pointer to this iterator.
     * @author lexic92
     *
     */
    //Inner class
	private class LevelOrder implements java.util.Iterator{
		private Queue<TreeNodeImpl> q;
		private TreeNodeImpl currentNode;
		
		/**
		 * Constructs a level-order iterator starting at the
		 * root of the tree (which is the parameter node).
		 * @param node the root of the tree to iterate over.
		 */
		LevelOrder(TreeNode node){
			q = new LinkedList<TreeNodeImpl>();
			currentNode = (TreeNodeImpl) node;
			
			//If the current node isn't null, then add its children
			//if applicable (just as if it was being dequeued in the
			//"next" method.
			if(currentNode != null){
				//As this node is removed, add its children to the queue if applicable.
				if(currentNode.getLeftChild() != null){
					q.add((TreeNodeImpl) currentNode.getLeftChild());
				}
				if(currentNode.getRightChild() != null){
					q.add((TreeNodeImpl) currentNode.getRightChild());
				}
			}
		}
		
		
		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return the next element in the iteration.
		 * @throws NoSuchElementException Iteration has no more elements.
		 */
		public Object next(){
			//If the queue has no elements
			if(q.isEmpty())
			{
				//And the current node is null
				if(currentNode == null){
					//Then there is no "next."
					throw new NoSuchElementException();
				}
				//If current node was NOT null, then make it null
				//because the queue is empty and so currentNode can't
				//be replaced with something from the queue.
				TreeNodeImpl nodeToReturn = currentNode;
				currentNode = null;
				return nodeToReturn.getData();
			}
			//Make temporary node variable using the currentNode.
			TreeNodeImpl nodeToReturn2 = currentNode;
			
			//Advance the iterator to prepare for next time.
			currentNode = q.remove();
			
			//As this node is removed, add its children to the queue if applicable.
			if(currentNode.getLeftChild() != null){
				q.add((TreeNodeImpl) currentNode.getLeftChild());
			}
			if(currentNode.getRightChild() != null){
				q.add((TreeNodeImpl) currentNode.getRightChild());
			}
			
			//return the temporary node variable.
			return nodeToReturn2.getData();
		}
		/**
		 * Returns true if the iteration has more elements.
		 *  (In other words, returns true if next would 
		 *  return an element rather than throwing an exception.) 
		 *  
		 * @return true if the iterator has more elements.
		 */
		public boolean hasNext(){
			if(currentNode == null){
				return false;
			}
			return true;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			 throw new UnsupportedOperationException();
			
		}
	
	}






	@Override
	public TreeNode getRoot() {
		// TODO Auto-generated method stub
		return root;
	}
}
