package common;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  // added below function for printing purpose
  // Code pull from https://github.com/billvanyo/tree_printer.git
  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  // convenience methods to build trees

  public static common.tree.TreeNode tree(int value, common.tree.TreeNode left, common.tree.TreeNode right) {
    return new common.tree.TreeNode(value, left, right);
  }

  public static common.tree.TreeNode treeLeft(int value, common.tree.TreeNode left) {
    return new common.tree.TreeNode(value, left, null);
  }

  public static common.tree.TreeNode treeRight(int value, common.tree.TreeNode right) {
    return new common.tree.TreeNode(value, null, right);
  }

  public static common.tree.TreeNode leaf(int value) {
    return new common.tree.TreeNode(value, null, null);
  }
}
