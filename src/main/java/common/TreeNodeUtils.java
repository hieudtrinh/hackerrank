package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNodeUtils {

  /**
   * @param s [1,2,3,4,5,6]
   * @return TreeNode
   */
  public static TreeNode buildTreeNodeFromString(String s) {
    Integer[] nums = Utils.toArrayInteger(s);
    return arrayToTreeNode(nums);
  }

  /**
   * @param input new Integer[] {-10,9,20,null,null,15,7}
   * @return tree -10 / \ / \ 9 20 / \ 15 7
   */

  //          -10
  //          /  \
  //         /    \
  //        9     20
  //              / \
  //             15  7
  public static TreeNode arrayToTreeNode(Integer[] input) {
    return createTreeNode(input, 1);
  }

  public static TreeNode createTreeNode(Integer[] input, int index) {
    if (index <= input.length) {
      // need to -1 because array index at 0
      Integer value = input[index - 1];
      if (value != null) {
        TreeNode tree = new TreeNode(value);
        tree.left = createTreeNode(input, index * 2);
        tree.right = createTreeNode(input, index * 2 + 1);
        return tree;
      }
    }
    return null;
  }

  //          -10
  //          / \
  //         /   \
  //         9   20
  //             / \
  //            15 7
  //     [-10, 9, 20, null, null, 15, 7]
  /**
   * @param root see the tree above
   * @return String "[-10, 9, 20, null, null, 15, 7]"
   */
  public static String toString(TreeNode root) {
    return toIntegerList(root).toString();
  }

  //          -10
  //          / \
  //         /   \
  //         9   20
  //             / \
  //            15 7
  /**
   * @param root see the tree above
   * @return List<Integer> list = Arrays.asList(-10, 9, 20, null, null, 15, 7)
   */
  public static List<Integer> toIntegerList(TreeNode root) {
    Stack<Integer> stack = new Stack<>();
    // BFS
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) {
      q.offer(root);
      while (!q.isEmpty()) {
        TreeNode node = q.poll();
        // don't output the last node if it is null
        if (q.isEmpty() && node == null) break;
        stack.push((node == null) ? null : node.val);
        if (node != null) {
          q.offer(node.left);
          q.offer(node.right);
        }
      }
    }
    while (!stack.isEmpty() && stack.peek() == null) stack.pop();
    // return stack.stream().collect(Collectors.toList());
    // OR
    return new ArrayList<>(stack);
  }

  /** @param root root node */
  //          -10
  //          / \
  //         /   \
  //         9   20
  //             / \
  //            15  7
  public static void printNode(TreeNode root) {
    int maxLevel = maxLevel(root);
    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
  }

  /**
   * @param node root node
   * @return maximum depth of the tree, where root has depth of 0 and it left and right children
   *     have depth of 1 and this logic apply to their children.
   */
  private static int maxLevel(TreeNode node) {
    if (node == null) return 0;
    return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
  }

  private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
    if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

    int floor = maxLevel - level;
    int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int) Math.pow(2, (floor)) ;//- 1;
    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

    printWhitespaces(firstSpaces);

    List<TreeNode> newNodes = new ArrayList<>();
    for (TreeNode node : nodes) {
      if (node != null) {
        System.out.print(node.val);
        newNodes.add(node.left);
        newNodes.add(node.right);
      } else {
        newNodes.add(null);
        newNodes.add(null);
        System.out.print(" ");
      }

      printWhitespaces(betweenSpaces);
    }
    System.out.println();

    for (int i = 1; i <= endgeLines; i++) {
      for (TreeNode node : nodes) {
        printWhitespaces(firstSpaces - i);
        if (node == null) {
          printWhitespaces(endgeLines + endgeLines + i + 1);
          continue;
        }

        if (node.left != null)
          System.out.print("/");
        else
          printWhitespaces(1);

        printWhitespaces(i + i - 1);

        if (node.right != null)
          System.out.print("\\");
        else
          printWhitespaces(1);

        printWhitespaces(endgeLines + endgeLines - i);
      }

      System.out.println();
    }

    printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++) System.out.print(" ");
  }

  private static <T> boolean isAllElementsNull(List<T> list) {
    for (Object object : list) {
      if (object != null) return false;
    }
    return true;
  }
}
