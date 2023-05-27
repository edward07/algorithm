package linkedlist;

public class ReverseList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(node1);
        reverse(node1);
        System.out.println(node4);
    }

    public static void printList(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.println(current);
            current = node.next;
        }
    }

    public static void reverse(ListNode node) {
            ListNode pre = null;
            ListNode current = node;
            ListNode next = node.next;

            while (next != null) {
                pre = current;
                current = next;
                next = current.next;
                current.next = pre;
            }
    }


}
