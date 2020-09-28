package common;

public class TreeNode2 {
  int val;
  int leftChildCount;
  TreeNode2 left, right;

  public TreeNode2(int val, int countSmaller) {
    this.val = val;
    this.leftChildCount = countSmaller;
  }

  public String toString() {
    return ("val=" + val + ", countSmaller=" + leftChildCount);
  }
}
