package mazegame;

public class Banana extends Sprite{
	
	
	/** the value the monkey will get when eat this banana*/
	protected int value;
	
	/**
	 * creates a banana and sets symbol, position, value
	 * @param symbol the symbol of the banana 
	 * @param row the row number of the position where the banana is
	 * @param column the column number of the position where the banana is
	 * @param value the value of the banana
	 */
	public Banana(char symbol, int row, int column, int value) {
		super(symbol, row, column);
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	/**
	 *  returns the value of the banana
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
}
