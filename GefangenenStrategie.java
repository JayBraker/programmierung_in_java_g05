package abgabe5;

/**
 * This interface describes a blueprint for every possible strategy. Each
 * strategy must at least implement the methods getNextDecision and
 * setOpponentsLastDecision.
 *
 * Decisions are represented by boolean. The decision to cooperated is
 * represented by true and betrayal is represented by false.
 * 
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public interface GefangenenStrategie
{
    /**
     * This method must return the players next move (decision): Will he betray or
     * cooperate with his opponent?
     *
     * @return boolean Decision based on an implemented strategy.
     */
    boolean getNextDecision();

    /**
     * This method provides the strategy the possibility to use the opponents last
     * decision in its own decision making. It is called by the game master on the
     * start of every turn and is provided the opponents decision in the last turn.
     *
     * @param decision The opponents decision during the last turn.
     */
    void setOpponentsLastDecision(boolean decision);
}
