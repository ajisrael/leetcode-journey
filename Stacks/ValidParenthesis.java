package Stacks;

import java.util.*;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.size() > 0){ // must be a closing bracket
                char pop = stack.pop();
                if ((c == ')' && pop != '(') ||
                        (c == '}' && pop != '{') ||
                        (c == ']' && pop != '[')) {
                    return false;
                }
            } else { // must be closing bracket without starting one
                return false;
            }
        }
        return stack.size() == 0;
    }
}
