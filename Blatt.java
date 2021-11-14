package abgabe6;

import java.util.Arrays;
import java.util.Collections;

private final int[] DECK = {2,3,4,5,6,7,8,9,10,11,12,13,14};
	private int[] blatt = new int[3];
	
	public Blatt(int [] dreiKarten) throws IllegalArgumentException {
		for( int i=0; i<= DECK.length; i++)
			for( int j=0; j<=dreiKarten.length; j++) {
				if(DECK[i]==dreiKarten[j]) {
					this.blatt[j]=dreiKarten[j];
				}
			}
		}
        zaehlAus();
    }

    public String toString()
    {
        return String.format("%d ,%d, %d ", blatt[0],blatt[1],blatt[2]) ;
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
