package Stacks;

import java.util.*;

public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        String[] tokens2 = {"4","13","5","/","+"};
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int result = evalRPN(tokens);
        System.out.println(result);
        int result2 = evalRPN(tokens2);
        System.out.println(result2);
        int result3 = evalRPN(tokens3);
        System.out.println(result3);
    }

    public static int evalRPN(String[] tokens) {
        int answer = 0;
        Stack<Integer> numStack = new Stack<>();
        HashSet<String> operands = new HashSet<>();

        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        boolean firstOperand = true;

        for (String token : tokens) {
            if (operands.contains(token)) {
                if (firstOperand) {
                    answer = numStack.pop();
                    firstOperand = false;
                }
                if (token == "+") {
                    answer = numStack.pop() + answer;
                } else if (token == "-") {
                    answer = numStack.pop() - answer;
                } else if (token == "*") {
                    answer = numStack.pop() * answer;
                } else if (token == "/") {
                    answer = numStack.pop() / answer;
                }
            } else {
                numStack.push(Integer.valueOf(token));
            }
            System.out.printf("Answer: %d, Token: %s\n", answer, token);
        }

        return answer;
    }
}
