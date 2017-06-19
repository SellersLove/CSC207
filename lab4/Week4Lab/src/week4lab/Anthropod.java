package week4lab;

public class Anthropod extends Organism {
	
	
	public int numLegs;
	

	public Anthropod(String name, int xCoord, int yCoord, int speed, String direction, int numLegs){
		
		super(name, xCoord, yCoord, speed, direction);
			
		this.numLegs = numLegs;
		
	}


	public int getNumLegs() {
		return numLegs;
	}


	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	
    public String toString() {
        return super.toString() + ", " + this.numLegs;
    }
    

   
}
