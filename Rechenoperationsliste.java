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
        this.ops = new ArrayList<Rechenoperation>();
    }

    /**
     * Add a new object implementing Rechenoperation to the internal ArrayList. 
     * 
     * @param operation Object must be an implementation of Rechenoperation interface.
     */
    public void add(Rechenoperation operation)
    {
        ops.add(operation);
    }
    
    /** 
     * @return Returns the ArrayList.
     */
    public ArrayList<Rechenoperation> getList(){
        return this.ops;
    }

    /**
     * Calling this method implies that at least one Rechenoperation was added beforehand.
     * his method applies every single operation that was added to every element of the supplied Array. 
     * 
     * @param feld Array containing any number of double values.
     * @return Array of the same size as feld, but every element was is transformed according to the Rechenoperationen added.
     */
    public double[] transform(double[] feld)
    {
        double[] ret = feld.clone();

        for (Rechenoperation operation : ops)
        {
            for (int i = 0; i < feld.length; i++)
            {
                double x = ret[i];
                x = operation.berechne(x);
                ret[i] = x;
            }
        }
        return ret;
    }
}
