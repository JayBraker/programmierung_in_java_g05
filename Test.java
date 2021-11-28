package abgabe7;

public class Test {
  public static void main(String[] args) {
    Schiebepuzzle puzzle = new Schiebepuzzle();
    System.out.println(puzzle);
    // mischen nicht vergessen, sonst hat der Spieler sehr schnell gewonnen
    puzzle.mische();
    System.out.println(puzzle);
    // testen des Loesungsalgorithmus
    // -> zufaellig schieben
    Loesungsalgorithmus alg1 = new SchiebeAlg1();
    alg1.loese(puzzle);
    System.out.println(puzzle);
  }
}
