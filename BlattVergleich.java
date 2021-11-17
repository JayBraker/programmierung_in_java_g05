package abgabe6;

import java.util.Comparator;

public class BlattVergleich implements Comparator<Blatt>
{

    /**
    * This methode compares the two hands of the players and decides on who wins.
    * Condition are as followed: 
    *   Three-of-a-kind beats pair, pair beats completely different cards.
    *   With 2 triplets or pairs, the one with the higher value counts.
    *   If there are 2 pairs of the same value, the 3rd card counts.
    *   If the cards are completely different, the sum of the three cards counts.
    * @param o1 Object of the class Blatt.
    * @param o2 Object of the class Blatt.
    * @returns int Returns 1 if o1's value is higher, 0 if their values are equal, -1 if o2's value is higher.
    /*
    
    @Override
    public int compare(Blatt o1, Blatt o2)
    {
        if (o1.isDrilling() && o2.isDrilling())     // wenn beide Spieler ein Drilling haben
        {
            if (o1.getDrillingValue() < o2.getDrillingValue())      // wenn Spieler 2 eine hoeherwertige hand hat, gewinnt dieser
            {
                return -1;
            } else if (o1.getDrillingValue() == o2.getDrillingValue())   // wenn beide spieler die gleiche hand haben, ist es unentschieden
            {
                return 0;
            } else                                               // wenn Spieler 1 eine hoeherwertige hand hat, gewinnt dieser
            {
                return 1;
            }
        } else if (o1.isZwilling() && o2.isZwilling())  // andernfalls checke auf ein paar
        {
            if (o1.getZwillingValue() < o2.getZwillingValue())      // wenn Spieler 2 eine hoeherwertige hand hat, gewinnt dieser
            {
                return -1;
            } else if (o1.getZwillingValue() > o2.getZwillingValue())     // wenn Spieler 1 eine hoeherwertige hand hat, gewinnt dieser
            {
                return 1;
            } else if (o1.getThirdCard() < o2.getThirdCard())           // wenn die dritte karte von Spieler 2 hoeherwertig ist, gewinnt dieser
            {
                return -1;
            } else if (o1.getThirdCard() > o2.getThirdCard())           // wenn die dritte karte von Spieler 2 hoeherwertig ist, gewinnt dieser
            {
                return 1;
            } else                                                      //wenn die karten gleich sind, ist es ein unentschieden
            {
                return 0;
            }
        } else if (o1.isDrilling() && o2.isZwilling())                  // wenn Spieler 1 ein Drilling und Spieler 2 keinen hat, gewinnt Spieler 1
        {
            return 1;
        } else if (o1.isZwilling() && o2.isDrilling())                  // wenn Spieler 2 ein Drilling und Spieler 1 keinen hat, gewinnt Spieler 2
        {
            return -1;
        } else if ((o1.isZwilling() || o1.isDrilling())                 // wenn Spieler 1 ein Drilling oder ein paar hat und Spieler 2 nichts  hat, gewinnt Spieler 1
                && !(o2.isZwilling() || o2.isDrilling()))
        {
            return 1;
        } else if (!(o1.isZwilling() || o1.isDrilling())                // wenn Spieler 2 ein Drilling oder Paar hat und Spieler 1 nichts  hat, gewinnt Spieler 2
                && (o2.isZwilling() || o2.isDrilling()))
        {
            return 1;
        } else                                                          // wenn es bei beiden untercshiedliche karten sind, dann hol die summe
        {
            if (o1.getSum() < o2.getSum())          // wenn die summe der karten von Spieler 2 groeßer ist, dann gewinnt dieser
            {
                return -1;
            } else if (o1.getSum() > o2.getSum()) // wenn die summe der karten von Spieler 1 groeßer ist, dann gewinnt dieser
            {
                return 1;
            } else                          // wenn die summe der karten von Spieler 1 und Spieler 2 gleich groß sind, dann ist es unentschieden
            {
                return 0;
            }
        }
    }
}
