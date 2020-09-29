package common;

public class DoublyListNodeUtils {
  public static DoublyListNode createDoublyListNode(int[] a) {
    DoublyListNode head = null, curr = null;
    for (int n : a) {
      DoublyListNode dnode = new DoublyListNode(n);
      if (head == null) {
        head = dnode;
        curr = dnode;
        continue;
      }
      curr.next = dnode;
      dnode.prev = curr;
      curr = curr.next;
    }
    return head;
  }

  public static void print(DoublyListNode head) {
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      if (sb.length() > 0)
        sb.append("<->");
      sb.append(head.val);
      head = head.next;
    }
    if (sb.length() > 0)
      sb.append("->Nil");
    System.out.println(sb.toString());
  }
}
