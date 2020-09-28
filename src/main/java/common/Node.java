package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Node linked list with random pointer
 */
public class Node {
  public int val;
  public Node next;
  public Node random;

  public Node(int val) {
    this(val, null, null);
  }

  public Node(int val, Node next, Node random) {
    this.val = val;
    this.next = next;
    this.random = random;
  }

  public String toString() {
    Map<Node, Integer> map = new HashMap<>();
    Node cur = this;
    if (random == null)
      return val + "," + null;
    else
      return val + "," + random.val;
  }

}
