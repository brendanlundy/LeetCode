package algorithms;

public class Problem009 {
    public static void main(String[] args) {
        //System.out.println(isPalindrome(737));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String y = Integer.toString(x);
        int length = y.length();
        for (int i = 0; i < length / 2; i++) {
            if (y.charAt(i) != y.charAt(length - i - 1))
                return false;
        }
        return true;
    }
}
