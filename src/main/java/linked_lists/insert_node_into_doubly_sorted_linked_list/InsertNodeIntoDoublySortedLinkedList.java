package linked_lists.insert_node_into_doubly_sorted_linked_list;

import common.DoublyListNode;

public class InsertNodeIntoDoublySortedLinkedList {
  DoublyListNode sortedInsert(DoublyListNode head, int data) {
    DoublyListNode node = new DoublyListNode(data);
    DoublyListNode curr = head, prev = null;
    if (data < head.val) {
      node.next = head;
      head.prev = node;
      return node;
    } else {

      while (curr != null) {
        if (data < curr.val) {
          node.next = curr;
          curr.prev = node;
          prev.next = node;
          node.prev = prev;
          return head;
        }
        prev = curr;
        curr = curr.next;
      }
      prev.next = node;
      node.prev = prev;
      return head;
    }
  }
}
