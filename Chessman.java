package abgabe8;

import java.util.ArrayList;

public abstract class Chessman {
  private Position position;
  private ArrayList<Position> moves;

  public Chessman(Position pos) {
    this.position = pos;
    this.moves = getMoveList();
  }

  public Position getPosition() {
    return this.position;
  }

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
