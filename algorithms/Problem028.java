package algorithms;

public class Problem028 {

    public static void main(String[] args) {
        System.out.println(strStr("what", "hat"));

    }

    public static int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (haystackLength == 0 && needleLength == 0)
            return 0;

        for (int i = 0; i < haystackLength; i++) {
            if (i > (haystackLength - needleLength))
                break;

            boolean found = true;
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found)
                return i;
        }

        return -1;
    }
}
