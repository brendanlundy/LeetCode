package algorithms;

public class Problem005 {

    public static void main(String[] args) {
        //System.out.println(longestPalindrome("bookcasac"));
        //System.out.println(longestPalindrome("nypdmqqgauepeyfvwcdpbmmaxfwxmmtswfuwldtvqcisywalfnvovuordczxlyzqmslxilpnenbuwbcpebneovitwkkswsijajnkwkfbxnulmwotgrmpklntfyjavccbrgwqynryeoswmhsqzcwnudkuvfkikjxjkjpghsytjfkpvkjpvblamdeegeohospporbtorkbuggbawgodhxpscfksjbirxvjyjapwwushmnqsxktnslvonlwvuseinrmwvfqjgzpkwcqfzfdbbmcngmsoeegudwjvldqmaomwbqvijesnpxiqvtfeiqebrfjhtvjdwkopyfzaslewdjnkmalvfinbuouwcgnfecjtdzwycxrynxepbcsroyzrsgiiuaszvatwyuxinwhni"));
        //System.out.println(isPalindrome(""));
    }

    public static String longestPalindrome(String s) {
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
