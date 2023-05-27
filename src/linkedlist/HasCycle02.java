package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle02 {

    public static void main(String[] args) {
        ListNode02 node1 = new ListNode02(1);
        ListNode02 node2 = new ListNode02(2);
        ListNode02 node3 = new ListNode02(3);
        ListNode02 node4 = new ListNode02(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode02 head) {
            Set<ListNode02> nodeSet = new HashSet<>();
            if (head == null) {
                return false;
            }
            nodeSet.add(head);
            ListNode02 next = head.next;
            while (next != null) {
                if (nodeSet.contains(next)) {
                    return true;
                }
                nodeSet.add(next);
                next = next.next;
            }
            return false;
    }
}

class ListNode02 {
    int val;
    ListNode02 next;
    ListNode02(int x) {
        val = x;
        next = null;
    }
}