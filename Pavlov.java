package abgabe5;

/**
 * This class implements the "Pavlov" strategy.
 * It imperates that the player will cooperate if his action in the last turn matched the action of his opponent.
 * Otherwise if their actions differed, he will betray in the current turn.
 * 
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class Pavlov implements GefangenenStrategie
{
    /*
     * To compare his own actions to those of his opponent,
     * the pavlovian player must remember his last action in addition to his opponents last action.
     */
    private boolean oppLastDec;
    private boolean ownLastDec;

    /**
     * Pavlovs decisionmaking compares the last performed actions of both players,
     * if these match, he will cooperate, otherwise he will betray.
     * He also must save this decision for the next turn.
     *
     * @return boolean The decision based upon Pavlov strategy.
     */
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        if (this.oppLastDec == this.ownLastDec) {
            decision = true;
        } else {
            decision = false;
        }
        
        this.ownLastDec = decision;
        return false;
    }

    /**
     * Receive information on the opponents action during the last turn.
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;
    }

}
