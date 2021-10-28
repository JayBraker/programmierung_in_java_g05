package abgabe4;

public class Quadrat implements Rechenoperationsliste.Rechenoperation
{
    @Override
    public double berechne(double x)
    {
        return Math.pow(x, 2);
    }
}
