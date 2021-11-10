package abgabe5;

/**
 * This class implements the "Spite" strategy. It imperates that the player will
 * cooperate until the opponent betrays for the first time. After this, the
 * player will continue to betray every turn until the end of the game.
 * 
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */

public class Spite implements GefangenenStrategie
{
    private boolean oppLastDec;
    private boolean lock; // Lock represents the state in which a player betrays out of spite.

    /**
     * Constructor sets the opponents last decision to true as its given that in the
     * first turn both players cooperate.
     *
     * Also the lock attribute is set to false.
     */
    public Spite()
    {
        this.oppLastDec = true;
        this.lock = false;
    }

    /**
     * @return boolean True if the lock attribute is not true.
     */
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        if (!lock)
        {
            decision = true;
        } else
        {
            decision = false;
        }
        return decision;
    }

    /**
     * Sets the oppLastDec (opponents last decision). If the opponents last decision
     * was betrayal, it also sets the lock attribute to true.
     * @param decision
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;
        if (!decision)
        {
            this.lock = true;
        }
    }
}
