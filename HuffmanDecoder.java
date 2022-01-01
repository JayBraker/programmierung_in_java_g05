package abgabe11;

import java.io.*;
import java.util.HashMap;

/**
 * @author Selina Fiorin, Josha Bartsch
 *
 */
public class HuffmanDecoder {
  /**
   * This method first determines whether the file meets the expected format (exactly 28 lines).
   * Then it generates the translation table. Finally it reads the encoded message and translates
   * it.
   * 
   * @param f File Object of the file to be translated.
   * @return Decoded String
   */
  public static String decode(File f) {
    StringBuilder decoded;
    /*
     * We use a single catch for every possible IOException as they should all trigger only if sth
     * is wrong with the input file.
     */
    try {
      if (!fileIntegrityCheck(f)) {
        throw new IllegalArgumentException("Die Datei entspricht nicht dem erwarteten Format!");
      }
      decoded = new StringBuilder();
      HashMap<String, Character> decodeTable = buildDecodeTable(f);
      BufferedReader reader = new BufferedReader(new FileReader(f));
      String word = reader.readLine();
      reader.close();
      int buff = 0;
      for (int i = 0; i < word.length() + 1; i++) {
        String sub = word.substring(buff, i);
        if (decodeTable.containsKey(sub)) {
          char decSub = decodeTable.get(sub);
          decoded.append(decSub);
          buff = i;
        }
      }
      return decoded.toString();
    } catch (IOException e) {
      throw new IllegalArgumentException("Die Datei entspricht nicht dem erwarteten Format!");
    }
  }

  /**
   * Method to build the translation table from a given input file. Build a key-value map. Keys are
   * the binary representation, huffman encoded characters. Values are the decoded characters
   * derived from the provided file.
   * 
   * @param f File Object of the file to be translated.
   * @return HashMap containing translation binary to char.
   * @throws IOException All IO errors are handled in decode()
   */
  public static HashMap<String, Character> buildDecodeTable(File f) throws IOException {
    BufferedReader reader;
    HashMap<String, Character> decodeTable;
    reader = new BufferedReader(new FileReader(f));
    decodeTable = new HashMap<>();
    int lines = 0;
    String line = null;
    line = reader.readLine();
    while (line != null) {
      lines++;
      if (!line.equals("")) { // Empty lines indicate the character won't be used so we must ignore
                              // those
        if (lines > 1 && lines < 28) { // First line contains the encoded String, following 26 lines
                                       // characters A-Z, line 28
          int integer = (lines + 63); // line 2 has to be mapped to char 'A' - Int 65 so we use
                                      // offset 63
          char character = (char) integer;
          decodeTable.put(line, character);
        } else if (lines == 28) {
          decodeTable.put(line, (char) 32); // Line 28 contains the encoded space
        }
      }
      line = reader.readLine();
    }
    reader.close();
    return decodeTable;
  }

  /**
   * Checks if the file meets expected line count of 28.
   * 
   * @param f File object to check
   * @return boolean
   * @throws IOException All IO errors are handled in decode()
   */
  public static boolean fileIntegrityCheck(File f) throws IOException {
    BufferedReader reader;
    reader = new BufferedReader(new FileReader(f));
    int lines = 0;
    while (reader.readLine() != null)
      lines++;
    reader.close();
    if (lines == 28) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    String decodedWord =
        HuffmanDecoder.decode(new File("C:\\Users\\og415626\\Documents\\HuffmanCode.txt"));
    System.out.println(decodedWord);
  }
}
