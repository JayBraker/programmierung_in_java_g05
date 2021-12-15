package abgabe10;

import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** @author Selina Fiorin, Josha Bartsch */
public class Zahlwort {

  private static final int MAXPOSINT = 9999; // Maximum allowed integer, defined by task
  private static HashMap<Integer, String> digits, digits2; // Map int to Strings

  static {
    digits = new HashMap<>();
    digits.put(0, "null");
    digits.put(1, "ein");
    digits.put(2, "zwei");
    digits.put(3, "drei");
    digits.put(4, "vier");
    digits.put(5, "fuenf");
    digits.put(6, "sechs");
    digits.put(7, "sieben");
    digits.put(8, "acht");
    digits.put(9, "neun");
    digits.put(10, "zehn");
    digits.put(11, "elf");
    digits.put(12, "zwoelf");
    digits.put(13, "dreizehn");
    digits.put(14, "vierzehn");
    digits.put(15, "fuenfzehn");
    digits.put(16, "sechzehn");
    digits.put(17, "siebzehn");
    digits.put(18, "achtzehn");
    digits.put(19, "neunzehn");

    digits2 = new HashMap<>();
    digits2.put(2, "zwanzig");
    digits2.put(3, "dreissig");
    digits2.put(4, "vierzig");
    digits2.put(5, "fuenfzig");
    digits2.put(6, "sechzig");
    digits2.put(7, "siebzig");
    digits2.put(8, "achtzig");
    digits2.put(9, "neunzig");
  }

  /**
   * This method takes any integer and returns the worded representation as a String. It determines
   * whether the integer is within range of the defined boundary (MAXPOSINT). Then, piece by piece
   * it assembles the String representation.
   *
   * @param x Integer to be converted.
   * @return String representation of x.
   */
  public static String getZahlwort(int x) {

    if (x > MAXPOSINT || x < 1) {
      throw new ArithmeticException(String.format("Zahl nicht darstellbar. Limit: %d", MAXPOSINT));
    }

    String input = String.valueOf(x);
    StringBuilder ret = new StringBuilder();

    if (input.length() == 1) { // For single digits, use digits mapping.
      ret.append(digits.get(Integer.valueOf(input.substring(0, 1))));
      if (input.equals("1")) {
        // must append "s" if single digit 1
        ret.append("s");
      }
    } else {
      /*
       * Based on count of digits, determine first (and second if count == 4) digit, Append the
       * dimension ("tausend", "hundert") accordingly.
       */

      // Max supported int is 9999, so no input.lenght() > 4 is to be expected.
      if (input.length() == 4) {
        ret.append(digits.get(Integer.valueOf(input.substring(0, 1))) + "tausend");
        if (!input.substring(1, 2).equals("0")) {
          ret.append(digits.get(Integer.valueOf(input.substring(1, 2))) + "hundert");
        }
      }
      if (input.length() == 3) {
        ret.append(digits.get(Integer.valueOf(input.substring(0, 1))) + "hundert");
      }
      /*
       * As digit count >= 2, check last two digits. Differentiates if last two digits < 20 as the
       * range 0 < x < 20 contains many inconsistencies in wording. Skip if last two digits are
       * "00", append "s" if last two digits are "01".
       */
      String lastTwo = input.substring(input.length() - 2, input.length());
      if (Integer.valueOf(lastTwo) < 20) {
        if (Integer.valueOf(lastTwo) > 0) {
          ret.append(
              digits.get(Integer.valueOf(input.substring(input.length() - 2, input.length()))));
          if (lastTwo.equals("01")) {
            ret.append("s");
          }
        }
      } else {
        /*
         * If second last digit is 0, ignore it and append last digit straight. Else append
         */
        if (!input.substring(input.length() - 1).equals("0")) {
          ret.append(
              digits.get(Integer.valueOf(input.substring(input.length() - 1, input.length()))));
          ret.append("und");
        }
        ret.append(
            digits2.get(Integer.valueOf(input.substring(input.length() - 2, input.length() - 1))));
      }
    }
    return ret.toString();
  }

  /**
   * @param start Integer indicating inclusive range start.
   * @param stop Integer indicating inclusive range end.
   * @return Stream consisting of every number String for each Integer in range of start and stop.
   */
  public static Stream<String> getZahlStream(int start, int stop) {
    return IntStream.rangeClosed(start, stop).mapToObj(s -> getZahlwort(s));
  }
}
