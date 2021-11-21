package abgabe7;

/**
 * This Exception may be thrown in the context of an instance of Schiebepuzzle when a given number
 * was not applicable.
 * 
 * @author Martin Albertz, Selina Fiorin, Josha Bartsch
 */
public class WrongNumberException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 3473277141053132391L;

  public WrongNumberException(String message) {
    super(message);
  }
}
