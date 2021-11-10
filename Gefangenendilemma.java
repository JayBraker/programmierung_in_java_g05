package abgabe5;

public class GefangenenDilemma
{
    private final Spieler sp1;
    private final Spieler sp2;

    /**
     * @param strategie1
     * @param strategie2
     */
    public GefangenenDilemma(GefangenenStrategie strategie1,
            GefangenenStrategie strategie2)
    {
        sp1 = new Spieler("Josha", strategie1);
        sp2 = new Spieler("Mitja", strategie2);
    }

    /**
     * @param n
     */
    public void spiele(int n)
    {
        Spieler winner = null;

        /*
         * The first turn is always cooperation by both players.
         */
        
        sp1.addStrafpunkte(2);
        sp2.addStrafpunkte(2);
        sp1.setOpponentsLastDecision(true);
        sp2.setOpponentsLastDecision(true);
        
        for (int i = 0; i < n-1; i++) // n-1 as the first turn was predetermined!
        {
            boolean move1 = sp1.getNextMove();
            boolean move2 = sp2.getNextMove();

            if (move1 && move2)
            {
                sp1.addStrafpunkte(2);
                sp2.addStrafpunkte(2);
            } else if (!move1 && !move2)
            {
                sp1.addStrafpunkte(4);
                sp2.addStrafpunkte(4);
            } else if (!move1 && move2)
            {
                sp1.addStrafpunkte(1);
                sp2.addStrafpunkte(6);
            } else if (move1 && !move2)
            {
                sp1.addStrafpunkte(6);
                sp2.addStrafpunkte(1);
            }
            sp1.setOpponentsLastDecision(move2);
            sp2.setOpponentsLastDecision(move1);
        }
        /*
         * 
         */
        if (sp1.getStrafpunkte() < sp2.getStrafpunkte())
        {
            winner = sp1;
        } else if (sp1.getStrafpunkte() > sp2.getStrafpunkte())
        {
            winner = sp2;
        }

        /*
         * 
         */
        System.out.println("Das Spiel ist aus!");
        if (winner != null)
        {
            System.out.printf("Spieler %s hat das Spiel gewonnen!\n",
                    winner.getName());
        } else
        {
            System.out.println(
                    "Keiner der Spieler konnte das Spiel für sich entscheiden.\nBeide Spieler erhielten gleichviele Strafpunkte:");
        }
        System.out.printf("Spieler 1 (\"%s\"): %16d\n", sp1.getName(),
                sp1.getStrafpunkte());
        System.out.printf("Spieler 2 (\"%s\"): %16d\n", sp2.getName(),
                sp2.getStrafpunkte());
    }
}
