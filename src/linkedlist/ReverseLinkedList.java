package linkedlist;

import java.util.List;

public class ReverseLinkedList {

    private ListNode lastNode;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        findLast(null, head);
        return lastNode;
    }

    private void findLast(ListNode prev, ListNode curr) {
        if (curr.next == null) {
            lastNode = curr;
            curr.next = prev;
            return;
        }
        findLast(curr, curr.next);
        curr.next = prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(n1);
        ReverseLinkedList linkedList = new ReverseLinkedList();
        linkedList.reverseList(n1);
        System.out.println(linkedList.lastNode);

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}