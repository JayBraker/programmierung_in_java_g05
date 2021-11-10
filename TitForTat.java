package abgabe5;

public class TitForTat implements GefangenenStrategie
{
    private boolean oppLastDec;

    public TitForTat()
    {
        this.oppLastDec = true;
    }

    @Override
    public boolean getNextDecision()
    {
        return oppLastDec;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;

    }

}
