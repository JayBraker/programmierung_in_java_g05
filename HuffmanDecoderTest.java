package abgabe11;

import java.io.File;

public class HuffmanDecoderTest {
  public static void main(String[] args) {
    String decodedWord = HuffmanDecoder.decode(new File("HuffmanCode.txt"));
    System.out.println(decodedWord);
  }
}
