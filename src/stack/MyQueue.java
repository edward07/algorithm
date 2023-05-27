package stack;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {

    }

    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        Integer result = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }

    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        Integer result = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;
    }

    public boolean empty() {
        return s1.isEmpty();
    }

}
