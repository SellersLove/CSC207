package phaseii;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientManager {
	
	   /** A mapping of student ids to Students. */
    private Map<String, Client> Clients;
    
    private static final Logger logger = 
            Logger.getLogger(FlightManager.class.getPackage().getName());
    
    private static final Handler consoleHandler = new ConsoleHandler();
   
    public ClientManager(){
    	this.Clients = new HashMap<>();
    }
	
    /**
     * Creates a new empty FlightManager.
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public ClientManager(String filePath) throws ClassNotFoundException, IOException {
    	
        this.Clients = new HashMap<>();
        
        // Associate the handler with the logger.
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        
        // Reads serializable objects from file.
        // Populates the record list using stored data, if it exists.
        File file = new File(filePath);
        if (file.exists()) {
            readFromFile(filePath);
        } else {
            file.createNewFile();
        }
    }
    
    /**
     * Populates the records map from the file at path filePath.
     * @param filePath the path of the data file  
     * @throws FileNotFoundException if filePath is not a valid path
     */
    public void readFromCSVFile(String filePath) 
            throws FileNotFoundException {
        
        // FileInputStream can be used for reading raw bytes, like an image. 
        Scanner scanner = new Scanner(new FileInputStream(filePath));
        String[] record;
        Client client;

        while(scanner.hasNextLine()) {
            record = scanner.nextLine().split(",");
            
            client = new Client(record[0], record[1], record[2], record[3], record[4],
            		record[5]);
            
            Clients.put(client.email, client); //No getter and can access
        }
        scanner.close();
    }
    
    /**
     * Adds record to this StudentManager.
     * @param record a record to be added.
     */
    public void add(Client record) {
        Clients.put(record.email, record); //No getter and can access.
        
        // Log the addition of a student.
        logger.log(Level.FINE, "Added a new student " + record.toString());
    }
    
    /**
     * Writes the students to file at filePath.
     * @param filePath the file to write the records to
     * @throws IOException 
     */
    public void saveToFile(String filePath) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(Clients);
        output.close();
    }

    @SuppressWarnings("unchecked")
	private void readFromFile(String path) throws ClassNotFoundException {

        try {
            InputStream file = new FileInputStream(path);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            //deserialize the Map
            this.Clients = (Map<String, Client>) input.readObject();
            input.close();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Cannot read from input.", ex);
        }    	
    }
    public Client getClient(String email){
    	
    	return Clients.get(email);
    }
    
    @Override
    public String toString() {
        String result = "";
        for (Client r : Clients.values()) {
            result += r.toString() + "\n";
        }
        return result;
    }
}
