package tree.huffman_decoding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanDecoding {

  Node node;
  Map<Character, String> map;

  public HuffmanDecoding() {
    map = new HashMap<>();
  }

  /**
   * @param s "Hello World";
   * @return HuffmanNode
   */
  Node buildHuffmanNode(String s) {
    char[] arr = new char[256];
    for (int c : s.toCharArray()) {
      arr[c] += 1;
    }

    PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
    // same : PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.freq - b.freq);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        q.offer(new HuffmanLeaf(arr[i], (char) i));
      }
    }
    while (q.size() > 1) {
      Node n1 = q.poll();
      Node n2 = q.poll();
      q.offer(new HuffmanNode(n1, n2));
    }
    return q.poll();
  }

  String encode(String s) {
    map = new HashMap<>();
    node = buildHuffmanNode(s);
    buildLookUpMap(node, "");
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      sb.append(map.get(c));
    }
    return sb.toString();
  }

  String decode(String encodedString) {
    StringBuilder sb = new StringBuilder();
    Node cur = this.node;
    for (int i = 0; i < encodedString.length(); i++) {
      cur = encodedString.charAt(i) == '0' ? cur.left : cur.right;
      if (cur instanceof HuffmanLeaf) {
        sb.append(cur.data);
        cur = this.node;
      }
    }
    return sb.toString();
  }

  void buildLookUpMap(Node node, String prefix) {
    if (node instanceof HuffmanLeaf) {
      map.put(node.data, prefix);
    } else {
      buildLookUpMap(node.left, prefix + "0");
      buildLookUpMap(node.right, prefix + "1");
    }
  }

  class Node {
    public int freq;
    public char data;
    public Node left, right;

    public Node(int freq) {
      this.freq = freq;
    }
  }

  class HuffmanLeaf extends Node {
    public HuffmanLeaf(int freq, char val) {
      super(freq);
      data = val;
    }
  }

  class HuffmanNode extends Node {
    public HuffmanNode(Node l, Node r) {
      super(l.freq + r.freq);
      left = l;
      right = r;
    }
  }
}
