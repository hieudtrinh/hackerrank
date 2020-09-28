package common;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class TreePrinterSideWay {
    public void printTree(TreeNode root, OutputStreamWriter out) throws IOException {
        if (root.right != null) {
            printTree(root.right, out, true, "");
        }
        printNodeValue(root, out);
        if (root.left != null) {
            printTree(root.left, out, false, "");
        }
    }
    private void printNodeValue(TreeNode root, OutputStreamWriter out) throws IOException {
        if (root == null) {
            out.write("<null>");
        } else {
            out.write(root.val);
        }
        out.write('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(TreeNode root, OutputStreamWriter out, boolean isRight, String indent) throws IOException {
        if (root.right != null) {
            printTree(root.right, out, true, indent + (isRight ? "        " : " |      "));
        }
        out.write(indent);
        if (isRight) {
            out.write(" /");
        } else {
            out.write(" \\");
        }
        out.write("----- ");
        printNodeValue(root, out);
        if (root.left != null) {
            printTree(root.left, out, false, indent + (isRight ? " |      " : "        "));
        }
    }

}
