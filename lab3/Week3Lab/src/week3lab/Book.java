package week3lab;

import java.util.Arrays;

public class Book {
	
	private String Title;
	private String[] Authors;
	private double Price;
	private String ISBN;
	
	public Book(String Title, String[] Authors, double Price, String ISBN){
		
		this.Title = Title;
		this.Authors = Authors;
		this.Price = Price;
		this.ISBN = ISBN;
	}

	public Book(String string, String string2, String string3, double d,
			String string4) {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String[] getAuthors() {
		return Authors;
	}

	public void setAuthors(String[] authors) {
		Authors = authors;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String toString() {
		String result = Authors[0];
		for (int i=1; i < Authors.length; i++) {
            result = result +" and "+ Authors[i];
        }
			
		return Title + "(" + ISBN + ", " + Price + ", " + "by " + result +")";
	}
		
	 public static void main(String[] args) {
		 
		 	Book JavaBook = new Book("Developing Java Software", {"Windser, Russel", "Roberts, Graham"}, 79.75, "978-0470090251");
	        System.out.println(JavaBook);
	    }

	

}
