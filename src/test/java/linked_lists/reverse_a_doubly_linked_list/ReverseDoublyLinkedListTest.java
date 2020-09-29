package linked_lists.reverse_a_doubly_linked_list;

import common.DoublyListNode;
import common.DoublyListNodeUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReverseDoublyLinkedListTest {

  @Test
  public void testReverse() {
    DoublyListNode head = DoublyListNodeUtils.createDoublyListNode(new int[] {1,2,3,4,5});
    DoublyListNodeUtils.print(head);
    ReverseDoublyLinkedList solution = new ReverseDoublyLinkedList();
    head = solution.reverse(head);
    DoublyListNodeUtils.print(head);
  }
}