package algorithms;

public class Problem029 {

    public static void main(String[] args) {
        System.out.println(divide(-1, -1));

    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        //check for overflow
        else if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long posDividend = Math.abs((long) dividend);
        long posDivisor = Math.abs((long) divisor);

        int answer = 0;
        while (posDividend >= posDivisor) {
            int nums = 0;
            long temp;
            while (posDividend >= (posDivisor << nums)) {
                temp = posDivisor << nums;
                nums++;
            }

            answer += 1 << (nums - 1);
            posDividend -= (posDivisor << (nums - 1));
        }

        if ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0))
            return answer;
        else
            return -answer;
    }

    public static int divideFirstAttempt(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        else if (divisor == 1)
            return dividend;
        else if (divisor == -1)
            return -dividend;

        boolean neg = false;
        if (divisor < 0) {
            neg = true;
            divisor *= -1;
        }

        int numDivides = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            numDivides++;
        }
        if (neg)
            return -numDivides;
        else
            return numDivides;
    }
}
