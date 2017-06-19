package e3soln;

import java.util.Observable;
import java.util.Observer;

public class PriceWatchWebsite extends Observable implements Observer{
	private String URL;
    /**
     * Creates a new {@link e3soln.PriceWatchWebsite} with the given URL.
     * @param url the URL of the new {@link e3soln.PriceWatchWebsite}
     */
    // constructor
	public PriceWatchWebsite(String URL){
		this.URL = URL;
	}

    /**
     * Returns the URL of this {@link e3soln.PriceWatchWebsite}.
     * @return the URL of this {@link e3soln.PriceWatchWebsite}
     */
    // getUrl
	public String getUrl(){
		return this.URL;
	}


    /**
     * Prints a message about a price change.
     * Notifies all observers of the change in price.
     */
    // update
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String priceFormatted2 = String.format(" was notified about a "
        		+ "price change of %s at %s to %.2f", 
	    		((PriceChange)arg).getProduct().name, 
	    		((PriceChange)arg).getProduct().store, 
	    		((PriceChange)arg).getProduct().price) + ".";
		String priceFormatted = String.format("You are subscribed to %s",
				this.URL) + ".";
		System.out.println(priceFormatted);
		System.out.println("It" + priceFormatted2);
		setChanged();
		notifyObservers(arg);
	}
}