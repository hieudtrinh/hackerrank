package linked_lists.insert_node_into_doubly_sorted_linked_list;

import common.DoublyListNode;
import common.DoublyListNodeUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InsertNodeIntoDoublySortedLinkedListTest {

  @Test
  public void testSortedInsert() {
    DoublyListNode head = DoublyListNodeUtils.createDoublyListNode(new int[]{1,2,3,5});
    DoublyListNodeUtils.print(head);
    InsertNodeIntoDoublySortedLinkedList solution =
            new InsertNodeIntoDoublySortedLinkedList();
    head = solution.sortedInsert(head, 4);
    DoublyListNodeUtils.print(head);
  }
}