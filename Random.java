package abgabe5;

/**
 * This class implements the "Random" strategy. It determines the next decision
 * by pseudorandomly choosing between betrayal and cooperation.
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class Random implements GefangenenStrategie
{
    private boolean oppLastDec;
    private java.util.Random rand;

    /**
     * 
     */
    public Random()
    {
        this.rand = new java.util.Random(); // generiert zufaellig einen true oder false wert
        this.oppLastDec = true;
    }

    /**
     * This methode gets the new decision of a player
     * 
     * @return boolean if he should cooperate (true) or not (false)
     */
    @Override
    public boolean getNextDecision()
    {
        return rand.nextBoolean(); // generiert zufaellig einen neuen true oder false wert für die naechste
                                   // entscheidung
    }

    /**
     * @param boolean the decision of the opponent
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision; // speichert die entscheidung des gegners
    }

}
