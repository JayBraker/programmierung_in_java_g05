package abgabe5;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class GefangenenDilemma
{
    private final Spieler sp1;
    private final Spieler sp2;

    /**
     * @param strategie1 Strategy for player 1.
     * @param strategie2 Strategy for player 2.
     */
    public GefangenenDilemma(GefangenenStrategie strategie1,
            GefangenenStrategie strategie2)
    {
        sp1 = new Spieler("Josha", strategie1); // legt den Spieler 1 und siene Strategie fest
        sp2 = new Spieler("Mitja", strategie2); // legt den Spieler 1 und siene Strategie fest
    }

    /**
     * This Method is responsible to give the Players their points, check who has
     * less points and who in the end won. if a players move is set to true it mean
     * he cooperated if set to false then he betrayed.
     * 
     * @param n The numbers of Games that are Played
     * 
     */
    public void spiele(int n)
    {
        Spieler winner = null;
        boolean verbose = true;
        /*
         * The first turn is always a cooperation by both players.
         */

        sp1.addStrafpunkte(2); // Gibt Spieler 1 zwei Strafpunkte
        sp2.addStrafpunkte(2); // Gibt Spieler 2 zwei Strafpunkte
        sp1.setOpponentsLastDecision(true); // Spieler 1 merkt sich die letzte entscheidung von Spieler 1
        sp2.setOpponentsLastDecision(true); // Spieler 2 merkt sich die letzte entscheidung von Spieler 1

        for (int i = 1; i < n; i++) // i starts at 1 as the first turn was predetermined!
        {
            boolean move1 = sp1.getNextMove(); // Schaut nach was der erste Spieler
            boolean move2 = sp2.getNextMove();

            if (move1 && move2)
            { // Kooperieren beide Spieler, erhalten beide 2 Strafpunkte.
                sp1.addStrafpunkte(2);
                sp2.addStrafpunkte(2);
            } else if (!move1 && !move2)
            { // Betrügen beide Spieler, erhalten beide 4 Strafpunkte
                sp1.addStrafpunkte(4);
                sp2.addStrafpunkte(4);
            } else if (!move1 && move2)
            { // Kooperiert ein Spieler und der andere betrügt, so erhält der betrügende
              // Spieler 1 Strafpunkt, der kooperierende erhält 6 Strafpunkte
                sp1.addStrafpunkte(1);
                sp2.addStrafpunkte(6);
            } else if (move1 && !move2)
            { // Kooperiert ein Spieler und der andere betrügt, so erhält der betrügende
              // Spieler 1 Strafpunkt, der kooperierende erhält 6 Strafpunkte
                sp1.addStrafpunkte(6);
                sp2.addStrafpunkte(1);
            }
            sp1.setOpponentsLastDecision(move2); // Spieler 1 merkt sich die letzte entscheidung von Spieler 2
            sp2.setOpponentsLastDecision(move1); // Spieler 2 merkt sich die letzte entscheidung von Spieler 1

            if (verbose)
            {
                System.out.println("Runde " + i);
                System.out.println(
                        "Spieler 1 " + ((move1) ? "kooperiert" : "verr�t"));
                System.out.println(
                        "Spieler 2 " + ((move2) ? "kooperiert" : "verr�t"));
                System.out.println();
            }
        }
        /*
         * This part checks who has won the game, the one with less Starfpunkte wins.
         */
        if (sp1.getStrafpunkte() < sp2.getStrafpunkte())
        {
            winner = sp1; // Spieler 1 gewinnt
        } else if (sp1.getStrafpunkte() > sp2.getStrafpunkte())
        {
            winner = sp2; // Spieler 2 gewinnt
        }

        /*
         * This part determines who has won the game
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
