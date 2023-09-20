package list.sort;

import list.util.ListGenerator;
import list.util.ListNode;
import list.util.Util;

public class QuickSort {
    public static void main(String[] args) {
        ListNode head = ListGenerator.build(new Integer[] { 2, 12, 1, 0, 5, 6 });
        QuickSort test = new QuickSort();
        System.out.println(test.quickSort(head));
    }

    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 获取中间结点
        ListNode mid = middleNode(head);

        ListNode rightHead = mid.next;
        if (rightHead == null) {
            rightHead = mid;
            head.next = null;
        } else {
            mid.next = null;
        }

        // 左链表排序
        ListNode left = quickSort(head);
        // 右链表排序
        ListNode right = quickSort(rightHead);
        // 合并排序
        return Util.mergeTwoLists(left, right);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
