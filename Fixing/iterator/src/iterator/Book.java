package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Book implements Iterable<Contact>{
	
	private List<Contact> contacts;
	
	public Book(){
		contacts = new ArrayList<>();
	}
	
	 public void addContact(String lastName, String firstName,
	            String email, String phone, String address) {
	        Contact c = new Contact(lastName, firstName, email, phone, address);
	        contacts.add(c);
	    }

	    /**
	     * Returns the number of contacts in this book.
	     * @return the number of contacts in this book.
	     */
	    public int getSize() {
	        return contacts.size();
	    }

	    @Override
	    public String toString() {
	        String res = "";
	        for (Contact c : contacts) {
	            res += c;
	        }
	        return res;
	    }
	
	@Override
	public Iterator<Contact> iterator() {
		// TODO Auto-generated method stub
		return new BookIterator();
	}
	
	 private class BookIterator implements Iterator<Contact>{
		 private int current = contacts.size();
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current > 0;
			
		}

		@Override
		public Contact next() {

			// TODO Auto-generated method stub

			current = current - 1; 
			return contacts.get(current);
			
/*			Contact res;

            // List.get(i) throws an IndexOutBoundsException if
            // we call it with i >= contacts.size().
            // But Iterator's next() needs to throw a 
            // NoSuchElementException if there are no more elements.
            try {
                res = contacts.get(current);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current -= 1;*/

		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		 
	 }

}
