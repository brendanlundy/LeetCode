package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem022 {

    public static void main(String[] args) {
        List<String> answers = generateParenthesis(3);
        for (String answer : answers)
            System.out.println(answer);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> answers = new LinkedList<String>();
        char[] answer = new char[n * 2];
        if (n < 1)
            return answers;

        addParenthesis(answers, answer, 0, 0, n);

        return answers;
    }

    private static void addParenthesis(List<String> answers, char[] answer, int numOpens, int numCloses, int maxParens) {
        if (numOpens == maxParens && numCloses == maxParens) {
            //answer is full and ready for check
            if (isValid(answer))
                answers.add(new String(answer));
        } else if (numOpens > numCloses || (numOpens == numCloses && isValid(answer))) {
            int length = answer.length;
            char[] other = new char[length];
            for (int i = 0; i < length; i++)
                other[i] = answer[i];
            if (numOpens < maxParens) {
                other[numOpens + numCloses] = '(';
                addParenthesis(answers, other, numOpens + 1, numCloses, maxParens);
            }
            if (numCloses < maxParens) {
                other[numOpens + numCloses] = ')';
                addParenthesis(answers, other, numOpens, numCloses + 1, maxParens);
            }
        }

    }

    private static boolean isValid(char[] word) {
        int length = word.length;
        Stack<Character> close = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            char c = word[i];
            if (c == '(')
                close.push(')');
            else if (c == ')') {
                if (close.empty())
                    return false;
                else if (c != close.pop())
                    return false;
            }
        }

        if (close.empty())
            return true;
        else
            return false;
    }
}
