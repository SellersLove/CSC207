package week4lab;

public class W4Lab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Organism lobster = new Anthropod("Homarus gammarus", 0, 0, 2, "north", 10);
		System.out.println(lobster);
		lobster.move();
		System.out.println(lobster);
		
	}

}
