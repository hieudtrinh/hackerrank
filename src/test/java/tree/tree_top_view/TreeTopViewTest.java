package tree.tree_top_view;

import common.MyTreePrinter;
import common.TreeNode;
import common.TreeNodeUtils;
import org.testng.annotations.Test;
import tree.binary_search_tree.ValidateBinarySearchTree;

import static org.testng.Assert.*;

public class TreeTopViewTest {

  @Test
  public void testTopView() {
    String s = "[3,2,4,1, null, 5,6]";
    TreeNode root = TreeNodeUtils.buildTreeNodeFromString(s);
    MyTreePrinter.printDiagonal(root);
    TreeTopView solution = new TreeTopView();
    solution.topView(root);
  }
}