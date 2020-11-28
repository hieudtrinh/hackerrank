package tree.binary_search_tree;

import common.TreeNode;

public class ValidateBinarySearchTree {
  boolean checkBST(TreeNode root) {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean checkBST(TreeNode root, int min, int max) {
    if (root == null) return true;

    // if left child value is less then or equals to root.val
    // change root.val < max to root.val <= max
    return (root.val > min && root.val < max)
        && checkBST(root.left, min, root.val)
        && checkBST(root.right, root.val, max);
  }
}
