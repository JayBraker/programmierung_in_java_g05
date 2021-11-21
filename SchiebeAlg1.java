package abgabe7;

import java.util.concurrent.ThreadLocalRandom;

public class SchiebeAlg1 implements Loesungsalgorithmus {

  Schiebepuzzle puzzle;

  @Override
  public void loese(Schiebepuzzle sp) {
    this.puzzle = sp;

    int[] posTarget = {0, 0};

    int c = 0;
    int cs = 0;
    while (!(sp.getVal(0, 0) == 1)) {
      c++;
      int pl = ThreadLocalRandom.current().nextInt(1, 15 + 1);
      if (sp.istVerschiebbar(pl)) {
        cs++;
        sp.schiebe(pl);
      }
    }
    System.out.println(
        String.format("Es hat %d Zufallszahlen gebraucht um zur L�sung zu kommen.", c));
    System.out.println(String.format("Davon waren %d versuchte Zuege zulaessig!\n", cs));
    return;
  }
}
