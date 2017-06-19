package week3lab;

public class Author {

	private String FirstName;

	private String LastName;

	public Author(String FirstName, String LastName) {
	    
	    this.FirstName = FirstName;  
	    this.LastName = LastName;
	  
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String toString() {
		return LastName + ", " + FirstName;
	}
	
	
}
