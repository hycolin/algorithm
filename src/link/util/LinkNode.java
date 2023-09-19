package link.util;

public class LinkNode {
    int val;
    public LinkNode next;

    public LinkNode(int val) {
        this.val = val;
        this.next = null;
    }

    public String toString() {
        return "" + val + "-" + next;
    }
}
