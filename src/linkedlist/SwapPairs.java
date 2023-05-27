package linkedlist;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currNode = head;
        ListNode result = head.next;
        ListNode nextNode = head.next;
        ListNode preNode = null;

        while (nextNode != null) {
            // 交互节点
            ListNode nextPairNode = nextNode.next;
            nextNode.next = currNode;
            currNode.next = nextPairNode;
            if (preNode != null) {
                preNode.next = nextNode;
            }
            // 记住上一轮的最后节点位置
            preNode = currNode;

            // 切换到下一组
            currNode = nextPairNode;
            if (currNode == null) {
                break;
            }
            nextNode = currNode.next;
         }

        return result;
    }

    /**
     *  有点松散列表的感觉
     */
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = swapPairsRecursive(head.next.next);
        ListNode next = head.next;

        next.next = head;
        head.next = result;

        return next;
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
        SwapPairs linkedList = new SwapPairs();
        ListNode result = linkedList.swapPairsRecursive(n1);
        System.out.println(result);

    }

}
