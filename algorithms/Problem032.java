package algorithms;

import java.util.Stack;

public class Problem032 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(longestValidParentheses(")()())"));
        //System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
        //System.out.println(longestValidParentheses("(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("));
        long time = System.nanoTime() - startTime;
        System.out.println(time * 0.000000001);

    }

    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new int[] { i, 0 });
            } else {
                if (stack.empty() || stack.peek()[1] == 1) {
                    stack.push(new int[] { i, 1 });
                } else {
                    stack.pop();
                    int currentLen = 0;
                    if (stack.empty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - stack.peek()[0];
                    }
                    longest = Math.max(longest, currentLen);
                }
            }
        }

        return longest;
    }

    public static int longestValidParenthesesFirst(String s) {
        int longest = 0;
        int slength = s.length();
        int i = 0;
        while (i < slength) {
            if ((slength - i) <= longest)
                return longest;
            int numOpen = 0;
            int numClose = 0;
            boolean brokeEarly = false;
            int maxLength = (slength - i) / 2;
            int j = i;
            while (j < slength) {
                char c = s.charAt(j);
                if (c == '(')
                    numOpen++;
                else
                    numClose++;

                if (numClose > numOpen || numOpen > maxLength) {
                    brokeEarly = true;
                    break;
                } else if (numClose == numOpen) {
                    if (numClose * 2 > longest)
                        longest = numClose * 2;
                }
                j++;
            }
            if (brokeEarly)
                i = j + 1;
        }

        return longest;
    }
}
