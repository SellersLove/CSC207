package mazegame;

import java.util.ArrayList;
import java.util.List;

public class ArrayGrid<T> implements Grid<T>{
	private int numRows;
	private int numCols;
	private int Position;
	private List<T> sprites;

	/**
	 *  Creates a new ArrayGrid
	 * @param numRows the number of rows The List<T> sprites has
	 * @param numCols the number of column The List<T> sprites has
	 */
	public ArrayGrid(int numRows, int numCols){
		this.numRows = numRows;
		this.numCols = numCols;
		this.sprites = new ArrayList<T>();	
	}
	
	/**
	 * sets the List<T> sprites of a given position to item: T
	 ** @param row the row value of the given position
	 * @param column the column value of the given position
	 * @param item the item is set to the given position
	 */
	@Override
	public void setCell(int row, int column, T item) {
		Position = row * numCols + column;
		this.sprites.add(Position, item);
		
	}
	
	/**
	 * gets the item in a given position in List<T> sprites
	 ** @param row the row value of the given position
	 * @param column the column value of the given position
	 * @return then item of given position in List<T> sprites
	 */
	@Override
	public T getCell(int row, int column) {
		Position = row * numCols + column;
		return this.sprites.get(Position);
	}
	
	/**
	 * returns the number of row in List.
	 */
	@Override
	public int getNumRows() {
		return this.numRows;
	}
	
	/**
	 * returns the number of column in List.
	 */
	@Override
	public int NumCols() {
		// TODO Auto-generated method stub
		return this.numCols;
	}
	
	/**
	 * compares to a given Grid, compare the symbol of the 
	 * item in the every position.
	 * @param other the Given Grid
	 * @return true if equals
	 */
	@Override
	public boolean equals(Grid<T> other) {
		for(int i = 0; i< this.numRows;i++)
		{
			for(int s = 0; s < numCols; s++)
			{	
				int position = i* numCols + s;
				boolean check = sprites.get(position).toString().equals(
						other.getCell(i, s).toString());
				if(!check){
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i< this.numRows;i++)
		{
			for(int s = 0; s < numCols; s++)
			{	
				int position = i* numCols + s;
				result = result + sprites.get(position);
			}
			if(i != this.numRows-1){
				result = result + "\n";
			}

		}
		return result;
	}
	
	/**
	 * replace the cell of a given position with item: T
	 ** @param row the row value of the given position
	 * @param column the column value of the given position
	 * @param item the new item is going to set in the given position
	 */
	@Override
	public void changeCell(int row, int column, T item) {
		Position = row * numCols + column;
		this.sprites.set(Position, item);
	}


}
