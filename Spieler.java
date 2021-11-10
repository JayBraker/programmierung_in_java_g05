package abgabe5;

/**
 * This class implements a participating player. It gets a GefangenenStrategie
 * on initialization and provides information to the Strategies implementation.
 * The player also queries the strategy for a decision on the current turn.
 * 
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class Spieler
{
    private final GefangenenStrategie strategie;
    private final String name;

    private int strafpunkte;

    /**
     * @param name The player receives a name to be displayed at the end of the
     * game.
     * @param strats The player receives a strategy implementation.
     */
    public Spieler(String name, GefangenenStrategie strats)
    {
        this.strategie = strats;
        this.name = name;
        this.strafpunkte = 0;
    }

    /**
     * @return String Gives the players name.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return int Gives the amount of Strafpunkte the player accumulated.
     */
    public int getStrafpunkte()
    {
        return this.strafpunkte;
    }

    /**
     * @return boolean Returns the next Decision as imperated by the strategy.
     */
    public boolean getNextMove()
    {
        return this.strategie.getNextDecision();
    }

    /**
     * @param decision Provides the strategy with the opponents last decision.
     */
    public void setOpponentsLastDecision(boolean decision)
    {
        this.strategie.setOpponentsLastDecision(decision);
    }

    /**
     * @param count Adds a given amount of Strafpunkte to the counter.
     */
    public void addStrafpunkte(int count)
    {
        this.strafpunkte += count;
    }
}
