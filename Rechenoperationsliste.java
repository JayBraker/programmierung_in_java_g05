package abgabe4;

import java.util.ArrayList;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public class Rechenoperationsliste
{
    /**
     * Private List ops contains Rechenoperation objects. 
     */
    private final ArrayList<Rechenoperation> ops;

    /**
     * On initialization of the Rechenoperationsliste object, initiate the ArrayList.
     */
    public Rechenoperationsliste()
    {
        this.ops = new ArrayList<Rechenoperation>();    //setzte die Arraylist
    }

    /**
     * Add a new object implementing Rechenoperation to the internal ArrayList. 
     * 
     * @param operation Object must be an implementation of Rechenoperation interface.
     */
    public void add(Rechenoperation operation)
    {
        ops.add(operation);         // ruft die .add funktion für ops auf
    }
    
    /** 
     * @return Returns the ArrayList.
     */
    public ArrayList<Rechenoperation> getList(){
        return this.ops;            // gibt dises ops objekt aus
    }

    /**
     * Calling this method implies that at least one Rechenoperation was added beforehand.
     * this method applies every single operation that was added to every element of the supplied Array. 
     * 
     * @param feld Array containing any number of double values.
     * @return Array of the same size as feld, but every element was is transformed according to the Rechenoperationen added.
     */
    public double[] transform(double[] feld)
    {
        double[] ret = feld.clone();                // klont das feld nach ret

        for (Rechenoperation operation : ops)       // fuer jedes element
        {
            for (int i = 0; i < feld.length; i++)       //solange, wie i < feldgroesse
            {
                double x = ret[i];                  // holt sich den wert an stelle i und speichert diesen in x
                x = operation.berechne(x);          // fuehrt die methode berrechne mit dem x aus und speichert das ergebniss in das x
                ret[i] = x;                         // an stelle i, wird nun das der wert mit x ueberschriben
            }
        }
        return ret;                                 // gibt das ret feld aus
    }
}
