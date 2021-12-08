package abgabe9;

/** @author Selina Fiorin, Josha Bartsch */
public class Kochkurve {
  private static final double DR = Math.sqrt(3) / 2; // Reused value for calculating each triangle

  /**
   * This method takes two points in a 2D-plane and recursively computes the Koch curve for a give
   * recursion depth. Every coordinate computed will be printed on std::out.
   *
   * @param ax X-coordinate of starting point.
   * @param ay Y-coordinate of starting point.
   * @param bx X-coordinate of end point.
   * @param by Y-coordinate of end point.
   * @param rek Recursion depth to be achieved.
   */
  public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
    if (rek == 0) {
      System.out.printf(" (%.1f/%.1f) (%.1f/%.1f)", ax, ay, bx, by);
    } else {
      kochKurve(ax, ay, (2 * ax + bx) / 3, (2 * ay + by) / 3, rek - 1);
      kochKurve(
          (2 * ax + bx) / 3,
          (2 * ay + by) / 3,
          (ax + bx) / 2 + DR * (by - ay) / 3,
          (ay + by) / 2 + DR * (ax - bx) / 3,
          rek - 1);
      kochKurve(
          (ax + bx) / 2 + DR * (by - ay) / 3,
          (ay + by) / 2 + DR * (ax - bx) / 3,
          (ax + 2 * bx) / 3,
          (ay + 2 * by) / 3,
          rek - 1);
      kochKurve((ax + 2 * bx) / 3, (ay + 2 * by) / 3, bx, by, rek - 1);
    }
  }
}
