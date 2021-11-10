package abgabe5;

/**
 * This class implements the "Tit For Tat" strategy. It imperates that the
 * player will base his decisions on his opponents last decision. He uses the
 * information on which decision his opponent made in the last turn and copies
 * this decision in the current turn.
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class TitForTat implements GefangenenStrategie
{
    private boolean oppLastDec;

    /**
     * @return boolean The strategy returns the last known decision of the opponent.
     */
    @Override
    public boolean getNextDecision()
    {
        return oppLastDec;
    }

    /**
     * Saves the opponents last decision.
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;

    }

}
