package list;

import list.util.ListGenerator;
import list.util.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = ListGenerator.build(new Integer[] { 1, 2, 3, 4, 5 });

        head = new ReverseList().reverseLinkByIterative(head);
        System.out.println(head);

        head = new ReverseList().reverseLinkByRecursive(head);
        System.out.println(head);
    }

    private ListNode reverseLinkByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = reverseLinkByRecursive(head.next);
        ListNode temp = head;
        head.next.next = head;
        temp.next = null;
        return curNode;
    }

    private ListNode reverseLinkByIterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
