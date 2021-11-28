package JavaHausaufgaben08;

import java.util.ArrayList;

public abstract class Chessman {
  private Position chessman;

  public Chessman(Position pos) {
    if (pos.isValid(pos.x, pos.y) == true) {
      this.chessman = pos;
    }
  }

  public Position getPosition() {
    return this.chessman;
  }

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
