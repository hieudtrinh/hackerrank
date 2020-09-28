package common;

public class MultiLevelDListNodeUtils {
  public static MultiLevelDListNode toMutiLevelDListNode(Integer[] nums) {
    MultiLevelDListNode dummy = new MultiLevelDListNode(-1, null, null, null);
    MultiLevelDListNode curr = dummy;
    for (Integer n : nums) {
      curr.next = new MultiLevelDListNode(n, curr, null, null);
      curr = curr.next;
    }
    dummy.next.prev = null;
    return dummy.next;
  }

  public static void print(MultiLevelDListNode head) {
    System.out.print(toString(head));
  }

  public static String toString(MultiLevelDListNode head) {
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      if (sb.length() > 0) {
        sb.append("<->");
      }
      sb.append(head.val);
      head = head.next;
    }
    return sb.toString();
  }
}
