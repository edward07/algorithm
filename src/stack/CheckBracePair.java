package stack;

import java.util.Stack;

/**
 * leetcode  20
 */
public class CheckBracePair {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(current);
            } else {
                // 后面紧跟的字符能配对
                Character top = stack.peek();
                if (top == '(' && current == ')' ) {
                    stack.pop();
                    continue;
                }
                if (top == '{' && current == '}') {
                    stack.pop();
                    continue;
                }
                if (top == '[' && current == ']') {
                    stack.pop();
                    continue;
                }
                // 后面紧跟的字符不能配对,如果是左边的字符，则入栈，延迟判断， 如果是右侧的字符，则直接不合法
                boolean topIsLeft = false;
                if (top == '(' || top == '{' || top == '[') {
                    topIsLeft = true;
                }
                boolean currentIsLeft = false;
                if (current == '(' || current == '{' || current == '[') {
                    currentIsLeft = true;
                }
                if (topIsLeft && currentIsLeft) {
                    stack.push(current);
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
