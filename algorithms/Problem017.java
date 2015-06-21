package algorithms;

import java.util.LinkedList;
import java.util.List;

public class Problem017 {
    public static void main(String[] args) {
        List<String> answers = letterCombinations("23");
        for (String answer : answers)
            System.out.println(answer);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> answers = new LinkedList<String>();
        if (digits.length() == 0)
            return answers;

        letterCombinationsRecurse(answers, digits, new char[] {});

        return answers;
    }

    private static void letterCombinationsRecurse(List<String> answers, String digits, char[] currentWord) {
        if (digits.length() == 0) {
            answers.add(new String(currentWord));
            return;
        }

        int currentWordLength = currentWord.length;
        char[] newWord = new char[currentWordLength + 1];
        for (int i = 0; i < currentWordLength; i++) {
            newWord[i] = currentWord[i];
        }

        String nextDigits = digits.substring(1);
        char[] letters = lettersForDigit(digits.charAt(0));
        for (char letter : letters) {
            newWord[currentWordLength] = letter;
            letterCombinationsRecurse(answers, nextDigits, newWord);
        }
    }

    private static char[] lettersForDigit(char digit) {
        if (digit == '2')
            return new char[] { 'a', 'b', 'c' };
        else if (digit == '3')
            return new char[] { 'd', 'e', 'f' };
        else if (digit == '4')
            return new char[] { 'g', 'h', 'i' };
        else if (digit == '5')
            return new char[] { 'j', 'k', 'l' };
        else if (digit == '6')
            return new char[] { 'm', 'n', 'o' };
        else if (digit == '7')
            return new char[] { 'p', 'q', 'r', 's' };
        else if (digit == '8')
            return new char[] { 't', 'u', 'v' };
        else if (digit == '9')
            return new char[] { 'w', 'x', 'y', 'z' };
        else
            return new char[] {};
    }
}
