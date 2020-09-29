package linked_lists.insert_a_node_at_position;

import common.ListNode;
import common.ListNodeUtils;
import common.MyTreePrinter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InsertNodeAtPositionTest {

  @Test
  public void testInsertNodeAtPosition() {
    // ListNode [16, 13, 7]
    // value = 1, position = 2
    ListNode head = ListNodeUtils.toListNode("16->13->7");
    ListNodeUtils.print(head);
    InsertNodeAtPosition solution = new InsertNodeAtPosition();
    head = solution.insertNodeAtPosition(head, 1, 2);
    ListNodeUtils.print(head);
  }
}