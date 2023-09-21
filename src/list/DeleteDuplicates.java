package list;

import list.util.ListGenerator;
import list.util.ListNode;

public class DeleteDuplicates {
    private ListNode deleteDuplicatesByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            ListNode next = deleteDuplicatesByRecursive(head.next);
            head.next = next;
            return head;
        } else {
            ListNode node = head.next;
            while (node != null && head.val == node.val) {
                node = node.next;
            }
            return deleteDuplicatesByRecursive(node);
        }
    }

    private ListNode deleteDuplicatesByIterative(ListNode head) {
        ListNode dummy = new ListNode(-1, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int value = cur.next.val;
                while (cur.next != null && value == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    private void testCase1() {
        ListNode head = ListGenerator.build(new Integer[] { 1, 1, 3, 5, 2, 2, 4 });
        System.out.println(deleteDuplicatesByRecursive(head));
    }

    private void testCase2() {
        ListNode head = ListGenerator.build(new Integer[] { 1, 1, 3, 5, 2, 2, 4 });
        System.out.println(deleteDuplicatesByIterative(head));
    }

    public static void main(String[] args) {
        new DeleteDuplicates().testCase1();
        new DeleteDuplicates().testCase2();
    }
}
