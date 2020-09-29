package linked_lists.find_merge_point_of_two_lists;

import common.ListNode;
import common.ListNodeUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindMergePointOfTwoListsTest {

  @Test
  public void testFindMergeNode() {
    ListNode head1 = ListNodeUtils.toListNode("1->2->3->4");
    ListNode head2 = ListNodeUtils.toListNode("7->2->9");
    ListNode tail = ListNodeUtils.toListNode("10->21");
    ListNode curr = head1;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = tail;

    curr = head2;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = tail;

    FindMergePointOfTwoLists solution = new FindMergePointOfTwoLists();
    assertEquals(solution.findMergeNode(head1, head2), 10);
  }
}
