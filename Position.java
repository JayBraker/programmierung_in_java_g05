package abgabe8;

public class Position {
  private static final int maxX = 8;
  private static final int maxY = 8;

  private int x;
  private int y;

  public Position(int x, int y) {
    if (isValid(x, y)) {
      this.x = x;
      this.y = y;
    } else {
      throw new WrongMoveException();
    }
  }

  public Position(Position pos) {
    this.x = pos.x;
    this.y = pos.y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
  
  public boolean equals(Position pos) {
    return ((pos.x == this.x) && (pos.y == this.y));
  }

  public static boolean isValid(int x, int y) {
    if ((x > 0 && x <= maxX) && (y > 0 && y <= maxY)) {
      return true;
    }
    return false;
  }

  public String toString() {
    return String.format("(%d/%d)", this.x, this.y);
  }
}
