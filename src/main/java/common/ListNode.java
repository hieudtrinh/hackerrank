package common;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode[] filterNull(ListNode[] list) {
    // return (ListNode[]) Arrays.stream(list).filter(a-> a != null).toArray();
    // The (a->a!=null) produce this warning
    // Warning:(41, 57) Lambda can be replaced with method reference
    return (ListNode[]) Arrays.stream(list).filter(Objects::nonNull).toArray();
  }

  public String toString() {
    return String.valueOf(val);
  }

  public ListNode[] toArray() {
    return toList().toArray(new ListNode[0]);
  }

  public List<ListNode> toList() {
    return ListNodeUtils.toList(this);
  }
}
