package linked_lists.detect_a_cycle;

import common.ListNode;
import common.ListNodeUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DetectCycleInLinkedListTest {

  @Test
  public void testHasCycle() {
    ListNode head = ListNodeUtils.toListNode("1->2->3->4->5");
    DetectCycleInLinkedList solution = new DetectCycleInLinkedList();
    assertFalse(solution.hasCycle(head));
    ListNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = head.next;
    assertTrue(solution.hasCycle(head));
  }
}
