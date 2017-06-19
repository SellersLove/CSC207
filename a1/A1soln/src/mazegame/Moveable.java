package mazegame;

public interface Moveable {
	/**
	 * moves the sprite to a given position
	 * @param row the number of row is added to the odd position
	 * @param col the number of columns is added
	 */
	public void move(int row, int col);
}
