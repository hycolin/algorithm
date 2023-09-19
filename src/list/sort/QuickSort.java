package list.sort;

import list.util.ListGenerator;
import list.util.ListNode;

public class QuickSort {
    public static void main(String[] args) {
        ListNode head = ListGenerator.build(new Integer[] { 3, 4, 1, 2, 5 });
        new QuickSort().quickSort(head);
        System.out.println(head);
    }

    private void quickSort(ListNode head) {
        // 获取中间结点
    }
}
