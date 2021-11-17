package abgabe6;

import java.util.Arrays;

/** @author Selina Fiorin, Martin Albertz, Josha Bartsch */
public class Blatt {

  private final int[] DECK = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
  private int[] blatt = new int[3];
  private int[] verteilung;

  /**
   * The constructor takes an int array containing exactly 3 integers in the range of 2 to 14.
   *
   * @param dreiKarten Integer Array containing three cards represented by their numeric value.
   * @throws IllegalArgumentException if the Array does not meet expected criteria.
   */
  public Blatt(int[] dreiKarten) throws IllegalArgumentException {
    for (int i = 0; i < DECK.length; i++)
      for (int j = 0; j < dreiKarten.length; j++) {
        if (DECK[i] == dreiKarten[j]) {
          this.blatt[j] = dreiKarten[j];
        }
      }
    zaehlAus();
  }

  /** @returns String Values of the three cards, comma seperated. */
  public String toString() {
    return String.format("%d, %d, %d", blatt[0], blatt[1], blatt[2]);
  }

  /** @returns int[] Deck of 3 cards represented by this class. */
  public int[] getBlatt() {
    return this.blatt;
  }

  /**
   * Counts the number of occurances of every card in the blatt attribute, saves the counts in the
   * attribute verteilung, length 13. The index of verteilung + 2 is mapped to the value of each
   * card.
   */
  public void zaehlAus() {
    this.verteilung = new int[13];
    for (int wert : this.blatt) {
      verteilung[wert - 2] += 1;
    }
  }

  /** @returns boolean Checks whether any card in blatt is contained thrice. */
  public boolean isDrilling() {
    for (int anzahl : this.verteilung) {
      if (anzahl == 3) {
        return true;
      }
    }
    return false;
  }

  /** @returns boolean Checks whether any card in blatt is contained twice. */
  public boolean isZwilling() {
    for (int anzahl : this.verteilung) {
      if (anzahl == 2) {
        return true;
      }
    }
    return false;
  }

  /**
   * @returns boolean The value of the card contained thrice.
   * @throws ArithmeticException if no card is contained thrice.
   */
  public int getDrillingValue() {
    if (isDrilling()) {
      for (int i = 0; i < verteilung.length; i++) {
        if (verteilung[i] == 3) {
          return i + 2;
        }
      }
    }
    throw new ArithmeticException("Blatt enthält kein Drilling!");
  }

  /**
   * @returns int The value of the card contained twice.
   * @throws ArithmeticException if no card is contained twice.
   */
  public int getZwillingValue() {
    if (isZwilling()) {
      for (int i = 0; i < verteilung.length; i++) {
        if (verteilung[i] == 2) {
          return i + 2;
        }
      }
    }
    throw new ArithmeticException("Blatt enthält kein Zwilling!");
  }

  /**
   * @returns int The value of the third card in blatt if there also is a pair of the same value.
   * @throws ArithmeticException If no card is contained thrice.
   */
  public int getThirdCard() {
    if (isZwilling()) {
      for (int i = 0; i < verteilung.length; i++) {
        if (verteilung[i] != 0 && verteilung[i] != 2) {
          return i + 2;
        }
      }
    }
    throw new ArithmeticException("Blatt enthält kein Zwilling!");
  }

  /** @returns int The sum of values of all cards in blatt.. */
  public int getSum() {
    return blatt[0] + blatt[1] + blatt[2];
  }

  /** @returns int THe value of the highest card in blatt. */
  public int getMaxWert() {
    int[] ret = blatt.clone();
    Arrays.sort(ret);
    return ret[-1];
  }
}
