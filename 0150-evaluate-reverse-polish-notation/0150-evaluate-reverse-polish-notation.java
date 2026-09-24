class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 2] = stack[top - 2] + stack[top - 1];
                    top--;
                    break;
                case "-":
                    stack[top - 2] = stack[top - 2] - stack[top - 1];
                    top--;
                    break;
                case "*":
                    stack[top - 2] = stack[top - 2] * stack[top - 1];
                    top--;
                    break;
                case "/":
                    stack[top - 2] = stack[top - 2] / stack[top - 1];
                    top--;
                    break;
                default:
                    stack[top++] = Integer.parseInt(token);
                    break;
            }
        }

        return stack[0];
    }
}