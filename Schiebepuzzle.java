package abgabe7;

import java.util.concurrent.ThreadLocalRandom;

public class Schiebepuzzle {

  int[][] feld;

  public Schiebepuzzle() {
    int[][] feld = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    this.feld = feld;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.feld.length; i++) {
      sb.append("|");
      for (int j = 0; j < this.feld[i].length; j++) {
        sb.append(String.format(feld[i][j] != 0 ? "%2d" : "  ", feld[i][j]));
        sb.append("|");
      }
      sb.append("\n");
      sb.append("-".repeat(feld[i].length * 3 + 1));
      sb.append("\n");
    }
    return sb.toString();
  }

  public void schiebe(int i) {
    if (!istVerschiebbar(i)) {
      throw new WrongMoveException("Das Pl�ttchen ist nicht verschiebbar!");
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

  public boolean validNumber(int i) {
    if (i < 1 || i > 15) {
      return false;
    }
    return true;
  }

  public int[] getPosition(int i) {
    int row = -1;
    int col = -1;

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

  public boolean istVerschiebbar(int i) {
    if (!validNumber(i)) {
      throw new WrongNumberException(
          String.format("Die Zahl %d existiert nicht im Spielbrett!", i));
    }

    int[] position = getPosition(i);
    int row = position[0];
    int col = position[1];

    if (col != -1 && row != -1) {
      if (row < 3) {
        if ((feld[row + 1][col] == 0)) {
          return true;
        }
      }
      if (row > 0) {
        if ((feld[row - 1][col] == 0)) {
          return true;
        }
      }
      if (col < 3) {
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
  
  public int getVal(int r, int c) {
    return this.feld[r][c];
  }

  public void mische() {
    for (int n = 0; n < 100;) {
      // nextInt is normally exclusive of the top value,
      // so add 1 to make it inclusive
      int pl = ThreadLocalRandom.current().nextInt(1, 15 + 1);
      if (istVerschiebbar(pl)) {
        schiebe(pl);
        n++;
      }
    }
  }
}
