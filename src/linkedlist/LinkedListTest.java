package linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {
        BookLinkedList bookList = new BookLinkedList();

        BookNode javaBook = new BookNode(1, "Java Design");
        BookNode cppBook  = new BookNode(2, "C++ Design");
        BookNode pythonBook = new BookNode(3, "Python Design");

        bookList.add(javaBook);
        bookList.add(cppBook);
        bookList.add(pythonBook);

        bookList.travel();
    }


}
