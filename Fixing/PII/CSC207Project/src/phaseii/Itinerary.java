package phaseii;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Itinerary{
	
	public List<Flight> itinerary;
	
	public Itinerary(){
		
		this.itinerary = new ArrayList<Flight>();
	}
	
	@Override
	/**
	 * Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,Destination
	 * followed by total price (on its own line, exactly two decimal places),
	 * followed by total duration (on its own line, in format HH:MM).
	 */
	public String toString() {
		String result = "";
		for(int i = 0; i < itinerary.size(); i++){
			result = result + itinerary.get(i).flightNum +"," + 
					itinerary.get(i).arriveDate + " " + itinerary.get(i).arriveTime+"," +
					itinerary.get(i).departDate + " " + itinerary.get(i).departTime + "," +
					itinerary.get(i).airline + "," + itinerary.get(i).origin + "," +
					itinerary.get(i).destination + "\n" ;
		}
		result = result + this.twoDecimal() + "\n" + this.duration() ;
		return result;
	}
	
	public Itinerary(List<Flight> itinerary){
		
		this.itinerary = itinerary;
	}
	
	/**
	 * add a new flight to this itinerary
	 * @param flight
	 */
	public void append(Flight flight){
		this.itinerary.add(flight);
	}
	
	/**
	 * computes the total time of this itinerary and convert to minute
	 * for sort itinerary by time 
	 * @return integer total minutes
	 */
	public int totaltime(){
		int totaltime = 0;
		for(Flight flight: itinerary){
			totaltime = totaltime + flight.convertMin();
		}
		return totaltime;
	}
	
	/**
	 * 
	 * @return duration of this itinerary and format HH:MM
	 */
	public String duration(){

		int duration = this.totaltime();
		return String.format("%d:%02d", duration/60, duration%60);
	}
	
	/**
	 * computes the total cost of this itinerary
	 * for sort itinerary by cost 
	 * @return double total cost
	 */
	public double totalcost(){
		double totalcost = 0;
		for(Flight flight: itinerary){
			totalcost = totalcost + flight.price;
		}
		return totalcost;
	}
	
	/**
	 * Exactly to decimal 
	 * @return total cost of this itinerary and convert to Exactly to decimal
	 */
	public String twoDecimal(){
		double twoDecimal = this.totalcost();
		return new DecimalFormat("#.##").format(twoDecimal);
	}
	
	/**
	 * 
	 * @return the number of flights in this itinerary
	 */
	public int size(){
		
		return this.itinerary.size();
		 
	 }
	
	/**
	 * 
	 * @return the last flight in the itinerary
	 */
	public Flight lastFlight(){
		
		return this.itinerary.get(this.itinerary.size()-1);
	}
	
	/**
	 * add to itinerary together to create a new itinerary
	 * @param itinerary new itinerary  
	 */
	public void addItinerary(Itinerary itinerary){
		
		for(Flight e : itinerary.itinerary){
			this.itinerary.add(e);
		}
	
	}
	

}
