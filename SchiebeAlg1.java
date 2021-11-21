package abgabe7;

import java.util.concurrent.ThreadLocalRandom;

/** @author Martin Albertz, Selina Fiorin, Josha Bartsch */
public class SchiebeAlg1 implements Loesungsalgorithmus {

  /**
   * Repeats random moves until the slot in row 1, column 1 has the value 1. The functionality is
   * similar to Schiebepuzzle.mische() but it runs until the condition (feld[0][0]==1) is met.
   */
  @Override
  public void loese(Schiebepuzzle sp) {
    int c =
        0; // Counts every iteration, the iteration may be invalid if the chosen slot is not movable
    int cs = 0; // Counts every performed move.
    while (!(sp.getVal(0, 0) == 1)) {
      c++;
      int pl = ThreadLocalRandom.current().nextInt(1, 15 + 1);
      if (sp.istVerschiebbar(pl)) {
        cs++;
        sp.schiebe(pl);
      }
    }
    System.out.println(
        String.format("Es hat %d Zufallszahlen gebraucht um zur Loesung zu kommen.", c));
    System.out.println(String.format("Davon waren %d versuchte Zuege zulaessig!\n", cs));
    return;
  }
}
