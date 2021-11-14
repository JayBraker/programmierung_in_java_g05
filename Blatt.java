package abgabe6;

import java.util.Arrays;
import java.util.Collections;

public class Blatt
{
    private int[] blatt;
    private int[] verteilung;

    public Blatt(int[] blatt)
    {
        if (blatt.length == 3)
        {
            this.blatt = blatt;
        } else
        {
            throw new ArithmeticException("Ungültige Größe des Blatt");
        }
        zaehlAus();
    }

    public String toString()
    {
        return Arrays.toString(this.blatt);
    }

    public int[] getBlatt()
    {
        return this.blatt;
    }

    public void zaehlAus()
    {
        this.verteilung = new int[13];
        for (int wert : this.blatt)
        {
            verteilung[wert - 2] += 1;
        }
    }

    public boolean isDrilling()
    {
        for (int anzahl : this.verteilung)
        {
            if (anzahl == 3)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isZwilling()
    {
        for (int anzahl : this.verteilung)
        {
            if (anzahl == 2)
            {
                return true;
            }
        }
        return false;
    }

    public int getDrillingValue()
    {
        if (isDrilling())
        {
            for (int i = 0; i < verteilung.length; i++)
            {
                if (verteilung[i] == 3)
                {
                    return i + 2;
                }
            }
        }
        throw new ArithmeticException("Blatt enthält kein Drilling!");
    }

    public int getZwillingValue()
    {
        if (isZwilling())
        {
            for (int i = 0; i < verteilung.length; i++)
            {
                if (verteilung[i] == 2)
                {
                    return i + 2;
                }
            }
        }
        throw new ArithmeticException("Blatt enthält kein Zwilling!");
    }

    public int getThirdCard()
    {
        if (isZwilling())
        {
            for (int i = 0; i < verteilung.length; i++)
            {
                if (verteilung[i] != 0 && verteilung[i] != 2)
                {
                    return i + 2;
                }
            }
        }
        throw new ArithmeticException("Blatt enthält kein Zwilling!");
    }

    public int getSum() {
        return blatt[0]+blatt[1]+blatt[2];
    }
    
    public int getMaxWert()
    {
        int[] ret = blatt.clone();
        Arrays.sort(ret);
        return ret[-1];
    }
}
