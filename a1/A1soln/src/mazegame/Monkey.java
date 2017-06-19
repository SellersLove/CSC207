package mazegame;

public class Monkey extends Sprite implements Moveable{
	//
	private int score = 0;
	private int numMoves = 0;
	
	
	/**
	 * creates a monkey and sets symbol, position
	 * @param symbol the symbol of the monkey
	 * @param row the row number of the position where the monkey is
	 * @param column the column number of the position where the monkey is
	 */
	public Monkey(char symbol, int row, int column) {
		super(symbol, row, column);
			}
	/**
	 * add score of the banana
	 * @param score
	 */
	public void eatBanana(int score){
		this.score = this.score + score; 
	}
	
	/**
	 * 
	 * @return returns the score the monkey has gotten
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 
	 * @return returns the number of moves monkey has taken
	 */
	public int getNumMoves() {
		return numMoves;
	}
	
	/**
	 * moves the monkey to a given position and tracks the number of total moves. 
	 * @param row the number of row is added to the odd position
	 * @param col the number of columns is added
	 */
	@Override
	public void move(int row, int col) {
		this.row = this.row + row;
		this.column = this.column + col;
		this.numMoves = this.numMoves + 1;
	}
	
}
