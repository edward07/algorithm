package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public Set<ListNode> nodeSet = new HashSet<>();

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        nodeSet.add(head);
        ListNode next = head.next;
        while (next != null) {
            if (nodeSet.contains(next)) {
                return next;
            } else {
                nodeSet.add(next);
            }
            next = next.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        //n3.next = n1;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        DetectCycle detectCycle = new DetectCycle();
        ListNode result = detectCycle.detectCycle(n1);
        System.out.println(result);
    }

}
