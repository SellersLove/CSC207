package phaseii;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
	
	
	protected String firstName;
	
	protected String lastName;
	
	protected String email;
	
	protected String address;
	
	protected List<Itinerary> ItineraryList;
	
	protected String creditCard;
	
	protected String ccExpDate;
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String lastName, String firstName, String email, String address, String creditCard, String ccExpDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.creditCard = creditCard;
		this.ccExpDate = ccExpDate;
		this.ItineraryList = new ArrayList<Itinerary>();
		
	}
	
	public void editUserInfo(String option, String info ){

		if(option.equals("firstname")){
			this.setFirstName(info);
		}
		if(option.equals("lastname")){
			this.setLastName(info);
		}
		if(option.equals("email")){
			this.setEmail(info);
		}
		if(option.equals("address")){
			this.setAddress(info);
		}
	}
	

	
}