package linked_lists.find_merge_point_of_two_lists;

import common.ListNode;

public class FindMergePointOfTwoLists {
  public int findMergeNode(ListNode head1, ListNode head2) {
    ListNode h1 = head1;
    ListNode h2 = head2;
    while (h1 != h2) {
      h1 = (h1 == null) ? head2 : h1.next;
      h2 = (h2 == null) ? head1 : h2.next;
    }
    return h1.val;
  }
}
