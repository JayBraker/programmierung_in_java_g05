package abgabe4;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public class Quadrat implements Rechenoperation
{
    /**
     * Returns square of any supplied double.
     * 
     * @param x Double value to calculate square of.
     * @return Supplied x squared.
     */
    @Override
    public double berechne(double x)
    {
        return Math.pow(x, 2);      // erstes Argument „hoch“ das zweite Argument)
    }
}
