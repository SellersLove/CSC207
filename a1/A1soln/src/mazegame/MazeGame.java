package mazegame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

/**
 * A class that represents the basic functionality of the maze game.
 * This class is responsible for performing the following operations:
 * 1. At creation, it initializes the instance variables used to store the
 *        current state of the game.
 * 2. When a move is specified, it checks if it is a legal move and makes the
 *        move if it is legal.
 * 3. It reports information about the current state of the game when asked.
 */
public class MazeGame {
	
    /** A random number generator to move the MobileBananas. */
    private Random random;
    
    /** The maze grid. */
    private Grid<Sprite> maze;
    
    /** The first player. */
    private Monkey player1;
    
    /** The second player. */
    private Monkey player2;

    /** The bananas to eat. */
    private List<Banana> bananas = new ArrayList<Banana>();
    
    public Grid<Sprite> getMaze() {
		return maze;
	}

	public Monkey getPlayerOne() {
		return player1;
	}

	public Monkey getPlayerTwo() {
		return player2;
	}
	
	public int getNumRows(){
		return maze.getNumRows();
	}
	
	public int getNumCols(){
		return maze.NumCols();
	}
	
	public Sprite get(int i, int j)
	{
		return maze.getCell(i, j);
		
	}
	
	/**
	 * change the given position with a new Sprite
	 * @param row row value of the given position
	 * @param col column value of the given position
	 * @param spite the new sprite we are setting to this given position
	 */
	public void changeCell(int row, int col, Sprite sprite){	
		maze.changeCell(row, col, sprite);
	}
	
	/**
	 * random generate a direction for each MolblieBanana, then check if the 
	 * direction is movable and move it if it is.
	 */
	public void bananaMove(){
		for(Banana banana: bananas ){
			if (banana instanceof MoblieBanana){
				int move = random.nextInt(4);
				this.bananaMoveable((MoblieBanana) banana, move);
			}
		}
	}
	
	/**
	 * check if this MobileBanana can move to a certain direction
	 * if it can then move it.
	 * @param banana the banana we are checking
	 * @param move  the direction the banana is moving
	 */
	public void bananaMoveable(MoblieBanana banana, int move){
		int row =  banana.getRow();
		int col = banana.getColumn();
		boolean checkUp;
		boolean checkDown;
		boolean checkRight;
		boolean checkLeft;
		checkUp = (maze.getCell(row - 1, col) instanceof UnvisitedHallway);
		checkDown = (maze.getCell(row + 1, col) instanceof UnvisitedHallway);
		checkRight = (maze.getCell(row, col+1) instanceof UnvisitedHallway);
		checkLeft = (maze.getCell(row, col-1) instanceof UnvisitedHallway);
		if(move == 0 && checkUp){
			this.changeCell(row, col, new UnvisitedHallway(' ', row, col));
			this.changeCell(row - 1, col, banana);
			banana.move(-1, 0);
		}
		if(move == 1 && checkDown){
			this.changeCell(row, col, new UnvisitedHallway(' ', row, col));
			this.changeCell(row + 1, col, banana);
			banana.move(1, 0);
		}
		if(move == 2 && checkRight){
			this.changeCell(row, col, new UnvisitedHallway(' ', row, col));
			this.changeCell(row, col + 1, banana);
			banana.move(0, 1);

		}
		if(move == 3 && checkLeft){
			this.changeCell(row, col, new UnvisitedHallway(' ', row, col));
			this.changeCell(row, col - 1, banana);
			banana.move(0, -1);
		}
	}
	
	/**
	 * check if given position contains a banana, if it contains and 
	 * player eat the banana,
	 * get score, then remove the banana from the List<banana> .
	 * @param row  the row value of the given position
	 * @param col  the column value of the given position 
	 * @param p p has two value 1,2. 1 stands for player 1 , and 2 
	 * for player two
	 */
	public void eatBanana(int row, int col, int p){
		if(p == 1){
			if(maze.getCell(row, col) instanceof MoblieBanana){
				if( bananas.remove(maze.getCell(row,col))){
					player1.eatBanana(2);
				}	
			}	
			if(maze.getCell(row, col) instanceof Banana){
				if( bananas.remove(maze.getCell(row,col))){
					player1.eatBanana(1);
				}
				
			}
		}
		
		if(p == 2){
			if(maze.getCell(row, col) instanceof MoblieBanana){
				if( bananas.remove(maze.getCell(row,col)) ){
					player2.eatBanana(2);
				}	
			}	
			if(maze.getCell(row, col) instanceof Banana){
				if( bananas.remove(maze.getCell(row,col))){
					player2.eatBanana(1);
				}
			}
		}
	}
	
	/**
	 * checks the for the given direction if player1 is movable 
	 * @param move the given direction the player1 is going to
	 *  move i.e. 'a','s','d','w'. 
	 * @return true if is movable for the given position. false otherwise
	 */
	public boolean moveable1(char move)
	{	
		int [] position = new int [2]; // store the position of player1
		position[0] = player1.getRow();
		position[1] =player1.getColumn();
		
		boolean checkUp; // check if Up is blocked
		boolean checkLeft; // check if Left is blocked
		boolean checkDown; // check if Down is blocked
		boolean checkRight; // check if Right id blocked
		
		checkUp = ((maze.getCell(position[0]-1, position[1]) 
				instanceof Wall) 
				|| (maze.getCell(position[0]-1, position[1]) 
						instanceof VisitedHallway)
				|| (maze.getCell(position[0]-1, position[1]) 
						instanceof Monkey));
		
		checkLeft = ((maze.getCell(position[0], position[1]-1) 
				instanceof Wall)
				|| (maze.getCell(position[0], position[1]-1) 
						instanceof VisitedHallway)
				||(maze.getCell(position[0], position[1]-1) 
						instanceof Monkey));
		
		checkDown = ((maze.getCell(position[0]+1, position[1]) 
				instanceof Wall)
				|| (maze.getCell(position[0]+1, position[1]) 
						instanceof VisitedHallway)
				|| (maze.getCell(position[0]+1, position[1]) 
						instanceof Monkey));
		
		checkRight = ((maze.getCell(position[0], position[1]+1) 
				instanceof Wall)
				|| (maze.getCell(position[0], position[1]+1) 
						instanceof VisitedHallway)
				|| (maze.getCell(position[0], position[1]+1) 
						instanceof Monkey));
		
		if((move == 'w') && (checkUp)){
			return false;
		}
		if((move == 'a') && (checkLeft)){
			return false;
		}
		if((move == 's') && (checkDown)){
			return false;
		}
		if((move == 'd') && (checkRight)){
			return false;
		}
		else
			return true;
	}
	
	/**
	 * checks the for the given direction if player2 is movable 
	 * @param move move the given direction the player2 is going to move i.e. 'j','k','l','i'.
	 * @return true if it is movable for the given position, false otherwise
	 */
	public boolean moveable2(char move)
	{	
		int [] position = new int [2]; // store the position of player
		position[0] = player2.getRow();
		position[1] = player2.getColumn();
		
		boolean checkUp; // check if Up is blocked
		boolean checkLeft; // check if Left is blocked
		boolean checkDown; // check if Down is blocked
		boolean checkRight; // check if Right id blocked
		
		checkUp = ((maze.getCell(position[0]-1, position[1]) 
					instanceof Wall) 
				|| (maze.getCell(position[0]-1, position[1]) 
						instanceof VisitedHallway)
				|| (maze.getCell(position[0]-1, position[1]) 
						instanceof Monkey));
		
		checkLeft = ((maze.getCell(position[0], position[1]-1) 
					instanceof Wall)
				|| (maze.getCell(position[0], position[1]-1) 
						instanceof VisitedHallway)
				||(maze.getCell(position[0], position[1]-1) 
						instanceof Monkey));
		
		checkDown = ((maze.getCell(position[0]+1, position[1]) 
					instanceof Wall)
				|| (maze.getCell(position[0]+1, position[1]) 
						instanceof VisitedHallway)
				|| (maze.getCell(position[0]+1, position[1]) 
						instanceof Monkey));
		
		checkRight = ((maze.getCell(position[0], position[1]+1) 
					instanceof Wall)
				|| (maze.getCell(position[0], position[1]+1) 
						instanceof VisitedHallway)
				|| (maze.getCell(position[0], position[1]+1) 
						instanceof Monkey));
		
		if((move == 'i') && (checkUp)){
			return false;
		}
		else if((move == 'j') && (checkLeft)){
			return false;
		}
		else if((move == 'k') && (checkDown)){
			return false;
		}
		else if((move == 'l') && (checkRight)){
			return false;
		}
		else
			return true;
	}
	
	/**
	 * moves player1, player2, and MoblieBananas.  
	 * @param nextmove the direction of next move for player1 and player2.
	 */
	public void move(char nextmove){
		this.bananaMove();
		int [] p1 = new int [2];
		int [] p2 = new int [2];
		p1[0] = player1.getRow();
		p1[1] = player1.getColumn();
		p2[0] = player2.getRow();
		p2[1] = player2.getColumn();
		if(nextmove == 'w' && this.moveable1('w')){
			this.changeCell(p1[0], p1[1], 
					new VisitedHallway('.', p1[0], p1[1]));
			player1.move(-1,0);
			this.eatBanana(p1[0]-1, p1[1], 1);
			this.changeCell(p1[0]-1, p1[1], player1);
			}
		else if(nextmove == 's' && this.moveable1('s')){
			this.changeCell(p1[0], p1[1], 
					new VisitedHallway('.', p1[0], p1[1]));
			player1.move(1,0);
			this.eatBanana(p1[0]+1, p1[1], 1);
			this.changeCell(p1[0] + 1, p1[1], player1);
			}
		else if(nextmove == 'a' && this.moveable1('a')){
			this.changeCell(p1[0], p1[1], new VisitedHallway('.',p1[0],p1[1]));
			player1.move(0,-1);
			this.eatBanana(p1[0], p1[1]-1, 1);
			this.changeCell(p1[0], p1[1]-1, player1);
			}
		else if(nextmove == 'd' && this.moveable1('d')){
			this.changeCell(p1[0], p1[1], new VisitedHallway('.',p1[0],p1[1]));
			player1.move(0,1);
			this.eatBanana(p1[0], p1[1]+1, 1);
			this.changeCell(p1[0], p1[1]+1, player1);
			}
		else if(nextmove == 'i' && this.moveable2('i')){
			this.changeCell(p2[0], p2[1], new VisitedHallway('.',p2[0],p2[1]));
			player2.move(-1,0);
			this.eatBanana(p2[0]-1, p2[1], 2);
			this.changeCell(p2[0]-1, p2[1], player2);
			}
		else if(nextmove == 'j' && this.moveable2('j')){
			this.changeCell(p2[0], p2[1], new VisitedHallway('.',p2[0],p2[1]));
			player2.move(0,-1);
			this.eatBanana(p2[0], p2[1]-1, 2);
			this.changeCell(p2[0], p2[1]-1, player2);
			}
		else if(nextmove == 'k' && this.moveable2('k')){
			this.changeCell(p2[0], p2[1], new VisitedHallway('.',p2[0],p2[1]));
			player2.move(1,0);
			this.eatBanana(p2[0]+1, p2[1], 2);
			this.changeCell(p2[0]+1, p2[1], player2);
			}
		else if(nextmove == 'l' && this.moveable2('l')){
			this.changeCell(p2[0], p2[1], new VisitedHallway('.',p2[0],p2[1]));
			player2.move(0,1);
			this.eatBanana(p2[0], p2[1]+1, 2);
			this.changeCell(p2[0], p2[1]+1, player2);
			}
	}
	
	
	/**
	 *  checks if all banana are eaten
	 * @return true if they are all eaten, false otherwise.
	 */
	public boolean checkBanana(){

		if(bananas.size() == 0){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * checks if both players are blocked, before all bananas are eaten.
	 * @return true if both players are blocked, before all bananas are eaten, 
	 * false otherwise.
	 */
	public boolean isBlocked(){

		boolean p1;
		boolean p2;
		p1 = (this.moveable1('w')==false)&&(this.moveable1('a')==false)
				&&(this.moveable1('s')==false)&&(this.moveable1('d')==false);
		p2 = (this.moveable2('i')==false)&&(this.moveable2('j')==false)
				&&(this.moveable2('k')==false)&&(this.moveable2('l')==false);
		if(!this.checkBanana()){
			if (p1 && p2){
				return true;
			}
			else 
				return false; 
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public int hasWon(){
		if(!this.isBlocked() && !this.checkBanana()){
			return 0;
		}
		else if(this.isBlocked()){
			if(player1.getScore() > player2.getScore()){
				return 1;
			}
			else if(player2.getScore() > player1.getScore()){
				return 2;
			}
			else
				return 3;
		}
		else if(checkBanana()){
			if(player1.getScore() > player2.getScore()){
				return 1;
			}
			else if(player2.getScore() > player1.getScore()){
				return 2;
			}
			else
				return 3;
		}
		else
			return 0;
	}

	
	

	/**
     * Creates a new MazeGame that corresponds to the maze in the file
     * named layoutFileName.
     * @param layoutFileName the path to the input maze file
     */
    public MazeGame(String layoutFileName) throws IOException {
        random = new Random();
        
        int[] dimensions = getDimensions(layoutFileName);
        maze = new ArrayGrid<Sprite>(dimensions[0], dimensions[1]);
               
        Scanner sc = new Scanner(new File(layoutFileName));

        /* INITIALIZE THE GRID HERE */
      
        for(int i = 0; i< dimensions[0];i++)
		{	
        	String nextline = sc.nextLine();
			for(int s = 0; s < dimensions[1]; s++)
			{	
				char symbol = nextline.charAt(s);
				SetSprite(i, s, symbol, maze);
			}
			
		}
       
        sc.close();
    }
    
    /**
     * Returns the dimensions of the maze in the file named layoutFileName.
     * @param layoutFileName the path of the input maze file
     * @return an array [numRows, numCols], where numRows is the number
     * of rows and numCols is the number of columns in the maze that
     * corresponds to the given input maze file
     * @throws IOException
     */    
    private int[] getDimensions(String layoutFileName) throws IOException {       
        
        Scanner sc = new Scanner(new File(layoutFileName));

        // find the number of columns
        String nextLine = sc.nextLine();
        int numCols = nextLine.length();

        int numRows = 1;

        // find the number of rows
        while (sc.hasNext()) {
            numRows++;
            nextLine = sc.nextLine();
        }

        sc.close();
        return new int[]{numRows, numCols};
    }
    
    /**
	 * Sets the sprite according to the symbol read from the file.
	 * @param row row value of the position, sprite is set.
	 * @param col column value of the position, sprite is set.
	 * @param symbol symbol for the sprite 
	 * @param maze the maze all sprites are set in.
	 */
	public void SetSprite(int row, int col, char symbol,Grid<Sprite> maze){
		if(symbol ==' '){
			maze.setCell(row, col, new UnvisitedHallway(' ' ,row, col));
			}
		else if(symbol=='.'){
			maze.setCell(row, col, new VisitedHallway('.' ,row, col));
		}
		else if(symbol == 'X'){
			maze.setCell(row, col, new Wall('X' ,row, col));
			}
		
		else if (symbol == 'B'){
			bananas.add(new Banana('B' ,row, col,1));
			maze.setCell(row, col, bananas.get(bananas.size()-1));
			}
		else if (symbol == 'M'){
			bananas.add(new MoblieBanana('M' ,row, col,2));
			maze.setCell(row, col, bananas.get(bananas.size()-1));
		}
		else if(symbol == '1'){
			player1 = new Monkey('1' ,row, col);
			maze.setCell(row, col, player1);
		}
		else if(symbol == '2'){
			player2 = new Monkey('2' ,row, col);
			maze.setCell(row, col, player2);
		}	
	}
}
