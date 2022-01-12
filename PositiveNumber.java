package abgabe12;

import java.util.Arrays;
import java.util.List;

/**
 * @author Selina Fiorin, Josha Bartsch
 *
 */
public class PositiveNumber {
  private final List<String> HEX_STELLEN =
      Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"); // List
                                                                                                // to
                                                                                                // map
                                                                                                // integer
                                                                                                // to
                                                                                                // hex
                                                                                                // characters
                                                                                                // (A-F)

  private int value;

  private final int CHAR_HEX_OFFSET = 55; // Offset Ascii representation of 'F' to '15'
  private final int ASCII_UPPER_OFFSET = 32; // Offset Ascii representation of 'a' to 'A'
  private final int CHAR_INT_OFFSET = 48; // Offset Ascii representation of '0' to (char) 0

  /**
   * @param s String representation of an integer to the base of 10
   */
  public void setDecimal(String s) {
    int tmpValue = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int tTmpValue = 0;
      if (48 <= chars[i] && chars[i] <= 57) { // Identify char in range of Ascii values 0-9
        tTmpValue += (chars[i] - 48) * Math.pow(10, s.length() - i - 1);
      } else {
        throw new NumberFormatException(); // Throw NumberFormatException if a character is not matching the expected base (other than 0-9)
      }
      if (Integer.MAX_VALUE - tmpValue < tTmpValue) {
        throw new ArithmeticException(); // Throw ArithmeticException if the resulting value becomes greater than 2^32-1
      } else {
        tmpValue += tTmpValue;
      }
    }
    value = tmpValue;
  }

  /**
   * @param s String representation of an integer to the base of 16
   */
  public void setHexadecimal(String s) {
    int tmpValue = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int tTmpValue = 0;
      if (65 <= chars[i] && chars[i] <= 90) { // Identify char in range of Ascii representation A-Z
        tTmpValue += (chars[i] - CHAR_HEX_OFFSET) * Math.pow(16, s.length() - i - 1);
      } else if (97 <= chars[i] && chars[i] <= 122) { // Identify char in range of Ascii repr a-z
        tTmpValue +=
            (chars[i] - ASCII_UPPER_OFFSET - CHAR_HEX_OFFSET) * Math.pow(16, s.length() - i - 1);
      } else if (48 <= chars[i] && chars[i] <= 57) { // Identify char in range of Ascii values 0-9
        tTmpValue += (chars[i] - CHAR_INT_OFFSET) * Math.pow(16, s.length() - i - 1);
      } else {
        throw new NumberFormatException(); // Throw NumberFormatException if a character is not matching the expected base (other than 0-F)
      }
      if (Integer.MAX_VALUE - tmpValue < tTmpValue) {
        throw new ArithmeticException(); // Throw ArithmeticException if the resulting value becomes greater than 2^32-1
      } else {
        tmpValue += tTmpValue;
      }
    }
    value = tmpValue;
  }

  /**
   * @param s String representation of an integer to the base of 2
   */
  public void setBinary(String s) {
    int tmpValue = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int tTmpValue = 0;
      if (48 <= chars[i] && chars[i] <= 49) { // Identify char in range of Ascii values 0-1
        tTmpValue += (chars[i] - CHAR_INT_OFFSET) * Math.pow(2, s.length() - i - 1);
      } else {
        throw new NumberFormatException(); // Throw NumberFormatException if a character is not matching the expected base (other than 0 or 1)
      }
      if (Integer.MAX_VALUE - tmpValue < tTmpValue) { // Throw ArithmeticException if the resulting value becomes greater than 2^32-1
        throw new ArithmeticException();
      } else {
        tmpValue += tTmpValue;
      }
    }
    value = tmpValue;
  }

  /**
   * @return Value in decimal representation, type String
   */
  public String getDecimal() {
    StringBuilder ret = new StringBuilder();
    int tmpValue = value;
    while (tmpValue > 0) {
      ret.append(tmpValue % 10); // modulo 10 equals the last digit, append that to Stringbuilder
      tmpValue /= 10; // Divide by 10 "drops" last digit
    }
    ret.reverse(); // Digits are appended backwards, revert order
    return ret.toString();
  }

  /**
   * @return Value in hexadecimal representation, type String
   */
  public String getHexadecimal() {
    StringBuilder ret = new StringBuilder();
    int tmpValue = value;
    while (tmpValue > 0) {
      ret.append(HEX_STELLEN.get((tmpValue % 16) - 1)); // Splits off hex numbers bit by bit,
                                                        // appends to SB
      tmpValue /= 16;
    }
    ret.reverse();
    return ret.toString(); // Digits are appended backwards, revert order
  }

  /**
   * @return Value in binary representation, type String
   */
  public String getBinary() {
    StringBuilder ret = new StringBuilder();
    int tmpValue = value;
    while (tmpValue > 0) {
      ret.append(tmpValue % 2); // Splits off hex binary numbers bit by bit, appends to SB
      tmpValue /= 2;
    }
    ret.reverse(); // Digits are appended backwards, revert order
    return ret.toString();
  }
}
