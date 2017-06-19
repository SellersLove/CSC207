package ui;

import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mazegame.MazeGame;

public class TextUI implements UI {

  /* The reference to the underlying maze class,
   * which needs to be updated when a tile is selected. */
  private MazeGame game;

  /**
   * Creates a new TextUI for the given maze game.
   * @param game the maze game for this TextUI
   */
  public TextUI(MazeGame game) {
    this.game = game;
  }

  @Override
  public void launchGame() {
    System.out.println();
    Scanner scanner = new Scanner(System.in);
    String move;

    while (!game.isBlocked() && game.hasWon() == 0) {
      System.out.println(game.getMaze().toString());
      System.out.print("Next move: ");
      move = scanner.next();
      System.out.println();
      game.move(move.charAt(0));
      scanner.reset();
    }
    scanner.close();
  } 

  @Override
  public void displayWinner() {

    int won = game.hasWon();    
    int moves = 0;
    String message;

    if (game.isBlocked()) { // no winners
      message = "Game over! Both players are stuck.";
    } else {
      if (won == 0) { // game is still on
        return;
      } else if (won == 1) {
        message = "Congratulations Player 1! You won the maze in " + 
            game.getPlayerOne().getNumMoves() + " moves.";
      } else if (won == 2) { 
        message = "Congratulations Player 2! You won the maze in " + 
            game.getPlayerTwo().getNumMoves() + " moves.";
      } else { // it's a tie
        message = "It's a tie!";
      }
    }   
    System.out.println(message);
  }
}