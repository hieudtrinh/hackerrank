package common;

public class MultiLevelListNodeUtils {
    public static MultiLevelListNode toMultiLevelListNode(Integer[] nums) {
        MultiLevelListNode dummy = new MultiLevelListNode(-1, null, null);
        MultiLevelListNode curr = dummy;
        for (Integer n : nums) {
            curr.next = new MultiLevelListNode(n, null, null);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void print(MultiLevelListNode head) {
        System.out.print(toString(head));
    }

    public static String toString(MultiLevelListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            if (sb.length() > 0) {
                sb.append("->");
            }
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}
