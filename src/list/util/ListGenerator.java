package list.util;

public class ListGenerator {
    public static void main(String[] args) {
        ListNode head = build(new Integer[] { 1, 2, 3, 4 });
        System.out.println(head);
    }

    public static ListNode build(Integer[] data) {
        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        for (Integer val : data) {
            ListNode node = new ListNode(val);
            curNode.next = node;
            curNode = node;
        }
        return dummy.next;
    }
}
