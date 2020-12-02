package tree.height_of_binary_tree;

import common.MyTreePrinter;
import common.TreeNode;
import common.TreeNodeUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HeightOfABinaryTreeTest {

  @Test
  public void testHeight() {
    String s = "[5,1,4,null,null,3,6]";
    TreeNode root = TreeNodeUtils.buildTreeNodeFromString(s);
    MyTreePrinter.printDiagonal(root);
    HeightOfABinaryTree solution = new HeightOfABinaryTree();
    Assert.assertEquals(solution.height(root), 2);
  }
}