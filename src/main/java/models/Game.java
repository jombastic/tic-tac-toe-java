package models;

public class Game {
  private char[][] board = new char[3][3];
  private char currentPlayer;

  public Game(char currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public char getCurrentPlayer() {
    return this.currentPlayer;
  }

  public void initializeBoard() {
    // Loop through rows
    for (int i = 0; i < 3; i++) {
      // Loop through columns
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  public boolean isBoardFull() {
    return (board[0][0] != '-') && (board[0][1] != '-') && (board[0][2] != '-') &&
            (board[1][0] != '-') && (board[1][1] != '-') && (board[1][2] != '-') &&
            (board[2][0] != '-') && (board[2][1] != '-') && (board[2][2] != '-');
  }

  public void printBoard() {
    System.out.println("-------");
    for (int i = 0; i < 3; i++) {
      System.out.print("|");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + "|");
      }
      System.out.println();
      System.out.println("-------");
    }
  }

  public boolean isWinner() {
    return (checkRows() || checkColumns() || checkDiagonals());
  }

  private boolean checkRows() {
    for (int i = 0; i < 3; i++) {
      if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
        return true;
      }
    }
    return false;
  }

  private boolean checkColumns() {
    for (int i = 0; i < 3; i++) {
      if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonals() {
    return checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]);
  }

  boolean checkRowCol(char c1, char c2, char c3) {
    return ((c1 != '-') && (c1 == c2) && (c2 == c3));
  }

  public void changePlayer() {
    if (currentPlayer == 'x') {
      currentPlayer = 'o';
    } else {
      currentPlayer = 'x';
    }
  }

  public boolean placeMark(int row, int col) {
    if ((row >= 0) && (row < 3) && (col >= 0) && (col < 3)) {
      if (board[row][col] == '-') {
        board[row][col] = currentPlayer;
        return true;
      }
    }
    return false;
  }
}
