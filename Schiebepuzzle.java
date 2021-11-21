package abgabe7;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a puzzle and its allowed manipulations/observations.
 * 
 * @author Martin Albertz, Selina Fiorin, Josha Bartsch
 */
public class Schiebepuzzle {

  /**
   * Feld represents the board in Rows and columns.
   */
  int[][] feld;
  int highestInt;

  /**
   * Default constructor initializes feld as an 2-d array of length 4x4. Fills the array with the
   * perfect solution to ensure any derivation of this field remains solvable.
   */
  public Schiebepuzzle() {
    int[][] feld = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    this.highestInt = (int) Math.pow(feld.length, 2) - 1; // Highest number included in feld,
                                                          // assuming its square and the values are
                                                          // assigned consecutively.
    this.feld = feld;
  }

  /**
   * Converts the 2-d array feld to an x by x table-like String.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    int maxDLen = String.valueOf(highestInt).length(); // Determines the maximum length (as in
                                                       // String.length()) for all values in feld.
    for (int i = 0; i < this.feld.length; i++) { // Iterates over the row indexes
      sb.append("|"); // Every String line begins with "|"
      for (int j = 0; j < this.feld[i].length; j++) { // Iterates over the column indexes of each
                                                      // row, writes a single cell for column.
        sb.append(String.format(feld[i][j] != 0 ? "%" + maxDLen + "d" : "  ", feld[i][j]));
        sb.append("|");
      }
      sb.append("\n");
      sb.append("-".repeat(feld[i].length * 3 + 1)); // Interjects a line between each row and at
                                                     // the end.
      sb.append("\n");
    }
    return sb.toString();
  }

  /**
   * Tries to move a specified number into the empty slot. Will throw a RuntimException if the
   * number is out of Range or the slot with the number is not a direct neighbor of the empty slot.
   * 
   * @param i Value of the Plaettchen that shall be moved into the empty slot.
   */
  public void schiebe(int i) {
    if (!istVerschiebbar(i)) {
      throw new WrongMoveException("Das Plaettchen ist nicht verschiebbar!");
    }
    if (!validNumber(i)) {
      throw new WrongNumberException(
          String.format("Die Zahl %d existiert nicht im Spielbrett!", i));
    }
    int[] positionP = getPosition(i);
    int[] positionO = getPosition(0);

    feld[positionO[0]][positionO[1]] = i;
    feld[positionP[0]][positionP[1]] = 0;
  }

  /**
   * Checks a given number on validity.
   * 
   * @param i Value of the slot that shall be validated.
   * @return True if the value is in the range between the highest and lowest value slot, else
   *         returns false,
   */
  public boolean validNumber(int i) {
    if (i < 0 || i > highestInt) {
      return false;
    }
    return true;
  }

  /**
   * Determines the position of any given number. Throws a RuntimeException if the number is not in
   * range of feld.
   * 
   * @param i Value of the sought slot.
   * @return Array of length 2, index 0 is the row, index 1 is the column number. Both indexes are
   *         -1 if i is not contained in feld.
   */
  public int[] getPosition(int i) {
    int row = -1;
    int col = -1;

    if (!validNumber(i)) {
      throw new WrongNumberException(
          String.format("Die Zahl %d existiert nicht im Spielbrett!", i));
    }

    /*
     * Iterates over every cell in feld until the value of the current cell matches the given int i.
     * As the validity of i is checked beforehand, this iteration should be successfull. Otherwise
     * the Returnvalue is {-1, -1}.
     */
    for (int j = 0; j < feld.length; j++) {
      for (int k = 0; k < feld[j].length; k++) {
        if (i == feld[j][k]) {
          row = j;
          col = k;
        }
      }
    }
    int[] ret = {row, col};
    return ret;
  }

  /**
   * Determines if the given slot is next to the empty slot and thus can be moved into the empty
   * slot. Slots cannot be moved diagonally!
   * 
   * @param i Value of the slot.
   * @return True if the empty slot is either horizontally or vertically neighboring the given slot.
   */
  public boolean istVerschiebbar(int i) {
    if (!validNumber(i)) {
      throw new WrongNumberException(
          String.format("Die Zahl %d existiert nicht im Spielbrett!", i));
    }

    int maxR = feld.length - 1; // Determines the highest index for rows (assuming a square feld).
    int maxC = feld[0].length - 1; // Determines the highest index for columns (assuming a square
                                   // feld).

    int[] position = getPosition(i);
    int row = position[0];
    int col = position[1];

    if (col != -1 || row != -1) { // Checks validity of getPostion output: Index -1 indicates
                                  // something is wrong with i.
      /*
       * Series of checks covering the horizontal and vertical environment of i. If any of the 4
       * neighboring fields has the value 0, return true.
       */
      if (row < maxR) {
        if ((feld[row + 1][col] == 0)) {
          return true;
        }
      }
      if (row > 0) {
        if ((feld[row - 1][col] == 0)) {
          return true;
        }
      }
      if (col < maxC) {
        if ((feld[row][col + 1] == 0)) {
          return true;
        }
      }
      if (col > 0) {
        if ((feld[row][col - 1] == 0)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * @param r Row number
   * @param c Column number
   * @return The value stored at row r, column c.
   */
  public int getVal(int r, int c) {
    return this.feld[r][c];
  }


  /**
   * For 100 valid moves, move a random slot into the empty slot.
   */
  public void mische() {
    for (int n = 0; n < 100;) {
      // nextInt is normally exclusive of the top value,
      // so add 1 to make it inclusive
      int pl = ThreadLocalRandom.current().nextInt(1, highestInt + 1);
      if (istVerschiebbar(pl)) {
        schiebe(pl);
        n++;
      }
    }
  }
}
