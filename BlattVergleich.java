package abgabe6;

import java.util.Comparator;

/**
 * This class implements the comparator for objects of Blatt. It checks the value of two decks of
 * cards according the following demands:
 *
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 */
public class BlattVergleich implements Comparator<Blatt> {

  /**
   * It checks the value of two decks of cards according the following demands:
   *
   * <p>"Drilling schlägt Paar, Paar schlägt komplett unterschiedliche Karten. Bei 2 Drillingen bzw.
   * Paaren zählt das mit dem höheren Wert. Bei 2 Paaren mit gleichem Wert zählt die 3. Karte. Bei
   * komplett unterschiedlichen Karten zählt die Summe der drei Karten."
   *
   * @param o1 Object of the class Blatt.
   * @param o2 Object of the class Blatt.
   * @returns int Returns 1 if o1's value is higher, 0 if their values are equal, -1 if o2's value
   *     is higher.
   */
  @Override
  public int compare(Blatt o1, Blatt o2) {
    if (o1.isDrilling() && o2.isDrilling()) {
      if (o1.getDrillingValue() < o2.getDrillingValue()) {
        return -1;
      } else if (o1.getDrillingValue() == o2.getDrillingValue()) {
        return 0;
      } else {
        return 1;
      }
    } else if (o1.isZwilling() && o2.isZwilling()) {
      if (o1.getZwillingValue() < o2.getZwillingValue()) {
        return -1;
      } else if (o1.getZwillingValue() > o2.getZwillingValue()) {
        return 1;
      } else if (o1.getThirdCard() < o2.getThirdCard()) {
        return -1;
      } else if (o1.getThirdCard() > o2.getThirdCard()) {
        return 1;
      } else {
        return 0;
      }
    } else if (o1.isDrilling() && o2.isZwilling()) {
      return 1;
    } else if (o1.isZwilling() && o2.isDrilling()) {
      return -1;
    } else if ((o1.isZwilling() || o1.isDrilling()) && !(o2.isZwilling() || o2.isDrilling())) {
      return 1;
    } else if (!(o1.isZwilling() || o1.isDrilling()) && (o2.isZwilling() || o2.isDrilling())) {
      return 1;
    } else {
      if (o1.getSum() < o2.getSum()) {
        return -1;
      } else if (o1.getSum() > o2.getSum()) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
