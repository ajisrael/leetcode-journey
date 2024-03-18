// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8

class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> answer = new ArrayList<>();
       backtrack(answer, "", 0, 0, n);
       return answer;
    }

    private void backtrack(List<String> answer, String current, int left, int right, int max) {
        if (current.length() == max * 2) {
            answer.add(current);
            return;
        }

        if (left < max) {
            backtrack(answer, current + "(", left + 1, right, max);
        }

        if (right < left) {
            backtrack(answer, current + ")", left, right + 1, max);
        }
    }
}
