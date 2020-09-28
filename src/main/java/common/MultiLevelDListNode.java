package common;

public class MultiLevelDListNode {
    public int val;
    public MultiLevelDListNode prev;
    public MultiLevelDListNode next;
    public MultiLevelDListNode child;

    public MultiLevelDListNode(int val, MultiLevelDListNode prev, MultiLevelDListNode next, MultiLevelDListNode child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
