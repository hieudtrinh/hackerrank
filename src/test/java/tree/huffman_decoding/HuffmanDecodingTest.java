package tree.huffman_decoding;

import org.testng.annotations.Test;

public class HuffmanDecodingTest {

  @Test
  public void testEncode() {
    String s = "Hello World";
    HuffmanDecoding huffmanDecoding = new HuffmanDecoding();
    String encodedString = huffmanDecoding.encode(s);
    System.out.println(encodedString);
    System.out.println(huffmanDecoding.decode(encodedString));

    s = "ABRACADABRA";
    encodedString = huffmanDecoding.encode(s);
    System.out.println(encodedString);
    System.out.println(huffmanDecoding.decode(encodedString));
  }

}
