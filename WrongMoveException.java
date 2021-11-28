package abgabe7;

/**
 * This Exception may be thrown in the context of an instance of Schiebepuzzle when a performed move
 * was not allowed.
 *
 * @author Martin Albertz, Selina Fiorin, Josha Bartsch
 */
public class WrongMoveException extends RuntimeException {
  public WrongMoveException(String message) {
    super(message);
  }
}
