package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeUtils {
  /**
   * Convert Node linked list into ArrayList of Node
   *
   * @param head Node object
   * @return Array of ListNode
   */
  public static List<Node> toList(Node head) {
    List<Node> list = new ArrayList<>();
    Node cur = head;
    while (cur != null) {
      list.add(cur);
      cur = cur.next;
    }
    return list;
  }

  /**
   * Create a Node from string s representation of the list.
   *
   * @param s example (2 -> 4 -> 3) or 2 -> 4 -> 3
   * @return Node(2).next = Node(4).next = Node(3).next = nil
   */
  public static Node toListNode(String s) {
    // (2 -> 4 -> 3)
    s = s.trim();
    if (s.charAt(0) == '(') {
      s = s.substring(1);
    }
    if (s.charAt(s.length() - 1) == ')') {
      s = s.substring(0, s.length() - 1);
    }
    String[] tokens = s.split("[ ]*->[ ]*");
    Node dummy = new Node(0);
    Node cur = dummy;
    for (String n : tokens) {
      cur.next = new Node(Integer.parseInt(n));
      cur = cur.next;
    }
    return dummy.next;
  }

  /**
   * @param listNode object to stringify
   * @return String representation of the list in the form [1,2,3,4,5]
   */
  public static String toString(Node listNode) {
    return toList(listNode).toString();
  }

  /**
   * This function create a sorted Node in ascending order.
   *
   * @param nums list of number to be converted into a sorted Node
   * @return sorted Node
   */
  public static Node buildSortedListNode(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    Arrays.sort(nums);
    Node head = new Node(nums[0]), cur = head;
    for (int i = 1; i < nums.length; i++) {
      cur.next = new Node(nums[i]);
      cur = cur.next;
    }
    return head;
  }

  // [[7,null],[13,0],[11,4],[10,2],[1,0]]
  public static Node toListNodeWithRandom(String s) {
    // (2 -> 4 -> 3)
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1);
    }
    if (s.charAt(s.length() - 1) == ']') {
      s = s.substring(0, s.length() - 1);
    }
    String[] tokens = s.split("][ ]*,[ ]*");

    List<NodeInfo> nodeInfos = new ArrayList<>();

    for (String token : tokens) {
      token = token.trim();
      if (token.charAt(0) == '[') {
        token = token.substring(1);
      }
      if (token.charAt(token.length() - 1) == ']') {
        token = token.substring(0, token.length() - 1);
      }

      String[] ss = token.split("[ ]*,[ ]*");
      int value = Integer.parseInt(ss[0]);
      int randomIndex = "null".equals(ss[1].trim()) ? -1 : Integer.parseInt(ss[1]);
      nodeInfos.add(new NodeInfo(value, randomIndex));
    }

    Node dummy = new Node(0);
    Node cur = dummy;
    for (NodeInfo nodeInfo : nodeInfos) {
      nodeInfo.setRandomLink(nodeInfos);
      cur.next = nodeInfo.node;
      cur = cur.next;
    }
    return dummy.next;
  }

  public static String toStringWithInfo(Node node) {
    return toListOfNodeInfo(node).toString();
  }

  public static List<NodeInfo> toListOfNodeInfo(Node head) {
    Map<Node, Integer> map = new HashMap<>();
    List<Node> list = new ArrayList<>();
    Node cur = head;
    while (cur != null) {
      map.put(cur, list.size());
      list.add(cur);
      cur = cur.next;
    }
    List<NodeInfo> nodeInfos = new ArrayList<>();
    for (Node node : list) {
      nodeInfos.add(new NodeInfo(node, map.getOrDefault(node.random, -1)));
    }
    return nodeInfos;
  }

  public static class NodeInfo {
    Node node;
    int randomIndex = -1; // mean nil

    public NodeInfo(Node node) {
      this.node = node;
    }

    public NodeInfo(int value, int randomIndex) {
      this.node = new Node(value);
      this.randomIndex = randomIndex;
    }

    public NodeInfo(Node node, int randomIndex) {
      this.node = node;
      this.randomIndex = randomIndex;
    }

    public void setRandomLink(List<NodeInfo> list) {
      node.random = (randomIndex == -1) ? null : list.get(randomIndex).node;
    }

    public String toString() {
      return (randomIndex == -1)
          ? "[" + node.val + ", null]"
          : "[" + node.val + "," + randomIndex + "]";
    }
  }
}
