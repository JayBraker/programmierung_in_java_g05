package abgabe6;

import java.util.Arrays;

public class Blatt
{

    private final int[] DECK =
    { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    private int[] blatt = new int[3];
    private int[] verteilung;
    /**
	 * This method looks if the given parameter values are in the deck, if thats the case it will set the Card.
	 * if not, it will throw an IllegalArgumentExcpetion.
	 * 
	 * @param dreiKarten
	 * @throws IllegalArgumentException 
	 */
    public Blatt(int[] dreiKarten) throws IllegalArgumentException		// uebergebe 3 karten
	{
		for (int i = 0; i < DECK.length; i++)							// solange es im bereich des kartendecks ist.
			for (int j = 0; j < dreiKarten.length; j++)				    // solange <=3 (hand groeße)
			{
				if (DECK[i] == dreiKarten[j])							// ist der Wert im Kartendeck
				{
					this.blatt[j] = dreiKarten[j];						// setzt die karte 
				}
			}
        zaehlAus();
	}
    
    /**
	 * Returns the Value of the Cards as String.
	 * @return String the values of the cards
	 */
    public String toString()    
    {
        return String.format("%d, %d, %d ", blatt[0], blatt[1], blatt[2]);
    }

     /**
	 * Returns the Value of the hand
	 * @return int[] the hand
	 */
    public int[] getBlatt()
    {
        return this.blatt;
    }

     /**
	 * Gives the players 3 random cards between 2 and 14
	 * 
	 */
    public void zaehlAus()
    {
        this.verteilung = new int[13];
        for (int wert : this.blatt)
        {
            verteilung[wert - 2] += 1;
        }
    }

     /**
	 *  Checks if the Cards are Drillings
	 * @return boolean if it is a drilling or not
	 */
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

     /**
	 * Checks if the Cards are zwillings
	 * @return String the value of the card
	 */
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

     /**
	 * gets the Drilling Value
	 * @return int the value of the card
	 */
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

     /**
	 * gets the Zwilling paar
	 * @return int the values of the cards
	 */
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

     /**
	 * Gets the third Card
	 * @return int the value of the card
	 */
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

     /**
	 * gets the sum
	 * @return int the sum
	 */
    public int getSum()
    {
        return blatt[0] + blatt[1] + blatt[2];
    }

     /**
	 * Returns the Max value of all the Crads you have
	 * @return String the values of the cards
	 */
    public int getMaxWert()
    {
        int[] ret = blatt.clone();
        Arrays.sort(ret);
        return ret[-1];
    }
}
