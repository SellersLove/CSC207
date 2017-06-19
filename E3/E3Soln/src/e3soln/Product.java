package e3soln;

import java.util.Observable;


/** A product in a store. **/
public class Product extends Observable{
	
	public String name;
	public double price;
	public String store;
    /**
     * Creates a {@link e3soln.Product} with the given name, price, and store.
     * @param name name of the new {@link e3soln.Product}
     * @param price price of the new {@link e3soln.Product}
     * @param store store of the new {@link e3soln.Product}
     */
    // constructor
	public Product(String name, double price, String store){
		this.name = name;
		this.price = price;
		this.store = store;
	}

    /**
     * Returns the name of this {@link e3soln.Product}.
     * @return the name of this {@link e3soln.Product}
     */
    // getName
	public String getName(){
		return this.name;
	}

    /**
     * Returns the price of this {@link e3soln.Product}.
     * @return the price of this {@link e3soln.Product} 
     */
    // getPrice (returns a double)
	public double getPrice(){
		return this.price;
	}

    /**
     * Returns the store of this {@link e3soln.Product}.
     * @return the store of this {@link e3soln.Product}
     */
    // getStore
	public String getStore(){
		return this.store;
	}

    /**
     * Changes the price of this {@link e3soln.Product} to newPrice. All 
     * observers are notified, if the price is changed.
     * @param newPrice the new price of this {@link e3soln.Product}
     */
    // changePrice
	 public void changePrice(double newPrice) {
	        this.price = newPrice;
	        setChanged();
	        String priceFormatted = String.format(" was notified about a "
	        		+ "price change of %s at %s to %.2f", 
		    		this.name, this.store, this.price) + ".";
	        notifyObservers(new PriceChange(this));
	    }

	@Override
	// toString()
	public String toString() {

	    String priceFormatted = String.format("The price of %s at %s is %.2f", 
	    		name, store, price) + ".";
		return priceFormatted;
	}


}
