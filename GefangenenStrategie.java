package abgabe5;

public interface GefangenenStrategie
{
    /**
     * @return
     */
    boolean getNextDecision();
    /**
     * @param decision
     */
    void setOpponentsLastDecision(boolean decision);
}
