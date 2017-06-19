package phaseii;

import java.util.List;
import java.util.Map;

public class Client extends User {
	
	
	public Client(String lastname, String firstname, String email,  
			String address, String creditCard, String ccExpDate) {
		
		super(lastname, firstname, email, address, creditCard, ccExpDate);
		
	}
	
	public String viewPersonalInfo() {
		
		return
				"1. firstName:" + firstName +"\n"+
				"2. lastName:" + lastName +"\n"+
				"3. email:" + email +"\n"+
				"4. address:" + address +"\n"+
				"5. creditCard:" + creditCard +"\n"+
				"6. ccExpDate:" + ccExpDate;
					
	}
	
	public void setCreditCard(String creditCard) {
		
		this.creditCard = creditCard;
	}

	public void setCcExpDate(String ccExpDate) {
		
		this.ccExpDate = ccExpDate;
	}

	public void bookItinerary(Itinerary newitineray) {
		
		this.ItineraryList.add(newitineray);
	}
	
	public void cancelItinerary(Itinerary itineray) {
		
		this.ItineraryList.remove(itineray);
	}
	
	public String checkBookedItinerary() {
		String result = "";
		for(int i = 0; i< this.ItineraryList.size()-1; i++ ){
			result = result + i + this.ItineraryList.get(i).toString()+ "\n";
		}
		return result;
	}
	
	/**
	 * 
	 * @param option 
	 * @param info 
	 */
	public void editPersonalInfo(String option, String info){
		super.editUserInfo(option, info);
		if(option.equals("creditCard")){
			this.setCreditCard(info);
			
		}
		if(option.equals("ccExpDate")){
			this.setCcExpDate(info);
		}
	}
	
	public void sortByTime(List<Itinerary> TotalItinerary) {
		Itinerary temp; 
		for(int i = 0; i< TotalItinerary.size()-1; i++ ){
			for(int j = 1; j < TotalItinerary.size()-1;j++){
				if(TotalItinerary.get(j-1).totaltime() > TotalItinerary.get(j).totaltime()){
					temp = TotalItinerary.get(j-1);
					TotalItinerary.set(j-1, TotalItinerary.get(j));
					TotalItinerary.set(j, temp);
				}	
				
			}
			
		}
	}
	
	public void sortByCost(List<Itinerary> TotalItinerary) {
		
		Itinerary temp; 
		for(int i = 0; i< TotalItinerary.size()-1; i++ ){
			for(int j = 1; j <TotalItinerary.size()-1;j++){
				if(TotalItinerary.get(j-1).totalcost() > TotalItinerary.get(j).totalcost()){
					temp = TotalItinerary.get(j-1);
					TotalItinerary.set(j-1, TotalItinerary.get(j));
					TotalItinerary.set(j, temp);
				}	
			}
		}
	}
	

	public void searchFlight(Flight[] Totalflight, String origin, 
			String destination, Itinerary temp){
		
 		for(Flight flight: Totalflight){
			if(flight.origin.equals(origin)){
				
				if(flight.destination.equals(destination)){
					
					temp.append(flight);
					ItineraryList.add(temp);
				}
				else
				{	
					temp.append(flight);
					this.searchFlight(Totalflight, flight.destination, destination,temp);
				}
			}
		}
	}
	
	public void searchFlight(Map<String, Flight> FlightMap, String origin, 
			String destination, Itinerary temp){
		
 		for(Map.Entry<String, Flight> entry: FlightMap.entrySet()){
			if(entry.getValue().origin.equals(origin)){
				
				if(entry.getValue().destination.equals(destination)){
					if(temp.size() == 0){
						temp.append(entry.getValue());
						ItineraryList.add(temp);
					}
					else if(temp.size() > 0){
						if(temp.lastFlight().validWait(entry.getValue())){
							temp.append(entry.getValue());
							ItineraryList.add(temp);
						}
					}
				}
				else
				{	
					temp.append(entry.getValue());
					this.searchFlight(FlightMap, entry.getValue().destination, destination,temp);
				}
			}
		}
	}

	@Override
	public String toString() {
		
		return lastName + ","+ firstName + ","+ email
				+ "," + address + "," + creditCard + "," + ccExpDate;
	}
}
