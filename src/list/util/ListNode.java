package list.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        if (next != null) {
            return "" + val + "-" + next;
        } else {
            return "" + val;
        }
    }
}
