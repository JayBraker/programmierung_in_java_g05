package abgabe7;

public class WrongNumberException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 3473277141053132391L;
  
  public WrongNumberException(String message) {
    super(message);
  }
}
