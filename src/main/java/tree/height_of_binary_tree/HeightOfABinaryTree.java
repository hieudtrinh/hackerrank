package tree.height_of_binary_tree;

import common.TreeNode;

public class HeightOfABinaryTree {
  public int height(TreeNode root) {
    return root == null ? -1 : 1 + Math.max(height(root.getLeft()), height(root.getRight()));
  }
}
