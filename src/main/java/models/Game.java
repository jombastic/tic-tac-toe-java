package models;

public class Game {
  private char[][] board;
  private char currentPlayer;

  public void initializeBoard() {
    // loop through rows
    for (int i = 0; i < 3; i++) {
      // loop through columns
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }
}