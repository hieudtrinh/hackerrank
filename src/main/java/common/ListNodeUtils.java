package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNodeUtils {

  /**
   * Convert ListNode linked list into ArrayList of ListNode
   * @param head ListNode object
   * @return Array of ListNode
   */
  public static List<ListNode> toList(ListNode head) {
    List<ListNode> list = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      list.add(cur);
      cur = cur.next;
    }
    return list;
  }

  /**
   * Create a ListNode from string s representation of the list.
   * @param s example (2 -> 4 -> 3) or 2 -> 4 -> 3
   * @return ListNode(2).next = ListNode(4).next = ListNode(3).next = nil
   */
  public static ListNode toListNode(String s) {
    // (2 -> 4 -> 3)
    s = s.trim();
    if (s.charAt(0) == '(') {
      s = s.substring(1);
    }
    if (s.charAt(s.length() - 1) == ')') {
      s = s.substring(0, s.length() - 1);
    }
    String[] tokens = s.split("[ ]*->[ ]*");
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    for (String n : tokens) {
      cur.next = new ListNode(Integer.parseInt(n));
      cur = cur.next;
    }
    return dummy.next;
  }

  /**
   * @param listNode object to stringify
   * @return String representation of the list in the form [1,2,3,4,5]
   */
  public static String toString(ListNode listNode) {
    return toList(listNode).toString();
  }

  /**
   * @param head  ListNode to be printed to the console
   */
  public static void print(ListNode head) {
    System.out.println(toString(head));
  }

  /**
   * This function create a sorted ListNode in ascending order.
   * @param nums list of number to be converted into a sorted ListNode
   * @return sorted ListNode
   */
  public static ListNode buildSortedListNode(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    Arrays.sort(nums);
    ListNode head = new ListNode(nums[0]), cur = head;
    for (int i=1; i<nums.length; i++) {
      cur.next = new ListNode(nums[i]);
      cur = cur.next;
    }
    return head;
  }
}
