package linkedlist;

/**
 * 链表中是否有环
 */
public class HasCycle {

    private ListNode globalFirstNode;

    public boolean hasCycle(ListNode head) {
        if (globalFirstNode == null) {
            globalFirstNode = head;
        }

        if (head == null || head.next == null) {
            return false;
        }

        ListNode next = globalFirstNode.next;
        while (next != null) {
            ListNode result = checkCycle(globalFirstNode, next);
            if (result != null) {
                return true;
            }
            next = next.next;
        }

        return false;
    }

    public ListNode checkCycle(ListNode globalHeadNode, ListNode curr) {
        if (globalHeadNode == null || curr == null) {
            return null;
        }

        ListNode currGlobalNode = globalHeadNode;
        while (currGlobalNode != null && currGlobalNode != curr) {
            if (curr.next == currGlobalNode) {
                return currGlobalNode;
            }
            currGlobalNode = currGlobalNode.next;
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

        HasCycle hasCycle = new HasCycle();
        boolean result = hasCycle.hasCycle(n1);
        System.out.println(result);
    }

}
