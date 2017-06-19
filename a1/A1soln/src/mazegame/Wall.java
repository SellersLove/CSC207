package mazegame;

public class Wall extends Sprite{
	
	/**
	 * creates a Wall of a given symbol and given position
	 * @param symbol the symbol of the Wall
	 * @param row the row number of the Wall
	 * @param column the column of the Wall
	 */
	public Wall(char symbol, int row, int column) {
		super(symbol, row, column);
	}

}
