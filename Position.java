package abgabe8;

/**
 * Class representing the position of a chess piece on the board.
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class Position {
  private static final int maxX = 8;
  private static final int maxY = 8;

  private int x;
  private int y;

  /**
   * Position constructor initalizes with x- and y- coordinates.
   *
   * @param x X coordinate.
   * @param y Y coordinate.
   */
  public Position(int x, int y) {
    if (isValid(x, y)) {
      this.x = x;
      this.y = y;
    } else {
      throw new WrongMoveException();
    }
  }

  /**
   * Copy constructor.
   *
   * @param pos Position object to be cloned.
   */
  public Position(Position pos) {
    this.x = pos.x;
    this.y = pos.y;
  }

  /**
   * Getter for x-coordinate.
   *
   * @return int x coordinate.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Getter for y-coordinate.
   *
   * @return int y coordinate.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Compares given position with another object. Returns true if x- and y-coordinates match.
   *
   * @param pos Position to compare to.
   * @return boolean
   */
  public boolean equals(Position pos) {
    return ((pos.x == this.x) && (pos.y == this.y));
  }

  /**
   * Validates a set of x- and y-coordinates. Uses params maxX and maxY to recognize maximum size of
   * the board (should be 8 for a regular game of chess).
   *
   * @param x X-coordinate, must be in range of 1 and maxX.
   * @param y Y-coordinate, must be in range of 1 and maxY.
   * @return boolean
   */
  public static boolean isValid(int x, int y) {
    if ((x > 0 && x <= maxX) && (y > 0 && y <= maxY)) {
      return true;
    }
    return false;
  }

  /**
   * Custom toStiring, format "(X/Y)".
   *
   * @return String
   */
  @Override
  public String toString() {
    return String.format("(%d/%d)", this.x, this.y);
  }
}
