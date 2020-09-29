package linked_lists.reverse_a_doubly_linked_list;

import common.DoublyListNode;

public class ReverseDoublyLinkedList {
  DoublyListNode reverse(DoublyListNode head) {
    DoublyListNode curr = head, prev = null;
    while (curr != null) {
      DoublyListNode next = curr.next;
      curr.next = prev;
      curr.prev = next;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }
}
