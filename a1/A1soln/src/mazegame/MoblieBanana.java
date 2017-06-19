package mazegame;

public class MoblieBanana extends Banana implements Moveable{
	
	
	/**
	 * creates a banana and sets symbol, position, value
	 * @param symbol the symbol of the banana 
	 * @param row the row number of the position where the banana is
	 * @param column the column number of the position where the banana is
	 * @param value the value of the banana
	 */
	public MoblieBanana(char symbol, int row, int column, int value) {
		super(symbol, row, column, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return Character.toString(symbol);
	}
	/**
	 * move the Mobliebanana to the given position.
	 * @param row the number of row is added to the odd position
	 * @param col the number of columns is added 
	 */
	@Override
	public void move(int row, int col) {
		this.row = this.row + row;
		this.column = this.column + col;
	}
	

}
