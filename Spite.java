package abgabe5;

public class Spite implements GefangenenStrategie
{
    private boolean oppLastDec;
    private boolean lock;

    /**
     * 
     */
    public Spite()
    {
        this.oppLastDec = true;
        this.lock = false;
    }
    
    /**
     *
     */
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        if (!lock) {
            decision = true;
        } else {
            decision = false;
        }
        return decision;
    }

    /**
     *
     */
    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;
        if (!decision) {
            this.lock = true;
        }
        
    }

}
