package algorithms;

import java.util.Stack;

public class Problem020 {

    public static void main(String[] args) {
        System.out.println(isValid("](){]"));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if (length == 0)
            return true;
        else if (length % 2 == 1)
            return false;

        Stack<Character> close = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(')
                close.push(')');
            else if (c == '{')
                close.push('}');
            else if (c == '[')
                close.push(']');
            else if (c == ')' || c == '}' || c == ']') {
                if (close.empty())
                    return false;
                else if (c != close.pop())
                    return false;
            } else
                return false;
        }

        if (close.empty())
            return true;
        else
            return false;
    }
}
