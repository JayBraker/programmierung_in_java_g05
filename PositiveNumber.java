package abgabe12;

import java.util.Arrays;
import java.util.List;

public class PositiveNumber {
  private final List<String> HEX_STELLEN =
      Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F");
  private int value;

  private final int CHAR_HEX_OFFSET = 55;
  private final int ASCII_UPPER_OFFSET = 32;
  private final int CHAR_INT_OFFSET = 48;

  public void setDecimal(String s) {
    int tmpValue = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int tTmpValue = 0;
      if (48 <= chars[i] && chars[i] <= 57) {
        tTmpValue += (chars[i] - 48) * Math.pow(10, s.length() - i - 1);
      } else {
        throw new NumberFormatException();
      }
      if (Integer.MAX_VALUE - tmpValue < tTmpValue) {
        throw new ArithmeticException();
      } else {
        tmpValue += tTmpValue;
      }
    }
    value = tmpValue;
  }

  public void setHexadecimal(String s) {
    int tmpValue = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int tTmpValue = 0;
      if (65 <= chars[i] && chars[i] <= 90) {
        tTmpValue += (chars[i] - CHAR_HEX_OFFSET) * Math.pow(16, s.length() - i - 1);
      } else if (97 <= chars[i] && chars[i] <= 122) {
        tTmpValue +=
            (chars[i] - ASCII_UPPER_OFFSET - CHAR_HEX_OFFSET) * Math.pow(16, s.length() - i - 1);
      } else if (48 <= chars[i] && chars[i] <= 57) {
        tTmpValue += (chars[i] - CHAR_INT_OFFSET) * Math.pow(16, s.length() - i - 1);
      } else {
        throw new NumberFormatException();
      }
      if (Integer.MAX_VALUE - tmpValue < tTmpValue) {
        throw new ArithmeticException();
      } else {
        tmpValue += tTmpValue;
      }
    }
    value = tmpValue;
  }

  public void setBinary(String s) {
    int tmpValue = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int tTmpValue = 0;
      if (48 <= chars[i] && chars[i] <= 49) {
        tTmpValue += (chars[i] - CHAR_INT_OFFSET) * Math.pow(2, s.length() - i - 1);
      } else {
        throw new NumberFormatException();
      }
      if (Integer.MAX_VALUE - tmpValue < tTmpValue) {
        throw new ArithmeticException();
      } else {
        tmpValue += tTmpValue;
      }
    }
    value = tmpValue;
  }

  public String getDecimal() {
    StringBuilder ret = new StringBuilder();
    int tmpValue = value;
    while (tmpValue > 0) {
      ret.append(tmpValue % 10);
      tmpValue /= 10;
    }
    ret.reverse();
    return ret.toString();
  }

  public String getHexadecimal() {
    StringBuilder ret = new StringBuilder();
    int tmpValue = value;
    while (tmpValue > 0) {
      ret.append(HEX_STELLEN.get((tmpValue % 16) - 1));
      tmpValue /= 16;
    }
    ret.reverse();
    return ret.toString();
  }

  public String getBinary() {
    StringBuilder ret = new StringBuilder();
    int tmpValue = value;
    while (tmpValue > 0) {
      ret.append(tmpValue % 2);
      tmpValue /= 2;
    }
    ret.reverse();
    return ret.toString();
  }
}
