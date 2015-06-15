package algorithms;

public class Problem007 {

    public static void main(String[] args) {
        /*
        System.out.println(reverseStr(-53));
        System.out.println(reverse(-1463847412));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        */
    }

    public static int reverse(int x) {
        int sum = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int mod = x % 10;
            if (sum > max)
                return 0;
            else if (sum == max) {
                if (mod > Integer.MAX_VALUE % 10)
                    return 0;
            } else if (sum < min)
                return 0;
            else if (sum == min) {
                if (mod < Integer.MIN_VALUE % 10)
                    return 0;
            }

            sum = sum * 10 + mod;
            x = x / 10;
        }

        return sum;
    }

    public static int reverseStr(int x) {
        String str = Integer.toString(x);
        StringBuilder sb = new StringBuilder();

        int length = str.length();
        boolean neg = false;
        int end = length - 1;
        if (str.charAt(0) == '-') {
            if (length == 2)
                return x;
            sb.append('-');
            neg = true;
        } else if (length == 1)
            return x;

        while (end >= 0) {
            if (end == 0) {
                if (neg)
                    break;
            }
            sb.append(str.charAt(end));
            end--;
        }
        String answer = sb.toString();

        if (neg) {
            String min = Integer.toString(Integer.MIN_VALUE);
            if (answer.length() > min.length())
                return 0;
            else if (answer.length() == min.length()) {
                for (int i = 1; i < min.length(); i++) {
                    if (answer.charAt(i) > min.charAt(i))
                        return 0;
                    else if (answer.charAt(i) < min.charAt(i))
                        break;
                }
            }
        } else {
            String max = Integer.toString(Integer.MAX_VALUE);
            if (answer.length() > max.length())
                return 0;
            else if (answer.length() == max.length()) {
                for (int i = 0; i < max.length(); i++) {
                    if (answer.charAt(i) > max.charAt(i))
                        return 0;
                    else if (answer.charAt(i) < max.charAt(i))
                        break;
                }
            }
        }

        return Integer.parseInt(answer);
    }
}
