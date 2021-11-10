package abgabe4;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public interface Rechenoperation
{
    /**
     * Every implementation of Rechenoperation must implement the method berechne,
     * this represents a single mathematical operation on a supplied double. 
     * 
     * @param x Supplied double to perform the operation on.
     * @return Result of the mathematic operation on x.
     */
    double berechne(double x);
}
