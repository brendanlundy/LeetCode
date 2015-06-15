package algorithms;

public class Problem008 {

    public static void main(String[] args) {
        //System.out.println(myAtoi("1095502006p8"));
    }

    public static int myAtoi(String str) {
        String min = Integer.toString(Integer.MIN_VALUE);
        String max = Integer.toString(Integer.MAX_VALUE);
        int maxLength = max.length();

        StringBuilder sb = new StringBuilder();
        boolean numberStarted = false;
        boolean hasDigits = false;
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isDigit = false;
            if (c >= '0' && c <= '9') {
                isDigit = true;
            }

            if (!numberStarted) {
                if (isDigit) {
                    numberStarted = true;
                    hasDigits = true;
                    sb.append(c);
                } else if (c == '-') {
                    numberStarted = true;
                    isNegative = true;
                    maxLength++;
                    sb.append(c);
                } else if (c == '+') {
                    numberStarted = true;
                } else if (c != ' ')
                    return 0;
            } else {
                if (isDigit) {
                    hasDigits = true;
                    sb.append(c);
                    if (sb.length() > maxLength) {
                        if (isNegative)
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                } else if (c != ',')
                    break;
            }

        }

        //check for overflow
        String s = sb.toString();
        if (isNegative) {
            if (overflow(s, min))
                return Integer.MIN_VALUE;
        } else {
            if (overflow(s, max))
                return Integer.MAX_VALUE;
        }

        if (!hasDigits)
            return 0;
        else
            return Integer.parseInt(s);
    }

    private static boolean overflow(String str, String otherNum) {
        if (str.length() < otherNum.length())
            return false;
        else if (str.length() == otherNum.length()) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > otherNum.charAt(i))
                    return true;
                else if (str.charAt(i) < otherNum.charAt(i))
                    return false;
            }
            return false;
        } else
            return true;
    }
}