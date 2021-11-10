package abgabe5;

/**
 * This class implements the "Per Kind" strategy. It imperates that the player
 * will base his decisions on a periodic pattern. He will cooperate on the first
 * two turns, then betray in the third turn. This pattern repeats until the game
 * ends.
 * 
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class PerKind implements GefangenenStrategie
{
    private boolean oppLastDec;
    private int kindCount;

    /**
     * When initialized, the strategy assumes that a first kind action is performed
     * without consulting the strategy. Usually kindCount would be set 0 on
     * initialization but as the first turn is not determined by strategies we must
     * acknowledge that the player has performed one kind action without consulting
     * this strategy.
     */
    public PerKind()
    {
        this.kindCount = 1;
    }

    /**
     * The decision is based on the amount of turns in which the player cooperated.
     * If he has counted less than two cooperations, he will cooperate in this turn
     * but if he already cooperated 2 times in a row, he will betray and reset his
     * counter so he again will cooperate in the next two turns.
     *
     * @return boolean The decision based on "PerKind" Strategem.
     */
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        if (kindCount < 2)
        {
            decision = true;
            kindCount++;
        } else
        {
            decision = false;
            kindCount = 0;
        }
        return decision;
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
