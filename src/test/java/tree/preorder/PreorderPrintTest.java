package tree.preorder;

import common.MyTreePrinter;
import common.TreeNode;
import common.TreeNodeUtils;
import org.testng.annotations.Test;

public class PreorderPrintTest {

  @Test
  public void testPreOrder() {
    PreorderPrint solution = new PreorderPrint();
    String s = "[3,2,4,1, null, 5,6]";
    TreeNode root = TreeNodeUtils.buildTreeNodeFromString(s);
    MyTreePrinter.printDiagonal(root);
    solution.preOrder(root);
  }
}
