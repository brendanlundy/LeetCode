package algorithms;

public class Problem005 {

    public static void main(String[] args) {
        /*
        long startTime = System.nanoTime();
        //System.out.println(longestPalindrome("bookcasac"));
        //System.out.println(longestPalindrome("nypdmqqgauepeyfvwcdpbmmaxfwxmmtswfuwldtvqcisywalfnvovuordczxlyzqmslxilpnenbuwbcpebneovitwkkswsijajnkwkfbxnulmwotgrmpklntfyjavccbrgwqynryeoswmhsqzcwnudkuvfkikjxjkjpghsytjfkpvkjpvblamdeegeohospporbtorkbuggbawgodhxpscfksjbirxvjyjapwwushmnqsxktnslvonlwvuseinrmwvfqjgzpkwcqfzfdbbmcngmsoeegudwjvldqmaomwbqvijesnpxiqvtfeiqebrfjhtvjdwkopyfzaslewdjnkmalvfinbuouwcgnfecjtdzwycxrynxepbcsroyzrsgiiuaszvatwyuxinwhni"));
        //System.out.println(isPalindrome(""));
        System.out.print((System.nanoTime() - startTime) * 0.000000001);
        System.out.println(" Seconds");
        */
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        int best = 0;
        String bestPal = "";

        for (int i = 0; i < (length * 2) - 1; i++) {
            if (i % 2 == 0) {
                if (Math.min(i + 1, (length - (i / 2)) * 2 - 1) > best) {
                    String tempBestPal = longestPalindromeCenteredAt(s, i / 2, i / 2);
                    if (tempBestPal.length() > best) {
                        best = tempBestPal.length();
                        bestPal = tempBestPal;
                    }
                }
            } else {
                if (Math.min(i + 1, (length - 1 - (i / 2)) * 2) > best) {
                    String tempBestPal = longestPalindromeCenteredAt(s, (i - 1) / 2, (i + 1) / 2);
                    if (tempBestPal.length() > best) {
                        best = tempBestPal.length();
                        bestPal = tempBestPal;
                    }
                }
            }
        }

        return bestPal;
    }

    private static String longestPalindromeCenteredAt(String s, int center1, int center2) {
        int length = s.length();
        while (center1 >= 0 && center2 < length) {
            if (s.charAt(center1) == s.charAt(center2)) {
                center1--;
                center2++;
            } else
                break;
        }

        return s.substring(center1 + 1, center2);
    }

    public static String longestPalindromeSecondAttempt(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int length = s.length();
        int lengthOfPal = length;
        while (lengthOfPal > 0) {
            int numPossiblePals = length - lengthOfPal + 1;
            for (int i = 0; i < numPossiblePals; i++) {
                if (s.substring(i, i + lengthOfPal).equals(reversed.substring(length - lengthOfPal - i, length - i)))
                    return s.substring(i, i + lengthOfPal);
            }
            lengthOfPal--;
        }
        return "";
    }

    public static String longestPalindromeFirstAttempt(String s) {
        int lengthOfPal = s.length();
        while (lengthOfPal > 0) {
            int numPossiblePals = s.length() - lengthOfPal + 1;
            for (int i = 0; i < numPossiblePals; i++) {
                if (isPalindrome(s.substring(i, i + lengthOfPal)))
                    return s.substring(i, i + lengthOfPal);
            }
            lengthOfPal--;
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        boolean even = s.length() % 2 == 0;
        int p1 = s.length() / 2;
        int p2 = p1;
        if (even)
            p1--;
        else {
            p1--;
            p2++;
        }

        while (p1 >= 0 && p2 < s.length()) {
            if (s.charAt(p1) != s.charAt(p2))
                return false;
            p1--;
            p2++;
        }
        return true;
    }
}
