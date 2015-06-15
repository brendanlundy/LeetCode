package algorithms;

public class Problem013 {
    public static void main(String[] args) {
        //System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int prev = 0;
        for (char c : s.toCharArray()) {
            int val = getValue(c);
            if (val == -1)
                return 0;
            else if (val <= prev)
                sum += val;
            else
                sum += val - (2 * prev);
            prev = val;
        }
        return sum;
    }

    private static int getValue(char c) {
        if (c == 'I')
            return 1;
        else if (c == 'V')
            return 5;
        else if (c == 'X')
            return 10;
        else if (c == 'L')
            return 50;
        else if (c == 'C')
            return 100;
        else if (c == 'D')
            return 500;
        else if (c == 'M')
            return 1000;
        else
            return -1;
    }
}
