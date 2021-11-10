package abgabe5;

public class Random implements GefangenenStrategie
{
    private boolean oppLastDec;
    private java.util.Random rand;

    /**
     * 
     */
    public Random()
    {
        this.rand = new java.util.Random();
        this.oppLastDec = true;
    }

    /**
     *
     */
    @Override
    public boolean getNextDecision()
    {
        return rand.nextBoolean();
    }

    /**
     *
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;

    }

}
