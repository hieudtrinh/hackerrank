package common;

public class MultiLevelListNode {
    public int val;
    public MultiLevelListNode next;
    public MultiLevelListNode child;

    public MultiLevelListNode(int val, MultiLevelListNode next, MultiLevelListNode child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }
}
