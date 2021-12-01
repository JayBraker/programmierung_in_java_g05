package abgabe8;

/**
 * Custom Exception thrown for illegal moves of any chess piece. (i.e. exceeding borders, ignoring
 * movement patterns).
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class WrongMoveException extends RuntimeException {

  /** */
  private static final long serialVersionUID = -605730053271922909L;

  public WrongMoveException() {
    super();
  }
}
