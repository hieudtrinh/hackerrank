package tree.binary_search_tree;

import common.MyTreePrinter;
import common.TreeNode;
import common.TreeNodeUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateBinarySearchTreeTest {

  @Test
  public void testCheckBST() {
    String s = "[3,2,4,1, null, 5,6]";
    TreeNode root = TreeNodeUtils.buildTreeNodeFromString(s);
    MyTreePrinter.printDiagonal(root);
    ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
    boolean ans = solution.checkBST(root);
    System.out.println(ans);

    s = "[3,3,5,1, null, 4,6]";
    root = TreeNodeUtils.buildTreeNodeFromString(s);
    MyTreePrinter.printDiagonal(root);
    ans = solution.checkBST(root);
    System.out.println(ans);
  }
}