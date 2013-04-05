

package cs235.java;

public class StudentImpl extends PersonImpl implements Student {

	private String major;
	private double gpa;

	/**
	 * Constructs a "Student" with an id, name, major, and gpa which must be in the range 0.0 
	 * to 4.0.  Uses the setID, setName, setMajor, and setGPA methods; so if id, name, or 
	 * major is null, or if the gpa is < 0.0 or gpa > 4.0, then the related method will throw
	 * an illegal argument exception. 
	 * 
	 * @param id The student's id.
	 * @param name The student's name.
	 * @param major The student's major.
	 * @param gpa The student's gpa, which must be within 0.0 and 4.0.
	 **/
	public StudentImpl(String id, String name, String major, double gpa){
		super(id, name);
		setMajor(major);
		setGPA(gpa);
	}
   	 /**
    	 * Returns the student's major
    	 * 
    	 * @return the student's major.
    	 */
	public String getMajor(){
		return major;
	}
	/**
   	  * Sets the student's major
   	  * 
    	 * @param major the new value for the student's major.
   	  *      This may be any non-null String
    	 * @throws IllegalArgumentException if major is null
    	 */
	public void setMajor(String major){
		if (major == null){
			throw new IllegalArgumentException("Illegal Argument.");
		}
		this.major = major;
	}
  	/**
    	 * Returns the student's GPA
    	 * 
    	 * @return the student's GPA.
     	*/
	public double getGPA(){
		return gpa;
	}
	/**
    	 * Sets the student's GPA
    	 * 
    	 * @param gpa the new value for the student's GPA.
    	 *       This may be any double in the range 0.0 to 4.0
    	 * @throws IllegalArgumentException if gpa is not in the range 0.0 to 4.0
    	 */
	public void setGPA(double gpa){
		final double MAX_GPA = 4.0;
		if (gpa < 0.0 || gpa > MAX_GPA){
			throw new IllegalArgumentException("Illegal Argument.");
		}
		this.gpa = gpa;
	}
	/**
	 * Returns the Student's ID, name, major, and GPA in a String.
	 * @return A string consisting of: "student
	 * 				    (their id)
	 *				    (their name)
	 *				    (their major)
	 * 				    (their gpa)
	 *				    "
	 */
	public String toString(){
		return "student\n" + getID() + "\n" + getName() + "\n" + major + "\n" + gpa +"\n";
	}
}

