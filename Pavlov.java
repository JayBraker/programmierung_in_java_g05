package abgabe5;

public class Pavlov implements GefangenenStrategie
{
    private boolean oppLastDec;
    private boolean ownLastDec;

    /**
     * 
     */
    public Pavlov()
    {
        this.oppLastDec = true;
        this.ownLastDec = true;
    }
    
    /**
     *
     */
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        /*
         * 
         */
        if (this.oppLastDec == this.ownLastDec) {
            decision = true;
        } else {
            decision = false;
        }
        
        this.ownLastDec = decision;
        return false;
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
