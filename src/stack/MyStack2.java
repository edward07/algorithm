package stack;

import java.util.ArrayDeque;


public class MyStack2 {

    private ArrayDeque<Integer> inQueue = new ArrayDeque<Integer>();
    private ArrayDeque<Integer> outQueue = new ArrayDeque<Integer>();;

    public MyStack2() {

    }

    public void push(int x) {
        inQueue.add(x);
        outQueue.offer()
    }

    public int pop() {
        Integer lastElement = null;
        if (empty()) {
            return lastElement;
        }
        while (!inQueue.isEmpty())  {
            lastElement = inQueue.pop();
            if (inQueue.isEmpty()) {
                return lastElement;
            }
            outQueue.add(lastElement);
        }
        if (lastElement != null) {
            return lastElement;
        }
        while (!outQueue.isEmpty()) {
            lastElement = outQueue.pop();
            if (outQueue.isEmpty()) {
                return lastElement;
            }
            inQueue.add(lastElement);
        }
        return lastElement;
    }

    public int top() {
        Integer lastElement = null;
        if (empty()) {
            return lastElement;
        }
        while (!inQueue.isEmpty())  {
            lastElement = inQueue.pop();
            outQueue.add(lastElement);
        }
        if (lastElement != null) {
            return lastElement;
        }
        while (!outQueue.isEmpty()) {
            lastElement = outQueue.pop();
            inQueue.add(lastElement);
        }
        return lastElement;
    }

    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 myStack2  = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);

        System.out.println(myStack2.top());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.top());
        System.out.println(myStack2.empty());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.empty());
    }

}
