package abgabe4;

public class QuadratWurzel implements Rechenoperationsliste.Rechenoperation
{
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
