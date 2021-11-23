package Java_HA7;

public class Schiebepuzzle {
  /** Feld represents the board in Rows and columns. */
  int[][] feld;

  umliegendeFelder closeFelder;
  int[] arrayMitVerschiebbarenZahlen;

  /**
   * Default constructor initializes feld as an 2-d array of length 4x4. Fills the array with the
   * perfect solution to ensure any derivation of this field remains solvable.
   */
  public Schiebepuzzle() {
    int[][] feld = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 0}
    };
    this.feld = feld;
  }

  /**
   * This methode moves the number to the empty space next to it.
   *
   * @param i
   */
  public void schiebe(int i) {
    // Diese Methode schiebt das Plaettchen mit der Nummer i auf den freien Platz.

    if (!istVerschiebbar(i)) // Wenn istVerschiebbar false zurueckgibt
    {
      throw new WrongMoveException("Das Plaettchen ist nicht verschiebbar!");
    }
  }

  /**
   * Checks if there is an empty Space around the given number if not it returns false
   *
   * @param i
   * @return true or false if the number is in the array of verschiebbar
   */
  public boolean istVerschiebbar(int i) {
    boolean verschiebbar = false;
    int[] pos = getPosZahl(0);
    getVerschiebbareZahlen(pos);

    for (int z = 0; z < arrayMitVerschiebbarenZahlen.length; z++) {
      if (arrayMitVerschiebbarenZahlen[z] == i) {
        verschiebbar = true;
        break;
      }
    }
    return verschiebbar;
  }

  /**
   * This method looks which numbers are next to the given position and saves it. For that, it gives
   * closeFelder the position of the number and the current feld
   *
   * @param pos position of the number saved as array [row,colum].
   */
  private void getVerschiebbareZahlen(int[] pos) {
    closeFelder = new umliegendeFelder(pos, feld);
    arrayMitVerschiebbarenZahlen = closeFelder.getFelder();
  }

  /**
   * this method looks up if the number given is in the array and returns its position as int[]
   *
   * @param n the number to be searched for
   * @return the position of the number as int[]
   */
  private int[] getPosZahl(int n) {
    int[] temp = {0, 0};
    for (int y = 0; y < feld.length; y++) {
      for (int x = 0; x < (feld[y].length); x++) {
        if (feld[y][x] == n) // wenn zahl gefunden
        {
          temp[0] = y;
          temp[1] = x;
        }
      }
    }
    return temp;
  }

  public void mische() {
    /*
     * Diese Methode mischt das Spiel, indem sie 100 zufaellige (gueltige) Zuege
     * vornimmt. Anmerkung: Diese Methode garantiert, dass das Puzzle immer loesbar
     * ist. Wenn man die Plaettchen einfach zufaellig anordnet, ist das nur mit
     * einer Wahrscheinlichkeit von 50 % der Fall
     */

  }
}
