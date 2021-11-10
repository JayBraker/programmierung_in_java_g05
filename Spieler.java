package abgabe5;

public class Spieler
{
    private final GefangenenStrategie strategie;
    private final String name;

    private int strafpunkte;

    public Spieler(String name, GefangenenStrategie strats)
    {
        this.strategie = strats;
        this.name = name;
        this.strafpunkte = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public int getStrafpunkte()
    {
        return this.strafpunkte;
    }

    public boolean getNextMove()
    {
        return this.strategie.getNextDecision();
    }

    public void setOpponentsLastDecision(boolean decision)
    {
        this.strategie.setOpponentsLastDecision(decision);
    }

    public void addStrafpunkte(int count)
    {
        this.strafpunkte += count;
    }
}
