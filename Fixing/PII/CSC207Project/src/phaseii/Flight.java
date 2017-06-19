package phaseii;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


public class Flight {
	
	protected String flightNum;
	
	protected String airline;
	
	protected String origin;
	
	protected String destination;
	
	protected double price;
	// HH/MM
	protected int[] duration;
	
	protected Calendar arrivalTimeAndDate;
	
	protected Calendar departTimeAndDate;
	
	protected String arriveDate;
	protected String departDate;
	protected String arriveTime;
	protected String departTime;
	
	public Flight(String flightNum, String departDateTime, String arrivalDateTime, String airline,
					String origin, String destination, double price) {
		
		this.flightNum = flightNum;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.arriveDate = arrivalDateTime.split(" ")[0];
		this.arriveTime = arrivalDateTime.split(" ")[1];
		this.departDate = departDateTime.split(" ")[0];
		this.departTime = departDateTime.split(" ")[1];
		this.departTimeAndDate = new GregorianCalendar(Integer.parseInt(departDateTime.split(" ")[0].split("-")[0]),
													   Integer.parseInt(departDateTime.split(" ")[0].split("-")[1]), 
													   Integer.parseInt(departDateTime.split(" ")[0].split("-")[2]),
													   Integer.parseInt(departDateTime.split(" ")[1].split(":")[0]),
													   Integer.parseInt(departDateTime.split(" ")[1].split(":")[1]),
														  00);
		
		this.arrivalTimeAndDate = new GregorianCalendar(Integer.parseInt(arrivalDateTime.split(" ")[0].split("-")[0]),
														Integer.parseInt(arrivalDateTime.split(" ")[0].split("-")[1]), 
														Integer.parseInt(arrivalDateTime.split(" ")[0].split("-")[2]),
														Integer.parseInt(arrivalDateTime.split(" ")[1].split(":")[0]),
														Integer.parseInt(arrivalDateTime.split(" ")[1].split(":")[1]),
														00);
		
		this.price = price;
		
	    this.duration = HoursBetween(departTimeAndDate, arrivalTimeAndDate);
	    		
	    
		
	}
	
	public int[] HoursBetween(Calendar startDate, Calendar endDate) {
		
	    long start = startDate.getTimeInMillis();
	    long end = endDate.getTimeInMillis();
	    long timeInHours = TimeUnit.MILLISECONDS.toHours(Math.abs(end - start));
	    
	    int [] duration = {(int) timeInHours, (int) ((timeInHours - (int) timeInHours) * 60)};
	    
	    return duration;
	}
	/**
	 * careful 360 minutes
	 * @param flight
	 * @return
	 */
	public boolean validWait(Flight flight){

		long start = this.arrivalTimeAndDate.getTimeInMillis();
		long end = flight.departTimeAndDate.getTimeInMillis();
		long timeInMinutes = TimeUnit.MILLISECONDS.toMinutes(Math.abs(end-start));
		return (timeInMinutes >= 0) && (timeInMinutes <= 360) ;
		
	}
	
	public int convertMin(){
		int totalMin = 0;
		totalMin = this.duration[1] + 60 * this.duration[0];
		return totalMin;
	}
	
	public String showDuration(){
		
		return "";
	}

	@Override
	/**
	 * Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,Destination,Price
	 * (the dates are in the format YYYY-MM-DD; the price has exactly two
	 * decimal places) 
	 * This is use for driver.getFlight
	 */
	public String toString() {
		
		return  flightNum + "," + departDate + " " + departTime + ","
				+ arriveDate + " " +arriveTime + "," + airline + "," + origin + ","
				+ destination + price;
		
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	
	
	/**
	 * 
	 * @param dateTime in given format(YYYY/MM/DD HH:MM) 
	 * @return convert String to calendar
	 */
	public Calendar convertTime(String dateTime){
		return new GregorianCalendar(Integer.parseInt(dateTime.split(" ")[0].split("-")[0]),
				   Integer.parseInt(dateTime.split(" ")[0].split("-")[1]), 
				   Integer.parseInt(dateTime.split(" ")[0].split("-")[2]),
				   Integer.parseInt(dateTime.split(" ")[1].split(":")[0]),
				   Integer.parseInt(dateTime.split(" ")[1].split(":")[1]),
					  00);
		
	}
	public void setArrivalTimeAndDate(Calendar arrivalTimeAndDate) {
		this.arrivalTimeAndDate = arrivalTimeAndDate;
	}

	public void setDepartTimeAndDate(Calendar departTimeAndDate) {
		this.departTimeAndDate = departTimeAndDate;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDuration(int[] duration) {
		this.duration = duration;
	}
	
}
