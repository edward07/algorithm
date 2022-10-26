package stack;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            Character top = stack.peek();
            if (isMatch(top, c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(Character left, Character right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()[]{}"));
        System.out.println(isValid.isValid("{[]}"));
    }

}

