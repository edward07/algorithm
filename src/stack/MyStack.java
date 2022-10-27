package stack;

import java.util.LinkedList;

public class MyStack {

    private LinkedList<Integer> linkedList;

    public MyStack() {
        linkedList = new LinkedList();
    }

    public void push(int x) {
        linkedList.addLast(x);
    }

    public int pop() {
        return linkedList.removeLast();
    }

    public int top() {
        return linkedList.getLast();
    }

    public boolean empty() {
        if (linkedList == null || linkedList.isEmpty()) {
            return true;
        }
        return false;
    }

}
