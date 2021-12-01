package abgabe8;

import java.util.ArrayList;

/**
 * Implementation of the Chessman, representing the knight in a game of chess.
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public class Knight extends Chessman {

  public Knight(Position pos) {
    super(pos);
  }

  /**
   * This method returns the fields allowed for the knight. the method returns the move list with
   * the fields to which the knight can move to.
   *
   * @return moves the move list
   */
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

  /**
   * overwritten toString methode
   *
   * @return string with the positions
   */
  @Override
  public String toString() {
    return String.format("Springer: (%d/%d)", this.getPosition().getX(), this.getPosition().getY());
  }
}
