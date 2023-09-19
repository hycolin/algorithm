package link;

import link.util.LinkGenerator;
import link.util.LinkNode;

public class ReverseLink {
    public static void main(String[] args) {
        LinkNode head = LinkGenerator.build(new Integer[] { 1, 2, 3, 4, 5 });

        head = new ReverseLink().reverseLinkByIterative(head);
        System.out.println(head);

        head = new ReverseLink().reverseLinkByRecursive(head);
        System.out.println(head);
    }

    private LinkNode reverseLinkByRecursive(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode curNode = reverseLinkByRecursive(head.next);
        LinkNode temp = head;
        head.next.next = head;
        temp.next = null;
        return curNode;
    }

    private LinkNode reverseLinkByIterative(LinkNode head) {
        LinkNode prev = null;
        while (head != null) {
            LinkNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
