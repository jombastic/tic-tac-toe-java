package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
  @Test
  public void checkRowCol_checkIfCharactersAreSame_true() {
    Game test = new Game('x');
    assertEquals(true, test.checkRowCol('x','x','x'));
  }

  @Test
  public void checkRowCol_checkIfCharactersAreDifferent_false() {
    Game test = new Game('x');
    assertEquals(false, test.checkRowCol('o','x','x'));
  }
}