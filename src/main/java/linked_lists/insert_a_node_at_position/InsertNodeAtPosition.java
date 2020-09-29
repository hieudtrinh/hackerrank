package linked_lists.insert_a_node_at_position;

import common.ListNode;

public class InsertNodeAtPosition {
  ListNode insertNodeAtPosition(ListNode head, int data, int position) {
    ListNode node = new ListNode(data);
    if (position == 0) {
      node.next = head;
      return node;
    }
    ListNode curr = head;
    for (int i = 0; i < position -1 && curr.next != null; i++) {
      curr = curr.next;
    }
    node.next = curr.next;
    curr.next = node;
    return head;
  }
}
