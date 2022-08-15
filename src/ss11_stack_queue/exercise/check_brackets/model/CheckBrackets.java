package ss11_stack_queue.exercise.check_brackets.model;

import java.util.Stack;

public class CheckBrackets {
    private static final Stack<Character> stack = new Stack<>();

    public CheckBrackets() {
    }

    public static boolean checkBracket(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
            }
            if (string.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
