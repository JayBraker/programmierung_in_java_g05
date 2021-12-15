package abgabe10;

import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zahlwort {

  private final static int MAXPOSINT = 9999;
  private static HashMap<Integer, String> digits, digits2;

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

  public static String getZahlwort(int x) {

    if (x > MAXPOSINT) {
      throw new ArithmeticException(String.format("Zahl nicht darstellbar. Limit: %d", MAXPOSINT));
    }

    String input = String.valueOf(x);
    String ret = "";
    if (input.length() == 1) {
      ret += digits.get(Integer.valueOf(input.substring(0, 1)));
      if (input.equals("1")) {
        ret += "s";
      }
    } else if (input.length() >= 2) {
      if (input.length() == 4) {
        ret += digits.get(Integer.valueOf(input.substring(0, 1))) + "tausend";
        if (!input.substring(1,2).equals("0")) {
          ret += digits.get(Integer.valueOf(input.substring(1, 2))) + "hundert";
        }
      }
      if (input.length() == 3) {
        ret += digits.get(Integer.valueOf(input.substring(0, 1))) + "hundert";
      }
      if (Integer.valueOf(input.substring(input.length() - 2, input.length())) < 20) {
        ret += digits.get(Integer.valueOf(input.substring(input.length() - 2, input.length())));
        String lastTwo = input.substring(input.length()-2, input.length());
        if (lastTwo.equals("01")) {
          ret += "s";
        }
      } else {
        if (!input.substring(input.length() - 1).equals("0")) {
            ret += digits.get(Integer.valueOf(input.substring(input.length() - 1, input.length())));
            ret += "und";
        }
        ret += digits2.get(Integer.valueOf(input.substring(input.length() - 2, input.length() - 1)));
      }
    }
    return ret;
  }

  public static Stream<String> getZahlStream(int start, int stop) {
    return IntStream.rangeClosed(start, stop).mapToObj(s -> getZahlwort(s));
  }
}
