package abgabe5;

/**
 * This class implements the "Prober" strategy. It imperates that the player
 * will play the first 3 turns: Cooperate, Betray, Betray. If the opponent
 * played cooperate on the previous two turns, the player will now resort to
 * betray in every turn.
 * 
 * If the opponent did not cooperate in at least one of the previous two turns,
 * the Prober uses TitForTat for the remaining turns.
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class Prober implements GefangenenStrategie
{
    /**
     * The Prober strategy relies on two factors: Will the opponent cooperate on the
     * first two betrayals or not? Therefore the Prober uses two locks to remember
     * if the opponent cooperated on the 2nd and 3rd turn.
     * 
     * He also uses turnCount to only check the locks once after turn 3. The
     * GefangenenStrategie TitForTat is consulted for decision making if the two
     * locks were not set false within turn 2 and 3.
     */
    private boolean lock1;
    private boolean lock2;
    private int turnCount;
    GefangenenStrategie tit;

    public Prober()
    {
        this.lock1 = false;
        this.lock2 = false;
        this.turnCount = 1; // Turn 1 because turn 0 is executed without consulting the strategy.
    }

    /**
     * Returns false on turn 2 and 3 (first 2 turns this method is used anyway). If
     * lock2 was not set true, uses TitForTat to determine decision. If lock2 was
     * set true, returns false for the remainder of the game.
     * 
     * @return boolean Decision based on the Prober strategy.
     */
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        if (turnCount < 3) // Betray on turn 2 and 3.
        {
            decision = false;
        } else if (!lock2) // Fall back to TitForTat if !lock2 after 3rd turn.
        {
            decision = tit.getNextDecision();
        } else // Always betray after turn 3 if lock2 is set true.
        {
            decision = false;
        }
        turnCount++; // Raise turn counter as this is the last execution before new turn begins.
        return decision;
    }

    /**
     * Receives the opponents last decision. Determines whether the opponent
     * cooperated on turn 2 and 3 and sets the locks ackordingly. If lock2 was not
     * engaged in turn 3, it initializes TitForTat so the call to getNextDecision
     * this turn is successfully passed to the TitForTat strategy.
     * 
     * @param decision The opponents last decision
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        if (turnCount < 3) // On turns 2 and 3 check whether to engage lock1 and lock2.
        {
            if (decision && !lock1)
            {
                this.lock1 = true; // If the opponent cooperated and lock1 was not engaged, engage lock1.
            } else if (decision && lock1 && !lock2)
            {
                this.lock2 = true; // If the opponent cooperated and lock1 is already engaged, engage lock2.
            }
        } else if (!lock2) // After turn 3, iflock2 was not engaged initialize TitForTat strategy and pass
                           // opponents last decision.
        {
            if (this.tit == null)
            {
                this.tit = new TitForTat();
            }
            tit.setOpponentsLastDecision(decision);
        }

    }

}
