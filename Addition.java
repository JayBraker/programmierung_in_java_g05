package abgabe4;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public class Addition implements Rechenoperation
{
    /**
     * Variable addV holds the value that is to be added in method berechne.
     */
    private final double addV;

    /**
     * @param value The value that is to be used in method berechne.
     */
    public Addition(double value)
    {
        this.addV = value;      //Setzt den zu addierenden Wert auf den uebergebenen 
    }

    /**
     * Adds the value held in addV to any supplied double value
     * 
     * @param x The value to perform the Addition on.
     */
    @Override
    public double berechne(double x)
    {
        return x + addV;    //Gibt x+ addv zurueck
    }

}
