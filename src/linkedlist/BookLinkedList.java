package linkedlist;

/**
 * 反转列表
 */
public class BookLinkedList {

    private BookNode head;

    public void add(BookNode node) {
        if (head == null) {
            head = node;
            return;
        }

        BookNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = node;
    }

    public void travel() {
        if (head == null) {
            System.out.println("head is null");
            return;
        }

        BookNode currNode = head;
        System.out.println(currNode);
        while (currNode.next != null) {
            System.out.println(currNode.next);
            currNode = currNode.next;
        }
    }
}

class BookNode {
    int bookNo;
    String bookName;
    BookNode next;
    public BookNode(int bookNo, String bookName) {
        this.bookName = bookName;
        this.bookNo = bookNo;
    }

    @Override
    public String toString() {
        return "BookNode{" +
                "bookNo=" + bookNo +
                ", bookName='" + bookName + "'}";
    }
}