package list.sort;

import list.util.ListGenerator;
import list.util.ListNode;

public class MergeSort {
    public static void main(String[] args) {
        ListNode head = ListGenerator.build(new Integer[] { 3, 4, 1, 2, 5 });

        ListNode result = new MergeSort().mergeSort(head);
        System.out.println(result);
    }

    private ListNode mergeSort(ListNode head) {

        int length = 0;

        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(-1, head);

        for (int subLength = 1; subLength < length; subLength *= 2) {
            // 三个步骤
            // 1. 不停的划分，直到无法划分为止
            // 2. 开始两两合并
            // 3. 每次合并之后的结果都连接起来

            // 找出左链表

            // 找出右链表

            // 合并左右链表

        }

        // // 已经排序后的尾节点
        // ListNode prev = dummy;
        // // 正在排序的首节点
        // ListNode cur = head;
        // // 待排序的首节点
        // ListNode next = head;

        return null;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }
}
