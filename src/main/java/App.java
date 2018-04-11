import models.Game;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Game newGame = new Game('x');
    newGame.initializeBoard();
    do {
      System.out.println("Current board layout:");
      newGame.printBoard();
      int row;
      int col;
      do {
        System.out.println("Player " + newGame.getCurrentPlayer() + ", enter an empty row and column " +
                "and place your mark!");
        row = scanner.nextInt() - 1;
        col = scanner.nextInt() - 1;
      } while (!newGame.placeMark(row, col));
      newGame.changePlayer();
    } while (!newGame.isWinner() && !newGame.isBoardFull());

    if (newGame.isBoardFull() && !newGame.isWinner()) {
      System.out.println("The game was a tie!");
    } else {
      System.out.println("Current board layout:");
      newGame.printBoard();
      newGame.changePlayer();
      System.out.println(Character.toUpperCase(newGame.getCurrentPlayer()) + " Wins!");
    }
  }
}
