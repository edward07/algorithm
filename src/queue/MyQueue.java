package queue;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> mainStack;
    private Stack<Integer> helpStack;

    public MyQueue() {
        mainStack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        while (!mainStack.isEmpty()) {
            helpStack.push(mainStack.pop());
        }

        Integer val = helpStack.pop();

        while (!helpStack.isEmpty()) {
            mainStack.push(helpStack.pop());
        }

        return val;
    }

    public int peek() {
        while (!mainStack.isEmpty()) {
            helpStack.push(mainStack.pop());
        }

        Integer val = helpStack.peek();

        while (!helpStack.isEmpty()) {
            mainStack.push(helpStack.pop());
        }

        return val;
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }

}
