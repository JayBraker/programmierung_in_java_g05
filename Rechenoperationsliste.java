package abgabe4;

import java.util.ArrayList;

public class Rechenoperationsliste
{
    private final ArrayList<Rechenoperation> ops;

    public interface Rechenoperation
    {
        double berechne(double x);
    }

    public Rechenoperationsliste()
    {
        this.ops = new ArrayList<Rechenoperation>();
    }

    public void add(Rechenoperation operation)
    {
        ops.add(operation);
    }
    
    public ArrayList<Rechenoperation> getList(){
        return this.ops;
    }

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
