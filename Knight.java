package abgabe8;

import java.util.ArrayList;

public class Knight extends Chessman {

  public Knight(Position pos) {
    super(pos);
    // TODO Auto-generated constructor stub
  }

  @Override
  public ArrayList<Position> getMoveList() {
    ArrayList<Position> moves = new ArrayList<>();
    Position pos = this.getPosition();

    if (Position.isValid(pos.getX() - 2, pos.getY() - 1)) {
      moves.add(new Position(pos.getX() - 2, pos.getY() - 1));
    }
    if (Position.isValid(pos.getX() - 2, pos.getY() + 1)) {
      moves.add(new Position(pos.getX() - 2, pos.getY() + 1));
    }
    if (Position.isValid(pos.getX() - 1, pos.getY() + 2)) {
      moves.add(new Position(pos.getX() - 1, pos.getY() + 2));
    }
    if (Position.isValid(pos.getX() + 1, pos.getY() + 2)) {
      moves.add(new Position(pos.getX() + 1, pos.getY() + 2));
    }
    if (Position.isValid(pos.getX() - 1, pos.getY() - 2)) {
      moves.add(new Position(pos.getX() - 1, pos.getY() - 2));
    }
    if (Position.isValid(pos.getX() + 1, pos.getY() - 2)) {
      moves.add(new Position(pos.getX() + 1, pos.getY() - 2));
    }
    if (Position.isValid(pos.getX() + 2, pos.getY() - 1)) {
      moves.add(new Position(pos.getX() + 2, pos.getY() - 1));
    }
    if (Position.isValid(pos.getX() + 2, pos.getY() + 1)) {
      moves.add(new Position(pos.getX() + 2, pos.getY() + 1));
    }

    return moves;
  }

  @Override
  public String toString() {
    return String.format("Springer: (%d/%d)", this.getPosition().getX(), this.getPosition().getY());
  }
}
