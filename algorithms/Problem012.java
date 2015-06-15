package algorithms;

import java.util.Arrays;

public class Problem012 {

    public static void main(String[] args) {
        //System.out.println(intToRoman(3000));
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999)
            return "";
        int length = String.valueOf(num).length();
        String[] answer = new String[length];

        int place = 0;
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            answer[length - place - 1] = digitToRoman(digit, place);
            place++;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : answer)
            sb.append(s);
        return sb.toString();
    }

    private static String digitToRoman(int digit, int place) {
        char[] chars = new char[3];
        if (place == 0) {
            chars[0] = 'I';
            chars[1] = 'V';
            chars[2] = 'X';
        } else if (place == 1) {
            chars[0] = 'X';
            chars[1] = 'L';
            chars[2] = 'C';
        } else if (place == 2) {
            chars[0] = 'C';
            chars[1] = 'D';
            chars[2] = 'M';
        } else if (place == 3) {
            chars[0] = 'M';
            chars[1] = ' ';
            chars[2] = ' ';
        }

        if (digit == 1) {
            return new String(new char[] { chars[0] });
        } else if (digit == 2) {
            return new String(new char[] { chars[0], chars[0] });
        } else if (digit == 3) {
            return new String(new char[] { chars[0], chars[0], chars[0] });
        } else if (digit == 4) {
            return new String(new char[] { chars[0], chars[1] });
        } else if (digit == 5) {
            return new String(new char[] { chars[1] });
        } else if (digit == 6) {
            return new String(new char[] { chars[1], chars[0] });
        } else if (digit == 7) {
            return new String(new char[] { chars[1], chars[0], chars[0] });
        } else if (digit == 8) {
            return new String(new char[] { chars[1], chars[0], chars[0], chars[0] });
        } else if (digit == 9) {
            return new String(new char[] { chars[0], chars[2] });
        } else
            return "";
    }
}
