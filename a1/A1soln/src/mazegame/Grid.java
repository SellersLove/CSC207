package mazegame;

public interface Grid<T> {
	
	/**
	 * sets the cell of a given position to item: T
	 ** @param row the row value of the given position
	 * @param column the column value of the given position
	 * @param item the item is set to the given position
	 */
	public void setCell(int row, int column, T item);
	
	/**
	 * replace the cell of a given position with item: T
	 ** @param row the row value of the given position
	 * @param column the column value of the given position
	 * @param item the new item is going to set in the given position
	 */
	public void changeCell(int row, int column, T item);
	
	/**
	 * gets the item is a given position
	 ** @param row the row value of the given position
	 * @param column the column value of the given position
	 * @return then item:T contained in the given position
	 */
	public T getCell(int row, int column);
	
	public int getNumRows();
	
	public int NumCols();
	
	/**
	 *  compares to a given Grid, compare item in the every position.
	 * @param other the Given Grid
	 * @return true if equals
	 */
	public boolean equals(Grid<T> other);
	
	public String toString();
	
	
}
