package abgabe4;

import java.util.Arrays;

public class Test
{
    public static void main(String[] args)
    {
        double[] ausgangsFeld =
        { 1, 3, 5, 6 };
        Rechenoperationsliste r = new Rechenoperationsliste();
        // Berechnet die Funktion (x^2)+2
        r.add(new Quadrat());
        r.add(new Addition(2));
        // Berechnet und Ausgabe
        double[] test1 = r.transform(ausgangsFeld);
        // ergibt {3, 11, 27, 38}
        System.out.println(Arrays.toString(test1));

        // Fuegt der Rechenoperationsliste eine weitere Rechenoperation hinzu
        // und berechnet daher insgesamt Math.sqrt((x^2)+2)

        r.add(new QuadratWurzel());
        // Berechnung und Ausgabe
        double[] test2 = r.transform(ausgangsFeld);

        System.out.println(r.getList());
        System.out.println(Arrays.toString(test2));
    }
}
