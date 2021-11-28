package abgabe8;

import java.util.ArrayList;

public class Rook extends Chessman {

  public Rook(Position pos) {
    super(pos);
    // TODO Auto-generated constructor stub
  }

  @Override
  public ArrayList<Position> getMoveList() {
    ArrayList<Position> moves = new ArrayList<>();
    Position pos = this.getPosition();

    for (int i = 1; i < pos.getX(); i++) {
      moves.add(new Position(i, pos.getY()));
    }
    for (int i = pos.getX() + 1; i <= 8; i++) {
      moves.add(new Position(i, pos.getY()));
    }
    for (int i = 1; i < pos.getY(); i++) {
      moves.add(new Position(pos.getX(), i));
    }
    for (int i = pos.getY() + 1; i <= 8; i++) {
      moves.add(new Position(pos.getX(), i));
    }

    return moves;
  }

  @Override
  public String toString() {
    return String.format("Turm: (%d/%d)", this.getPosition().getX(), this.getPosition().getY());
  }
}