import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zahlwort {

  private static final String[] einerAnom = {"null", "eins"};
  private static final String[] zehnerAnom = {"elf", "zwoelf"};
  private static final String[] einer = {
    "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun"
  };
  private static final String[] zehner = {
    "",
    "zehn",
    "zwanzig",
    "dreissig",
    "vierzig",
    "fuenfzig",
    "sechzig",
    "siebzig",
    "achtzig",
    "neunzig"
  };

  public static String getZahlWort(int x) {
    StringBuilder ret = new StringBuilder();
    String input = String.valueOf(x);
    final int sLen = input.length();

    if (input.length() > 1) {
      char[] tmp = input.toCharArray();
      char tmpC = tmp[sLen - 1];
      tmp[sLen - 1] = tmp[sLen - 2];
      tmp[sLen - 2] = tmpC;
      StringBuilder sb = new StringBuilder();
      for (char c : tmp) {
        sb.append(c);
      }
      input = sb.toString();
    }

    List<Character> chars = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

    Stream<String[]> characterStream =
        input
            .chars()
            .mapToObj(
                repr -> {
                  int intRepr = Integer.valueOf(String.valueOf((char) repr));

                  int c = Integer.valueOf(chars.indexOf((char) repr)); // Get Position of char
                  String[] retArr = new String[2];

                  if ((c == sLen - 2) || (sLen == 1)) {
                    if (intRepr == 1) {
                      retArr[0] = einerAnom[1];
                    } else if (intRepr == 0) {
                      retArr[0] = einerAnom[0];
                    } else {
                      retArr[0] = einer[intRepr];
                    }
                  } else if ((c == sLen - 1) && sLen > 1) {
                    if (intRepr < 2) {
                      if (intRepr != 1 && intRepr != 2) {
                        retArr[0] = zehner[0];
                      } else if (Integer.valueOf(String.valueOf(chars.get(intRepr))) == 1) {
                        retArr[0] = zehnerAnom[0];
                      } else if (Integer.valueOf(String.valueOf(chars.get(intRepr))) == 2) {
                        retArr[0] = zehnerAnom[1];
                      }

                    } else {
                      retArr[0] = zehner[intRepr];
                    }
                  } else if (c == sLen - 3) {
                    if (intRepr != 0) {
                      retArr[0] = einer[intRepr] + "hundert";
                    } else {
                      retArr[0] = "";
                    }
                  } else if (c == sLen - 4) {
                    if (intRepr != 0) {
                      retArr[0] = einer[intRepr] + "tausend";
                    } else {
                      retArr[0] = "";
                    }
                  }
                  retArr[1] = String.valueOf(c);
                  return retArr;
                });

    characterStream.forEach(
        s -> {
          if (Integer.valueOf(s[1]) == sLen - 2) {
            if (!((chars.get(sLen - 2) == (char) 1 || chars.get(sLen - 2) == (char) 2)
                && (chars.get(sLen - 1) == (char) 1))) {
              ret.append(s[0]);
              ret.append("und");
            }
          } else {
            ret.append(s[0]);
          }
        });

    return ret.toString();
  }

  public static void main(String[] args) {
    System.out.println(getZahlWort(24));
    System.out.println(getZahlWort(124));
    System.out.println(getZahlWort(2));
    System.out.println(getZahlWort(1));
    System.out.println(getZahlWort(11));
  }
}
