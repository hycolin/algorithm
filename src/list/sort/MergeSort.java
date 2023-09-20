package list.sort;

import list.util.ListGenerator;
import list.util.ListNode;
import list.util.Util;

public class MergeSort {
    public static void main(String[] args) {
        ListNode head = ListGenerator.build(new Integer[] { 3, 14, 1, 2, 5, 0, 10 });

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

            // 已经排序后的尾节点
            ListNode prev = dummyHead;

            // 正在排序的首节点
            ListNode cur = dummyHead.next;

            while (cur != null) {
                // 找出左链表
                ListNode left = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 找出右链表
                ListNode right = cur.next;

                // 断开左右链表
                cur.next = null;

                cur = right;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                // 待排序的首节点
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null; // 断开后续链表
                }
                // 合并左右链表
                ListNode merge = Util.mergeTwoLists(left, right);

                // 连接结果
                prev.next = merge;
                while (prev.next != null) {
                    prev = prev.next;
                }

                cur = next;
            }
        }
        return dummyHead.next;
    }
}
