package abgabe4;

public class Addition implements Rechenoperationsliste.Rechenoperation
{
    private final double addV;

    public Addition(double value)
    {
        this.addV = value;
    }

    @Override
    public double berechne(double x)
    {
        return x + addV;
    }

}
