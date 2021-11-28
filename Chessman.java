package JavaHausaufgaben08;

import java.util.ArrayList;

public abstract class Chessman {
  private Position posChessman;


  public Chessman(Position pos) {
    if (pos.isValid(pos.x, pos.y) == true) {
      this.chessman = pos;
    }
  }

/**
 * This methode return the Position
 *
 * @return the position of the Chessman
 */
  public Position getPosition() {
    return this.posChessman;
  }

/**
  *Moves the Chesspiece to the given Position but only if the given position is a valid one.
  */
  public void moveTo(Position pos) {
    if (pos.isValid(pos.x, pos.y) == true) {
      this.chessman = pos;
    }
  }

  public abstract ArrayList<Position> getMoveList();

  public boolean canMoveTo(Position pos) {

    return false;
  }
}
