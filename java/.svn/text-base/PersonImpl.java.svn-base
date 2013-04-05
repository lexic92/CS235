

package cs235.java;

public class PersonImpl implements Person, Comparable<Person>{

	private String id;
	private String name;
	/**
	 * Constructs a "Person" who is affiliated with a university with an id and a name. 
	 * Uses the setID and setName methods, so if id or name is null, then the related 
	 * method will throw an illegal argument exception.
	 * @param id The person's id.
	 * @param name The person's name.
	 **/
	public PersonImpl(String id, String name){
		setID(id);
		setName(name);
	}
   	 /**
   	  * Returns the person's ID
   	  * 
    	 * @return the person's ID.
    	 */
	public String getID(){
		return id;
	}
    	/**
    	 * Sets the person's ID
     	* 
     	* @param id the new value for the person's ID.
     	*      This may be any non-null String
     	* @throws IllegalArgumentException if id is null
    	 */
	public void setID(String id){
		if (id == null){
			throw new IllegalArgumentException("Illegal Argument.");
		}
		this.id = id;
	}
	/**
    	 * Returns the person's name
    	 * 
    	 * @return the person's name.
    	 */
	public String getName(){
		return name;
	}
	/**
     	 * Sets the person's name
    	 * 
    	 * @param name the new value for the person's name.
    	 *      This may be any non-null String
    	 * @throws IllegalArgumentException if name is null
    	 */
	public void setName(String name){
		if (name == null){
			throw new IllegalArgumentException("Illegal Argument name is null.");
		}
		this.name = name;
	}
	/**
	 * Tests if two person objects have the same ID. If so, return true. Else return false. 
	 * @param p another person object.
	 */
	public boolean equals(Object p){
		return ((Person)p).getID().equals(this.getID());
	}
	/**
	 * Compares two people's IDs.
	 * @param p another person object.
	 * @return -1, 0, or 1 as this person's ID comes before, is equal to, or comes after 
	 * another person's ID (according to the order of Unicode characters).
	 */
	public int compareTo(Person p){
		if( this.getID().compareTo(p.getID()) < 0){
			return -1;
		}
		else if( this.getID().compareTo(p.getID()) == 0){
			return 0;
		}
		else{
			return 1; //Assume it's greater than.
		}
	}

}

