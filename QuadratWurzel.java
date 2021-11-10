package abgabe4;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public class QuadratWurzel implements Rechenoperation
{
    /**
     * Returns square root of any supplied double.
     * Throws runtime ArithmeticException if double is < 0.
     * 
     * @param x Double value to calculate square root of.
     * @return square root of supplied x.
     */
    @Override
    public double berechne(double x)
    {
        if (x < 0)
        {
            throw new ArithmeticException();
        }
        return Math.sqrt(x);
    }

}
