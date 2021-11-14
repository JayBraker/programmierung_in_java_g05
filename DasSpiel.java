package abgabe5;

public class DasSpiel
{
    public static void main(String[] args)
    {
        // Neues Objekt vom GefangenenDilemma mit 2 Spielern
        GefangenenDilemma gd = new GefangenenDilemma(new TitForTat(),
                new PerKind());

        // 100 mal spielen
        gd.spiele(100);

        GefangenenDilemma gd2 = new GefangenenDilemma(new Prober(),
                new Pavlov());

        gd2.spiele(100);
    }
}jde    oibdjnjnjnnnnnnnnnnnnnnnnnnnnnnnnnn
