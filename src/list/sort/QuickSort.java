package list.sort;

import list.util.ListGenerator;
import list.util.ListNode;
import list.util.Util;

public class QuickSort {
    public static void main(String[] args) {
        ListNode head = ListGenerator.build(new Integer[] { 2, 12, 1, 10, 5, 6 });
        QuickSort test = new QuickSort();
        System.out.println(test.quickSort(head));
    }

    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 获取中间结点
        ListNode mid = Util.middleNode(head);

        ListNode rightHead = mid.next;

        mid.next = null;

        // 当只有两个节点时的处理
        if (rightHead == null) {
            rightHead = mid;
            head.next = null;
        }

        // 左链表排序
        ListNode left = quickSort(head);
        // 右链表排序
        ListNode right = quickSort(rightHead);
        // 合并排序
        return Util.mergeTwoLists(left, right);
    }
}
