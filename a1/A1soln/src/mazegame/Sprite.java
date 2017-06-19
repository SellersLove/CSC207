package mazegame;

public abstract class Sprite {
	/** the symbol of the Sprite */
	protected char symbol;
	
	/** the row number the Sprite */
	protected int row;
	
	/** the column number the Sprite */
	protected int column;
	
	/**
	 * creates a Sprite of a given symbol and given position
	 * @param symbol the symbol of the Sprite
	 * @param row the row number of the Sprite
	 * @param column the column of the sprite
	 */
	public Sprite(char symbol, int row, int column){
		this.symbol = symbol;
		this.row = row;
		this.column = column;
	}
	
	/**
	 * @return the symbol of the sprite 
	 */
	public char getSymbol() {
		return symbol;
	}
	
	/**
	 * @return the row number of the sprite 
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * @return the column number of the sprite 
	 */
	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return Character.toString(symbol);
	}
	
}
