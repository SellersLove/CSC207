package phaseii;

import java.io.FileNotFoundException;
import java.io.IOException;

import driver.Driver;

public class test {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//demoClientManagerRead();
		//demoCreatClients();
		//demoCreatFlights();
		//demoFlightManger();
		//demoReadCSV();
		//demoSearchFlights();
		demoDriver();
    }
	
	public static void demoClientManagerRead() throws IOException, ClassNotFoundException {

        String csvPath ="/Users/Ray/Desktop/Bi-clients.csv";
        ClientManager cm = new ClientManager(csvPath);    
        System.out.println(cm);
        

        // loads data from CSV for first launch of the program
        
 
       
    }
	
	public static void demoReadCSV() throws IOException, ClassNotFoundException {

		String csvPath ="/Users/Ray/Desktop/sample.csv";
        ClientManager cm = new ClientManager();
        cm.readFromCSVFile(csvPath);
        System.out.println(cm);

    }
	

	
	public static void demoFlightManger() throws IOException, ClassNotFoundException {
		
		String csvPath ="/Users/Ray/Desktop/flights.csv";
        FlightManager fm = new FlightManager(csvPath);
        System.out.println(fm);

	}
	public static void demoCreatClients() throws IOException, ClassNotFoundException{
		
		String csvPath ="/Users/Ray/Desktop/Bi-client.csv";
		ClientManager cm = new ClientManager();
		Client a = new Client("lastname","firstname","a",
        		"address","crdit card","ccExpDate" );
        Client b = new Client("lastname","firstname","b",
        		"address","crdit card","ccExpDate" );
        Client c = new Client("lastname","firstname","c",
        		"address","crdit card","ccExpDate" );
        Client d = new Client("lastname","firstname","d",
        		"address","crdit card","ccExpDate" );
        Client e = new Client("lastname","firstname","e",
        		"address","crdit card","ccExpDate" );
        Client f = new Client("lastname","firstname","f",
        		"address","crdit card","ccExpDate" );
        Client g = new Client("lastname","firstname","g",
        		"address","crdit card","ccExpDate" );
        Client h = new Client("lastname","firstname","h",
        		"address","crdit card","ccExpDate" );
        Client i = new Client("lastname","firstname","i",
        		"address","crdit card","ccExpDate" );
        Client j = new Client("lastname","firstname","j",
        		"address","crdit card","ccExpDate" );
        cm.add(a);
        cm.add(b);
        cm.add(c);
        cm.add(d);
        cm.add(e);
        cm.add(f);
        cm.add(g);
        cm.add(h);
        cm.add(i);
        cm.add(j);
        System.out.println(cm);
        cm.saveToFile(csvPath);
		
	}
	public static void demoCreatFlights() throws FileNotFoundException{
		String csvPath ="/Users/Ray/Desktop/Flight.csv";
        FlightManager fm = new FlightManager();
        fm.readFromCSVFile(csvPath);
        System.out.println(fm);
		
	}
	public static void demoSearchFlights() throws FileNotFoundException{
		String csvPath ="/Users/Ray/Desktop/Flight.csv";
        FlightManager fm = new FlightManager();
        fm.readFromCSVFile(csvPath);        
        
        String result0 = fm.getItinerariesHelper1("2012-12-30", "A").toString();
        String result1 = fm.getItineraries("2012-12-30", "A", "H").toString();
        System.out.println(result0);
        System.out.println(result1);

        System.out.println(fm.getItineraries("2012-12-30", "A", "H").size());
	}
	public static void demoDriver() throws FileNotFoundException{
		String csvflights ="/Users/Ray/Desktop/Flight.csv";
		String csvClients ="/Users/Ray/Desktop/sample.csv";
		Driver.uploadClientInfo(csvClients);
		Driver.uploadFlightInfo(csvflights);
		String a = Driver.getClient("JessicaRDowning@armyspy.com");
		String b = Driver.getFlights("2012-12-30", "A", "B");
		String c = Driver.getItineraries("2012-12-30", "A", "H");
		String d = Driver.getItinerariesSortedByCost("2012-12-30", "A", "H");
		String e = Driver.getItinerariesSortedByTime("2012-12-30", "A", "H");
		//System.out.println(a);
		//System.out.println(b);
		//System.out.println(c);
		System.out.println(d);
		//System.out.println(e);
	}
}
