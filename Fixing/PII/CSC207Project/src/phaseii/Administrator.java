package phaseii;


import java.util.Map;
import java.lang.StringBuilder;

public class Administrator extends Client {
	
	public Administrator(String lastName,String firstName, String email, String address, String creditCard, String ccExpDate) {
		
		super(lastName, firstName, email, address, creditCard, ccExpDate);
		
	}

	//Add toString method to Client!
	public String viewClientList(Map<String, Client> ClientMap) {
		
		StringBuilder clientList = new StringBuilder();
		int clientCount = 0;
		
		for (Map.Entry<String, Client> entry : ClientMap.entrySet())
		{
			clientCount++;
		    clientList.append(clientCount + ". " + entry.getValue().toString());
		}
		return clientList.toString();
	}
	
	public void editClient(Client client, String option, String info) {
		
		client.editPersonalInfo(option, info);
	}
	
	//Add toString method to Flight!
	public String searchFlights(Map<String, Flight> flightMap) {
		

		StringBuilder flightList = new StringBuilder();
		
		int flightCount = 0;
		
		for (Map.Entry<String, Flight> entry : flightMap.entrySet())
		{
			flightCount++;
		    flightList.append(flightCount + ". " + entry.getValue().toString());
		}
		return flightList.toString();
		
	}
	
	//Maybe the Admin can read the file and upload it.
	
	public void uploadFlights(Map<String, Flight> flightMap, Flight flight) {
		flightMap.put(flight.flightNum, flight);
		
	}
	
	public void editFlight(Flight flight, String option, String info) {
		
		if (option == "flight number"){
			
			flight.setFlightNum(info);
				
		} else if (option == "airline") {
			
			flight.setAirline(info);
			
		} else if (option == "origin") {
			
			flight.setOrigin(info);
			
		} else if (option == "destination") {
			
			flight.setDestination(info);
			
		} else if (option == "price") {
			
			flight.setPrice(Double.parseDouble(info));
			
		
		} else if (option == "departDateTime") {
			flight.departTimeAndDate =flight.convertTime(info);
			flight.departDate = info.split(" ")[0];
			flight.departTime = info.split(" ")[1];
		}else if (option == "arrivalDateTime") {
			flight.arrivalTimeAndDate =flight.convertTime(info);
			flight.arriveDate = info.split(" ")[0];
			flight.arriveTime = info.split(" ")[1];
			
		}
	}
	
	
}
