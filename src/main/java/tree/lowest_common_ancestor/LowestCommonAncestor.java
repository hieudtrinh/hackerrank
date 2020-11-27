package tree.lowest_common_ancestor;

import common.TreeNode;

import java.util.Scanner;

public class LowestCommonAncestor {
  public static TreeNode insert(TreeNode root, int data) {
    if (root == null) {
      return new TreeNode(data);
    } else {
      TreeNode cur;
      if (data <= root.val) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    TreeNode root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    int v1 = scan.nextInt();
    int v2 = scan.nextInt();
    scan.close();
    LowestCommonAncestor solution = new LowestCommonAncestor();
    TreeNode ans = solution.lca(root, v1, v2);
    System.out.println(ans.val);
  }

  /*
  class Node
      int data;
      Node left;
      Node right;
  */
  public TreeNode lca(TreeNode root, int v1, int v2) {
    // Write your code here.
    if (root == null || root.val == v1 || root.val == v2) return root;
    if (root.val < v1 && root.val < v2) {
      return lca(root.right, v1, v2);
    } else if (root.val > v1 && root.val > v2) {
      return lca(root.left, v1, v2);
    }
    return root;
  }
}
