

package cs235.java;

public class EmployeeImpl extends PersonImpl implements Employee {

	private String office;

	/**
	 * Constructs an "Employee" with an id, name, and office. Uses the setID, setName, and 
	 * setOffice methods; so if id, name, or office is null, 
	 * then the related method will throw an illegal argument exception. 
	 * 
	 * @param id The employee's id.
	 * @param name The employee's name.
	 * @param office The employee's office.
	 * @param
	 **/
	public EmployeeImpl(String id, String name, String office){
		super(id, name);
		setOffice(office);
	}
   	/**
     	 * Returns the employee's office address
     	 * 
    	 * @return the employee's office address.
    	 */
   	public String getOffice(){
		return office;
	}
	/**
   	 * Sets the employee's office address
	 * 
	 * @param office the new value for the employee's office address.
     	 *      This may be any non-null String
     	 * @throws IllegalArgumentException if office is null
     	 */
    	public void setOffice(String office){
		if (office == null){
			throw new IllegalArgumentException("Illegal Argument.");
		}
		this.office = office;
	}
	/**
	 * Returns the Employee's ID, name, and office in a String.
	 * @return A string consisting of: "employee
	 * 				    (their id)
	 *				    (their name)
	 *				    (their office)
	 *				    "
	 */
	public String toString(){
		return "employee\n" + getID() + "\n" + getName() + "\n" + office + "\n";
	}
}

