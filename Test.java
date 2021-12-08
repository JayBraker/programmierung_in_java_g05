package abgabe9;

/** @author Selina Fiorin, Josha Bartsch */
public class Test {
  public static void main(String[] args) {
    System.out.print("Rekursionstiefe: 0");
    Kochkurve.kochKurve(0, 500, 500, 500, 0);
    System.out.println();
    System.out.print("Rekursionstiefe: 1");
    Kochkurve.kochKurve(0, 500, 500, 500, 1);
    System.out.println();
    System.out.print("Rekursionstiefe: 2");
    Kochkurve.kochKurve(0, 500, 500, 500, 2);
  }
}
