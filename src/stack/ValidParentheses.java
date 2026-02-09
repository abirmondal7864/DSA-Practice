package stack;

import java.util.Stack;

class ValidParentheses {

    /**
     * Checks if the given string has valid parentheses.
     * Uses stack to match opening brackets with correct closing ones.
     *
     * @param s input string containing (), {}, []
     * @return true if parentheses are valid, else false
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        // traverse each character
        for (char ch : s.toCharArray()) {

            // push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // handle closing brackets
            else {
                // no opening bracket to match
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // mismatch check
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // valid only if no extra opening brackets left
        return stack.isEmpty();
    }
}
