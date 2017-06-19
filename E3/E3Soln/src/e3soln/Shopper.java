package e3soln;

import java.util.Observable;
import java.util.Observer;

public class Shopper implements Observer {
	
	private String name;

    /**
     * Creates a new {@link e3soln.Shopper} with the given name.
     * @param name name of the new {@link e3soln.Shopper}
     */
    // constructor
	public Shopper(String name){
		this.name = name;
	}
    /**
     * Returns the name of this {@link e3soln.Shopper}.
     * @return the name of this {@link e3soln.Shopper}
     */
    // getName
	public String getName(){
		return this.name;
	}

    /**
     * Prints a message about a price change.
     */
    // update
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		 String priceFormatted = String.format(" was notified about a "
	        		+ "price change of %s at %s to %.2f", 
		    		((PriceChange)arg).getProduct().name, 
		    		((PriceChange)arg).getProduct().store, 
		    		((PriceChange)arg).getProduct().price) + ".";
		System.out.println(this.name + priceFormatted);
	}
}
