package tree.preorder;

import common.TreeNode;

public class PreorderPrint {
    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
