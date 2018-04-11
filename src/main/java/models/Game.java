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

  public void printBoard() {
    System.out.println("-------------");
    for (int i = 0; i < 3; i++) {
      System.out.print("|");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + "|");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

  public boolean isWinner() {
    return (checkRows());
  }

  private boolean checkRows() {
    for (int i = 0; i < 3; i++) {
      if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
        return true;
      }
    }
    return false;
  }

  private boolean checkRowCol(char c1, char c2, char c3) {
    return ((c1 != '-') && (c1 == c2) && (c2 == c3));
  }
}
