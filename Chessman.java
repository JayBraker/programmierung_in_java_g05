package abgabe8;

import java.util.ArrayList;

public abstract class Chessman {

  private Position position;
  private ArrayList<Position> moves;

  public Chessman(Position pos) {
    this.position = pos;
    this.moves = getMoveList();
  }

  /**
   * This methode return the Position
   *
   * @return the position of the Chessman
   */
  public Position getPosition() {
    return this.position;
  }

  /** Moves the Chesspiece to the given Position but only if the given position is a valid one. */
  public void moveTo(Position pos) {
    if (canMoveTo(pos)) {
      this.position = pos;
      this.moves = getMoveList();
    } else {
      throw new WrongMoveException();
    }
  }

  public abstract ArrayList<Position> getMoveList();

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
