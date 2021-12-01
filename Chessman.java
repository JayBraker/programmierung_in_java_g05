package abgabe8;

import java.util.ArrayList;

/**
 * Super-class representing a base for every chess piece.
 * Implements movements on the board and other generic interactions.
 * Relies on the individual implementation of getMoveList
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public abstract class Chessman {

  private Position position;
  private ArrayList<Position> moves;

  /**
   * The Constructor sets the position of the Chessman and gets it's movelist.
   *
   * @param pos the position
   */
  public Chessman(Position pos) {
    this.position = pos;
    this.moves = getMoveList();
  }

  /**
   * This methode returns the Position.
   *
   * @return the position of the Chessman
   */
  public Position getPosition() {
    return this.position;
  }

  /**
   * Moves the Chesspiece to the given Position but only if the given position is a valid one.
   *
   * @param pos Current position of the Cheesspiece
   * @return the position of the Chessman
   */
  public void moveTo(Position pos) {
    if (canMoveTo(pos)) {
      this.position = pos;
      this.moves = getMoveList();
    } else {
      throw new WrongMoveException();
    }
  }

  /**
   * Abstract method used to determine every move allowed for the chess piece.
   * Implementations should respect the individual restrictions on the movent and the current position on the board.
   */
  public abstract ArrayList<Position> getMoveList();

  /**
   * Checks if the Chesspiece can move to the given position.
   *
   * @param pos the position of where to go
   * @return true or false
   */
  public boolean canMoveTo(Position pos) {
    boolean mayMove = false;
    for (Position move : this.moves) {
      if (pos.equals(move)) {
        mayMove = true;
        break;
      }
    }
    return mayMove;
  }
}
