package abgabe5;

public class DasSpiel
{
    public static void main(String[] args)
    {
        // Neues Objekt vom GefangenenDilemma mit 2 Spielern
        GefangenenDilemma gd = new GefangenenDilemma(new TitForTat(),
                new PerKind());

        // 199 mal spielen
        gd.spiele(100);
    }
}
