package link.util;

public class LinkGenerator {
    public static void main(String[] args) {
        LinkNode head = build(new Integer[] { 1, 2, 3, 4 });
        System.out.println(head);
    }

    public static LinkNode build(Integer[] data) {
        LinkNode dummy = new LinkNode(-1);
        LinkNode curNode = dummy;
        for (Integer val : data) {
            LinkNode node = new LinkNode(val);
            curNode.next = node;
            curNode = node;
        }
        return dummy.next;
    }
}
