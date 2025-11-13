import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>(); // use Long to prevent overflow during calc

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-": {
                    long b = stack.pop();
                    long a = stack.pop();
                    stack.push(a - b);
                    break;
                }

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/": {
                    long b = stack.pop();
                    long a = stack.pop();
                    stack.push(a / b); // Java auto truncates toward zero
                    break;
                }

                default:
                    stack.push(Long.parseLong(token));
            }
        }

        return stack.pop().intValue();
    }
}
