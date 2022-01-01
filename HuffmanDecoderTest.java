package abgabe11;

import java.io.File;

public class HuffmanDecoderTest {
  public static void main(String[] args) {
    String decodedWord =
        HuffmanDecoder.decode(new File("C:\\Users\\og415626\\Documents\\HuffmanCode.txt"));
    System.out.println(decodedWord);
  }
}
