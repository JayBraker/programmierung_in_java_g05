package abgabe5;

public class PerKind implements GefangenenStrategie
{
    private boolean oppLastDec;
    private int kindCount;
    
    public PerKind()
    {
        this.kindCount = 0;
        this.oppLastDec = true;
    }
    
    @Override
    public boolean getNextDecision()
    {
        boolean decision;
        if (kindCount < 2) {
            decision = true;
            kindCount++;
        } else {
            decision = false;
            kindCount = 0;
        }
        return decision;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision)
    {
        this.oppLastDec = decision;
        
    }

}
