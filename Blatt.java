package abgabe6;

import java.util.Arrays;

public class Blatt
{

    private final int[] DECK =
    { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    private int[] blatt = new int[3];
    private int[] verteilung;
    /**
	 * The constructor checks the parameter values for validity and saves them in blatt.
	 * The parameter must contain 3 integers, each in the range of 2 to 14.
	 * If not, it will throw an IllegalArgumentExcpetion.
	 * 
	 * @param dreiKarten Int Array containing 3 ints representing card values.
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
     * Returns a String representation of blatt.
     * @return String
     */
    public String toString()    
    {
        return String.format("%d, %d, %d ", blatt[0], blatt[1], blatt[2]);
    }

     /**
	 * Returns the value of the hand
	 * @return int[] the hand
	 */
    public int[] getBlatt()
    {
        return this.blatt;
    }
    
    /**
     * Counts the number of occurances of every card in the blatt attribute,
     * saves the counts in the attribute verteilung, length 13.
     * The index of verteilung + 2 is mapped to the value of each card.
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
	 * Checks if the deck contains three of a kind.
	 * @return boolean Deck contains three of a kind
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
	 * Checks if the deck contains two of a kind
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
      * Returns the value of the card contained thrice.	 
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
	 * Returns the value of the card contained twice.
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
	 * Returns the value of the third card in the deck if it also contains a two of a kind.
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
	 * Gets the sum of all cards values.
	 * @return int
	 */
    public int getSum()
    {
        return blatt[0] + blatt[1] + blatt[2];
    }

     /**
	 * Returns the value of the highest card in blatt.
	 * @return String the values of the cards
	 */
    public int getMaxWert()
    {
        int[] ret = blatt.clone();
        Arrays.sort(ret);
        return ret[-1];
    }
}
