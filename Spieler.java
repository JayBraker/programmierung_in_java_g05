package abgabe5;

public class Spieler
{
    private final GefangenenStrategie strategie;
    private final String name;

    private int strafpunkte;

    /**
     * @param name
     * @param strats
     */
    public Spieler(String name, GefangenenStrategie strats)
    {
        this.strategie = strats;
        this.name = name;
        this.strafpunkte = 0;
    }

    /**
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return
     */
    public int getStrafpunkte()
    {
        return this.strafpunkte;
    }

    /**
     * @return
     */
    public boolean getNextMove()
    {
        return this.strategie.getNextDecision();
    }

    /**
     * @param decision
     */
    public void setOpponentsLastDecision(boolean decision)
    {
        this.strategie.setOpponentsLastDecision(decision);
    }

    /**
     * @param count
     */
    public void addStrafpunkte(int count)
    {
        this.strafpunkte += count;
    }
}
